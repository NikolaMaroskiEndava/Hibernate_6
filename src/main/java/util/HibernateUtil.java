package util;

import model.Department;
import model.Factory;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry standardServiceRegistry;

    static {
        if(sessionFactory == null) {
            try {
                Configuration cfg = new Configuration().configure();
                cfg.addResource("model/Employee.hbm.xml");
                cfg.addAnnotatedClass(Department.class);
                cfg.addAnnotatedClass(Factory.class);

                standardServiceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(cfg.getProperties())
                        .build();
                sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
            }catch (Exception e) {
                e.printStackTrace();
                if(standardServiceRegistry != null){
                    StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
                }
            }
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
