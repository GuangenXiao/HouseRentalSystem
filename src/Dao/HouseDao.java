package Dao;

import java.util.ArrayList;

import Entity.House;
import Entity.HouseType;
import Entity.User;

public interface HouseDao {
	public  abstract ArrayList<House> findHouses(String info,Integer Type) throws Exception ;
	public  abstract ArrayList<HouseType> findHTypes() throws Exception;
}
