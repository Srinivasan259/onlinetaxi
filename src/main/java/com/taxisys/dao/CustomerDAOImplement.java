package com.taxisys.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taxisys.enity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class CustomerDAOImplement implements CustomerDAO{

	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllcustomers() {
		return entityManager.createQuery("from Customer").getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> findAllCustomerIds() {
		Query q = entityManager.createQuery("SELECT c.customerId FROM Customer c");
		List<Integer> list = q.getResultList();
		return list;

	}

	@Override
	public Customer findCustomerId(int customerId) {
		return entityManager.find(Customer.class, customerId);

	}

}
