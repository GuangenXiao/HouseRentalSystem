package Dao;

import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.tomcat.jni.Time;

import Entity.House;
import Entity.Rental;
import Entity.User;
import Util.DbSoureUtil;

public class RentalDaoImp implements RentalDao{
	public RentalDaoImp() {
		
	}
	@Override
	public Boolean insertRental(Rental R) throws Exception {
		// TODO Auto-generated method stub
		String sql ="insert into hrrental values(null,?,?,?,?,?,null);";
		QueryRunner runner = new QueryRunner(DbSoureUtil.getDataSource());
		Integer re = runner.update(sql,new  Object [] {R.getrHId(),R.getrUId(),R.getrPrice(),R.getrStart(),R.getrEnd()});
		return re>=0?true:false;
	}
	@SuppressWarnings("unchecked")
	public  ArrayList<Rental> findrentals(Integer owner) throws Exception{
		QueryRunner ruuner = new QueryRunner(DbSoureUtil.getDataSource());
		String sql = "Select * from hrrental where rDeal is null and rHId in (SELECT hId FROM hrdb.hrhouse where hOwnerId= ?);";
        ArrayList<Rental> list = (ArrayList<Rental>)ruuner.query(sql, new BeanListHandler(Rental.class),new Object [] {owner}); 
		return list;
	}
	public Boolean updateRental(Integer rentalID) throws Exception {
		// TODO Auto-generated method stub
		String sql ="update hrrental set rdeal=now() where rId=?";
		QueryRunner runner = new QueryRunner(DbSoureUtil.getDataSource());
		Integer re = runner.update(sql,new  Object [] {rentalID});
		return re>=0?true:false;
	}
	public Boolean deteleRentalRental(Integer rentalID) throws Exception {
		// TODO Auto-generated method stub
		String sql="delete from hrrental where rId=?;";
		QueryRunner runner = new QueryRunner(DbSoureUtil.getDataSource());
		Integer re = runner.update(sql,new  Object [] {rentalID});
		return re>=0?true:false;
	}
}