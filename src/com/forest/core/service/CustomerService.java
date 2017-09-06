package com.forest.core.service;

import com.forest.core.pojo.Customer;
import com.forest.core.pojo.QueryVo;

import cn.forest.common.utils.Page;

public interface CustomerService {
	public Page<Customer> getCustomerList(QueryVo queryVo);
	public Customer getCustomerById(Long id);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Long id);
}
