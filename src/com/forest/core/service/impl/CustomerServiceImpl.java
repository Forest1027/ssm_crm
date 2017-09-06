package com.forest.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.core.dao.QueryVoDao;
import com.forest.core.pojo.Customer;
import com.forest.core.pojo.QueryVo;
import com.forest.core.service.CustomerService;

import cn.forest.common.utils.Page;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private QueryVoDao queryVoDao;

	@Override
	public Page<Customer> getCustomerList(QueryVo queryVo) {
		if (queryVo.getPage()!=null) {
			queryVo.setStart((queryVo.getPage()-1)*queryVo.getSize());
		}
		List<Customer> list = queryVoDao.getCustomerList(queryVo);
		Integer count = queryVoDao.getCustomerListCount(queryVo);
		Page<Customer> page = new Page<>();
		page.setRows(list);
		page.setTotal(count);
		page.setSize(queryVo.getSize());
		page.setPage(queryVo.getPage());
		return page;
	}

	@Override
	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return queryVoDao.getCustomerById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		queryVoDao.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		queryVoDao.deleteCustomer(id);
	}

}
