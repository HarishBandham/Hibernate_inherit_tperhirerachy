package com.hibernate.tperHierarchy;

import com.hibernate.tperHierarchy.entity.ContractEmployee;
import com.hibernate.tperHierarchy.entity.Employee;
import com.hibernate.tperHierarchy.entity.HibernateUtil;
import com.hibernate.tperHierarchy.entity.PermanentEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class HibernateTablePerHierarchyApplication {

	public static void main(String[] args) {
		//Get session factory using Hibernate Util class
		SessionFactory sf = HibernateUtil.getSessionFactory();

		//Get session from Sesson factory
		Session session = sf.openSession();
		//Begin transaction
		Transaction t=session.beginTransaction();

		//Creating Employee base class record
		Employee employee=new Employee();
		employee.setName("John");

		//Creating Permanent Employee subclass record
		PermanentEmployee permanentEmployee=new PermanentEmployee();
		permanentEmployee.setName("Jacob");
		permanentEmployee.setSalary(30000);

		//Creating Contract Employee subclass record
		ContractEmployee contractEmployee=new ContractEmployee();
		contractEmployee.setName("Raj");
		contractEmployee.setHourlyrate(2000);

		//persist all the employee records
		session.persist(employee);
		session.persist(permanentEmployee);
		session.persist(contractEmployee);

		//Commit the transaction and close the session
		t.commit();
		session.close();
		System.out.println("successfully persisted all the Employee records");
	}

}
