package Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
public class HibernateUtils {
	private static final SessionFactory SESSION_FACTORY;
	static {
		try {
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			System.err.println(e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {

		return SESSION_FACTORY;
	}

  public static void shutdown() {
      // Giải phóng cache và Connection Pools.
      getSessionFactory().close();
  }
 
}