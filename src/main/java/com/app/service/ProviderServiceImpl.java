package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.entities.User;

@Service
@Transactional
public class ProviderServiceImpl implements ProviderService {

	@Autowired
	UserDao uDao;
	@Override
	public String delete(Integer id) {
		
		uDao.deleteById(id);
		
		return "Check Tables";
	}
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return uDao.findAll();
	}

}
