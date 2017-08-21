package com.qf;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionUtils {
	public static Session getSession(){
//		1创建Configuration对象封装Hibernate的配置信息。
//		注意：仅通过构造器创建Configuration对象读取不到配置信息，还需要再调用configure()方法加载配置文件。
		Configuration cfg=new Configuration().configure();
//		2创建ServiceRegistry对象用于注册Hibernate配置信息
//			1.创建构建ServiceRegistry对象的ServiceRegistryBuilder对象
			ServiceRegistryBuilder builder=new ServiceRegistryBuilder();
//			2通过builder对象接收configuration对象中封装的配置信息
			builder.applySettings(cfg.getProperties());
//			3通过builder对象构建ServiceRegistry对象
			ServiceRegistry serviceRegistry=builder.buildServiceRegistry();
//		3通过Configuration对象创建SessionFactory对象
			SessionFactory factory=cfg.buildSessionFactory(serviceRegistry);
			
		
		return factory.openSession();
	}
}
