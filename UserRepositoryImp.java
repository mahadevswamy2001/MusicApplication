package com.example.dmeo.servies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dmeo.entity.Users;
import com.example.dmeo.repository.UserRepository;

@Service
public  class UserRepositoryImp implements UserServies {
	@Autowired
	UserRepository repo;

	public String addUser(Users user) {
		repo.save(user);
		return "User Added Succesfully";
	}

	@Override
	public boolean emailExists(String email) {

		if (repo.findByEmail(email) == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean validUser(String email, String password) {
		Users user = repo.findByEmail(email);
		String db_pass = user.getPassword();
		if (password.equals(db_pass)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String getRole(String email) {
		Users user = repo.findByEmail(email);

		return user.getRole();
	}

	@Override
	public Users getUsers(String email) {
		return repo.findByEmail(email);

	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
	}

}
