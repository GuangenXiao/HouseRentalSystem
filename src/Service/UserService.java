package Service;

import java.util.ArrayList;

import Dao.UserDao;
import Dao.UserDaoImp;
import Entity.User;

public class UserService  implements IUserService {
	 public UserService()
	{
		
	}
	 public User UserLogin(User u)
	 {
		 UserDao ud =  new UserDaoImp();
		 User uResult=null;
		 try {
			uResult= ud.searchUserByID(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uResult;
		 
	 }
	@Override
	public ArrayList<User> findUsers(String info) {
		// TODO Auto-generated method stub

		 UserDao ud =  new UserDaoImp();
		 ArrayList<User> list=null;
		 try {
			list= ud.findUsers(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return list;
	}
	@Override
	public Integer updateUser(User u) {
		// TODO Auto-generated method stub
		 UserDao ud =  new UserDaoImp();
		 Integer r =null;
		 try {
			r= ud.updateUser(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	@Override
	public Boolean insertUser(User u) {
		// TODO Auto-generated method stub
		 UserDao ud =  new UserDaoImp();
		 Boolean r =null;
		 try {
			r= ud.insertUser(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
}
