package Service;

import java.util.ArrayList;

import Entity.User;



public interface IUserService {
	 public  abstract User UserLogin(User u);
	 public  abstract ArrayList<User> findUsers(String info);
	 public abstract Integer updateUser(User u);
	 public abstract Boolean insertUser(User u);
}
