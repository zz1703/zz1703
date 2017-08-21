package com.qf;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		Session session=SessionUtils.getSession();
//		开启事务
		Transaction transaction=session.beginTransaction();
//		执行操作 增加
		Student student=new Student();
		student.setName("zhangsan");
		student.setAge(20);
		student.setAddress("zhengzhou");
//		session.save(student);
		//更新
		student.setName("lisi");
		student.setId(1);
		session.update(student);
		//提交事物
		transaction.commit();
		session.close();
		
	}
}
