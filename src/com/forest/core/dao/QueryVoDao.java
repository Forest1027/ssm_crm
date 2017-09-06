package com.forest.core.dao;

import java.util.List;

import com.forest.core.pojo.Customer;
import com.forest.core.pojo.QueryVo;

public interface QueryVoDao {
	public List<Customer> getCustomerList(QueryVo queryVo);
	public Integer getCustomerListCount(QueryVo queryVo);
	public Customer getCustomerById(Long id);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Long id);
}
