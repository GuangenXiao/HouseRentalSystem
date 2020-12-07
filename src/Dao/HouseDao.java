package Dao;

import java.util.ArrayList;

import Entity.House;
import Entity.HouseType;
import Entity.User;

public interface HouseDao {
	public  abstract ArrayList<House> findHouses(String info,Integer Type) throws Exception ;
	public  abstract ArrayList<HouseType> findHTypes() throws Exception;
	public  abstract Boolean insertHouse(House h) throws Exception;
	public  abstract House searchHouseByID(House h) throws Exception;
	public  abstract Boolean deleteHouse(Integer houseId)throws Exception;
}
