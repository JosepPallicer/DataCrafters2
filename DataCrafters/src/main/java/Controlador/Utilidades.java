package Controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utilidades  {
    static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Crear SessionFactory desde hibernate.cfg.xml
            System.out.println("La creación de la sesión ha sido un éxito");
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("La creación de la SessionFactory falló." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
