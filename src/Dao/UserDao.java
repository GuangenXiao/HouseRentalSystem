package Dao;

import java.util.ArrayList;

import Entity.User;

public interface UserDao {
	public abstract User searchUserByID(User u)  throws Exception;
	public abstract Boolean insertUser(User u)  throws Exception;
	public abstract Integer updateUser(User u)  throws Exception;
	public abstract Integer deleteUser(User u)  throws Exception;
	public abstract ArrayList<User> findUsers(String info,String type) throws Exception;
	public abstract User searchUserByName(User u)  throws Exception;
}
