package com.forest.core.service;

import java.util.List;

import com.forest.core.pojo.BaseDict;

public interface BaseDictService {
	public List<BaseDict> getBaseDictByTypecode(String typeCode);
}
