package com.xiangcai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiangcai.mapper.TestMapper;
import com.xiangcai.pojo.Test;

@Service
public class TestServiceImpl implements TestService{
     @Autowired
     TestMapper mapper;
	
	@Override
	public void addTest(Test test) {
		mapper.add(test);
	}

}
