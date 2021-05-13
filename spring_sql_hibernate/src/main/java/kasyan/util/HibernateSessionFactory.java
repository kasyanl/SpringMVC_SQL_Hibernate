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
import java.io.InputStream;
import java.util.Properties;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = loadProperties();
                assert settings != null;
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Person.class);
                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(BuyProduct.class);
                configuration.addAnnotatedClass(ProductOfDelete.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

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
}