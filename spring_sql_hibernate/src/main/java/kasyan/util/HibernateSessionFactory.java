package kasyan.util;

import kasyan.bean.BuyProduct;
import kasyan.bean.Person;
import kasyan.bean.Product;
import kasyan.bean.ProductOfDelete;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = loadProperties();
                Connection conn = getConnection();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Person.class);
                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(BuyProduct.class);
                configuration.addAnnotatedClass(ProductOfDelete.class);
                ServiceRegistry serviceRegistry = new
                        StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream in = new FileInputStream("src/main/resources/application.properties")) {
            properties.load(in);
        } catch (Exception ex) {
            return null;
        }
        return properties;
    }

    private static Connection getConnection() {
        Properties properties = loadProperties();
        Connection conn = null;
        try (InputStream in = new FileInputStream("src/main/resources/application.properties")) {
            properties.load(in);
            Class.forName(properties.getProperty("DRIVER"));
            conn = DriverManager.getConnection(properties.getProperty("URL"),
                    properties.getProperty("LOGIN"), properties.getProperty("PASSWORD"));
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}