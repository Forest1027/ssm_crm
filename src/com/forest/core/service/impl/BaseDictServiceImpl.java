package com.forest.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.core.dao.BaseDictDao;
import com.forest.core.pojo.BaseDict;
import com.forest.core.service.BaseDictService;

@Service
@Transactional
public class BaseDictServiceImpl implements BaseDictService{
	@Autowired
	private BaseDictDao baseDictDao;

	@Override
	public List<BaseDict> getBaseDictByTypecode(String typeCode) {
		// TODO Auto-generated method stub
		return baseDictDao.getBaseDictByTypeCode(typeCode);
	}

}
