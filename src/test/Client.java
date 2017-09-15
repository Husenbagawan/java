package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



import beans.Student1;

public class Client {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("resources/oracle.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		
		System.out.println("using First session");
		Student1 st1=(Student1)session.get(Student1.class,10);
		System.out.println(st1.getName());
		System.out.println(st1.getEmail());
		
		Student1 st2=(Student1)session.get(Student1.class,10);
		System.out.println(st2.getName());
		System.out.println(st2.getEmail());
		
		System.out.println("using second session");
		Session session2=sf.openSession();
		Student1 st3=(Student1)session2.get(Student1.class,10);
		System.out.println(st3.getName());
		System.out.println(st3.getEmail());
		
		
		
		
		
		
		
		
		session.close();
		sf.close();
	}
}
