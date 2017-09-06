package com.forest.core.dao;

import java.util.List;

import com.forest.core.pojo.BaseDict;

public interface BaseDictDao {
	public List<BaseDict> getBaseDictByTypeCode(String typeCode);
}
