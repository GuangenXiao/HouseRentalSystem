package Dao;

import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import Entity.User;

import Util.DbSoureUtil;

public class UserDaoImp implements UserDao {

	public UserDaoImp() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public User searchUserByID(User u) throws Exception {
		// TODO Auto-generated method stub
		//Connection conn = DbSoureUtil.ds.getConnection();
		QueryRunner ruuner = new QueryRunner(DbSoureUtil.getDataSource());
		String sql = "SELECT *  FROM HRUser where uId=?";
        ArrayList<User> list = (ArrayList<User>)ruuner.query(sql, new BeanListHandler(User.class), new Object[]{u.getuId()}); 
		return list.size()>0 ?(User) list.get(0):null;
	}
//insert into HRUser values(null,'xge',"123456","icon.png","13561915657","962613262@qq.com",default,20,true,null,null,default,0,true,"admin");
//insert into HRUser values(null,?,?,?,?,?,default,?,?,?,?,default,0,true,?);
	//insert into HRUser values(null,?,?,?,?,?,default,?,?,?,?,default,0,true,?);
	@Override
	public Boolean insertUser(User u) throws Exception {
		// TODO Auto-generated method stub
		String sql ="insert into hruser values(null,?,?,?,?,?,?,?,?,?,?,default,0,true,?);";
		QueryRunner runner = new QueryRunner(DbSoureUtil.getDataSource());
		Integer re = runner.update(sql,new  Object [] {u.getuName(),u.getuPassword(),u.getuIcon(),u.getuPhoneNumber(),u.getuEmail(),u.getuBirthday()
				,u.getuAge(),u.getuGender(),u.getuDescription(),u.getuLocation(),u.getuType()});
		return re>=0?true:false;
	}

	@Override
	public Integer updateUser(User u) throws Exception {
		// TODO Auto-generated method stub
		String sql="update HRUser set ";
		int i=0;
		if(u.getuName()!=null)
		{
			if(i!=0)sql+=",";
			i++;
			sql+="uName = '"+u.getuName()+"'";
		}
		if(u.getuPassword()!=null)
		{
			if(i!=0)sql+=",";
			i++;
			sql+="uPassword = '"+u.getuPassword()+"'";
		}
		if(u.getuEmail()!=null)
		{
			if(i!=0)sql+=",";
			i++;
			sql+="uEmail = '"+u.getuEmail()+"'";
		}
		if(u.getuPhoneNumber()!=null)
		{
			if(i!=0)sql+=",";
			i++;
			sql+="uPhoneNumber = '"+u.getuPhoneNumber()+"'";
		}
		if(u.getuMoney()!=null)
		{
			if(i!=0)sql+=",";
			i++;
			sql+="uMoney = "+u.getuMoney();
		}
		if(u.getuType()!=null)
		{
			if(i!=0)sql+=",";
			i++;
			sql+="uType = '"+u.getuType()+"'";
		}
		if(u.getuVerification()!=null)
		{
			if(i!=0)sql+=",";
			i++;
			sql+="uVerification = "+u.getuVerification();
		}
		if(u.getuStatus()!=null)
		{
			if(i!=0)sql+=",";
			i++;
			sql+="uState = "+u.getuStatus();
		}
		if(u.getuDescription()!=null)
		{
			if(i!=0)sql+=",";
			i++;
			sql+="uDescription = "+u.getuDescription();
		}
		if(u.getuLocation()!=null)
		{
			if(i!=0)sql+=",";
			i++;
			sql+="uLocation= "+u.getuLocation();
		}
		sql+=" where uId=?;";
		System.out.print(sql);
		QueryRunner runner = new QueryRunner(DbSoureUtil.getDataSource());
		Integer re = runner.update(sql,new  Object [] {u.getuId()});
		return re;
	}

	@Override
	public Integer deleteUser(User u) throws Exception {
		// TODO Auto-generated method stub
		String sql="delete from lms_user where uId=?;";
		QueryRunner runner = new QueryRunner(DbSoureUtil.getDataSource());
		Integer re = runner.update(sql,new  Object [] {u.getuId()});
		return re;
	}
	
	@Override
	public ArrayList<User> findUsers(String info,String type) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner ruuner = new QueryRunner(DbSoureUtil.getDataSource());
		String sql = "SELECT *  FROM hrdb.hruser";
		if(info!=null&&info.length()>0) {
		 sql+=" where (uId like '%"+info
				+"%' or uName like '%"+info
				+"%' or uEmail like '%"+info
				+"%' or uPhoneNumber like '%"+info
				+"%' or uLocation like '%"+info
				+"%' or uDescription like '%"+info
				+"%' )";
		   if(type!=null) {
			   sql+=" and uType= '"+type+"' ";
		   }
		   sql+=";";
		}
		else 
		{
			if(type!=null) {
				   sql+=" where uType= '"+type+"' ";
			   }
			sql+=";";
		}
		System.out.println(sql);
        ArrayList<User> list = (ArrayList<User>)ruuner.query(sql, new BeanListHandler(User.class)); 
		return list;
	}
}
