package com.sample.test.dao;

import com.sample.test.common.entity.MgrParamScope;
import java.util.List;
import java.util.Map;

public interface MgrParamScopeMapper {
	public List<MgrParamScope> selectByParams(Map<String,Object> params);
}
