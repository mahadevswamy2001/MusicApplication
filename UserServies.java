package com.example.dmeo.servies;

import com.example.dmeo.entity.Users;

public interface UserServies {

	public String addUser(Users user);

	public boolean emailExists(String email);

	public boolean validUser(String email, String password);

	public String getRole(String email);

	public Users getUsers(String email);



	public void updateUser(Users user);

}
