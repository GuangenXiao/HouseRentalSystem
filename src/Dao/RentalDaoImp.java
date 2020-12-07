package Dao;

import org.apache.commons.dbutils.QueryRunner;

import Entity.Rental;
import Util.DbSoureUtil;

public class RentalDaoImp implements RentalDao{
	public RentalDaoImp() {
		
	}
	@Override
	public Boolean insertRental(Rental R) throws Exception {
		// TODO Auto-generated method stub
		String sql ="insert into hrrental values(null,?,?,?,?,?,null);";
		QueryRunner runner = new QueryRunner(DbSoureUtil.ds);
		Integer re = runner.update(sql,new  Object [] {R.getrHId(),R.getrUId(),R.getrPrice(),R.getrStart(),R.getrEnd()});
		return re>=0?true:false;
	}
}
