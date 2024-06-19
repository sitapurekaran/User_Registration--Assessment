package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Entityclass;
import com.example.demo.repo.userRapo;
@org.springframework.stereotype.Service
public class ServiceImpl implements UserService {
@Autowired
	private userRapo userrapo;
	@Override
	public void registerUser(Entityclass entityclass) {
		// TODO Auto-generated method stub
		userrapo.save(entityclass);
	}

}
