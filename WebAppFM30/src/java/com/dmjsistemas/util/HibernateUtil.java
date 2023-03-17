package com.dmjsistemas.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static final SessionFactory sf = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError(e);
        }

    }

    public static SessionFactory getSessionFactory() {
        return sf;
    }

//    private void shutdown() {
//        getSessionFactory().close();
//
//    }

//    private static SessionFactory sf = null;
//
//    static {
//        try {
//            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
//                    .build();
//            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
//            sf = metadata.getSessionFactoryBuilder().build();
//        } catch (Exception e) {
//
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sf;
//    }
}
