package Service;

import java.util.ArrayList;

import Entity.User;



public interface IUserService {
	 public  abstract User UserLogin(User u);
	 public  abstract ArrayList<User> findUsers(String info,String type);
	 public abstract Integer updateUser(User u);
	 public abstract Boolean insertUser(User u);
	 public abstract User fineUserByName(User u);
	 public abstract User registerNewUser(User u);
}
