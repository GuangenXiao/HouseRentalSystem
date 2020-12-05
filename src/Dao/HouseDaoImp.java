package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import Entity.House;
import Entity.User;
import Util.DbSoureUtil;

public class HouseDaoImp implements HouseDao {

	public HouseDaoImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<House> findHouses(String info,Integer Type) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner ruuner = new QueryRunner(DbSoureUtil.ds);
		String sql = "SELECT *  FROM  hrhouse where hId like '%"+info+"%' or hEquipment like '%"+info+"%' or hAddress like '%"+info+"%' or hDescription like '%"+info+"%'; ";
        if(Type!=null)sql+= " and hType = "+Type+" ;";
        System.out.println(sql);
        
        
		ArrayList<House> list = (ArrayList<House>)ruuner.query(sql, new BeanListHandler(House.class), new Object[]{}); 
		
		
        System.out.println("result:"+list);
        
		return list;
	}
}
