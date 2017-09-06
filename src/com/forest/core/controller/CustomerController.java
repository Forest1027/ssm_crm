package com.forest.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.core.pojo.BaseDict;
import com.forest.core.pojo.Customer;
import com.forest.core.pojo.QueryVo;
import com.forest.core.service.BaseDictService;
import com.forest.core.service.CustomerService;

import cn.forest.common.utils.Page;

@RequestMapping("/customer")
@Controller
public class CustomerController {
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;

	@Value("${customer.source.code}")
	private String custSourceCode;
	@Value("${customer.industory.code}")
	private String custIndustoryCode;
	@Value("${customer.level.code}")
	private String custLevelCode;

	@RequestMapping("/list")
	public String showCustomer(QueryVo  queryVo,Model model) {
		List<BaseDict> fromType = baseDictService.getBaseDictByTypecode(custSourceCode);
		List<BaseDict> industryType = baseDictService.getBaseDictByTypecode(custIndustoryCode);
		List<BaseDict> levelType = baseDictService.getBaseDictByTypecode(custLevelCode);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		Page<Customer> page = customerService.getCustomerList(queryVo);
		model.addAttribute("page", page);
		model.addAttribute("custIndustry", queryVo.getCustIndustory());
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custLevel",queryVo.getCustLevel());
		return "customer";
	}
	
	@RequestMapping("/edit")
	public @ResponseBody Customer edit(Long id) {
		Customer customer = customerService.getCustomerById(id);
		return customer;
	}
	
	@RequestMapping("/update")
	public @ResponseBody Map<String, Object> update(Customer customer) {
		Map<String, Object> result =new HashMap<>();
		try {
			customerService.updateCustomer(customer);
			result.put("success", true);
			result.put("msg", "修改用户信息成功");
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "修改用户信息失败");
			return result;
		}
	}
	
	@RequestMapping("/delete")
	public @ResponseBody Map<String, Object> delete(Long id) {
		Map<String, Object> result =new HashMap<>();
		try {
			customerService.deleteCustomer(id);
			result.put("success", true);
			result.put("msg", "删除用户信息成功");
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "删除用户信息失败");
			return result;
		}
	}
}
