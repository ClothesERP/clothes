package com.xiangcai.mapper;

import org.apache.ibatis.annotations.Insert;

import com.xiangcai.pojo.Test;

public interface TestMapper {

	@Insert("insert into test(time) values(#{time})")
	void add(Test test);

}
