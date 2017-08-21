package com.qianfeng.benas;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	public static void main(String[] args) {
		InputStream in=Test.class.getClassLoader().getResourceAsStream("mybatis_config.xml");
		
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		SqlSession session=factory.openSession();
		List<Customer> list=session.selectList("com.qianfeng.benas.CustomerMapper.all");
		for (Customer customer : list) {
			System.out.println(customer.getCustName()+"  "+customer.getCustAge());
		}
	}
}
