package Service;

import java.util.ArrayList;

import Dao.UserDao;
import Dao.UserDaoImp;
import Entity.User;

public class UserService  implements IUserService {
	 public UserService()
	{
		
	}
	 @Override
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
	public ArrayList<User> findUsers(String info,String type) {
		// TODO Auto-generated method stub
		  if(type.equals("General"))type=null;
		  else if(type.equals("Administrator")) type="admin";
		  else if(type.equals("Normal User")) type= "user";
		  else if(type.equals("Houser Owner")) type= "owner";
		  else type=null;
		 UserDao ud =  new UserDaoImp();
		 ArrayList<User> list=null;
		 try {
			list= ud.findUsers(info,type);
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
	public User registerNewUser(User u)
	{
		Boolean b= insertUser(u);
		if(b==false )return null;
		else 
		{
			User result =fineUserByName(u);
			System.out.println(result.getuId()+result.getuName());
			return  result;
		}
	}
	@Override
	public User fineUserByName(User u) {
		// TODO Auto-generated method stub
		 UserDao ud =  new UserDaoImp();
		 User uResult=null;
		 try {
			uResult= ud.searchUserByName(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uResult;
	}
}
