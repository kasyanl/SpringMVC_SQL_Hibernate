package kasyan.repository;

import kasyan.bean.Person;
import kasyan.bean.Product;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Slf4j
public class RepositoryService {

// подключение к БД
    private static Connection getConnection(){
        Properties properties = new Properties();
        Connection conn = null;
        try (InputStream in = new FileInputStream("src/main/resources/application.properties")){
            properties.load(in);
            Class.forName(properties.getProperty("DRIVER"));
            conn = DriverManager.getConnection(properties.getProperty("URL"),
                    properties.getProperty("LOGIN"), properties.getProperty("PASSWORD"));
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //запрос на вывод Product данных из БД (формирование List)
    public List<Product> findProductFromBD(String sqlSelect) throws SQLException {
        List<Product> productList = new ArrayList<>();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlSelect);
            //формирование List Product из БД
            while (rs.next()) {
                int id = rs.getInt("id");
                String category = rs.getString("category");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                double discount = rs.getDouble("discount");
                double actualPrice = rs.getDouble("actualPrice");
                double totalVolume = rs.getDouble("totalVolume");
                String data = rs.getString("data");
                productList.add(new Product(id, category, name, price, discount, actualPrice, totalVolume, data));
            }
            rs.close();
            statement.close();
            conn.close();
        return productList;
    }

    //запрос на изменение (удаление, добавлене, обновление) Product в БД
    public void selectBD(String sqlSelect) throws SQLException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
            int rs = statement.executeUpdate(sqlSelect);
            log.info("Product is {}", rs);
            statement.close();
            conn.close();
    }

    //запрос на вывод Product данных из списка покупок (формирование List)
    public static List<Product> findBuyProductFromBD(String sqlSelect) throws SQLException {
        List<Product> productListDel = new ArrayList<>();
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sqlSelect);
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double actualPrice = rs.getDouble("actualPrice");
            double quantity = rs.getDouble("quantity");
            double totalPrice = rs.getDouble("totalPrice");
            productListDel.add(new Product(id, name, actualPrice, totalPrice, quantity));
        }
        rs.close();
        statement.close();
        conn.close();
        return productListDel;
    }
}