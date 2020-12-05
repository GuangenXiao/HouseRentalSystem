package Dao;

import java.util.ArrayList;

import Entity.House;
import Entity.User;

public interface HouseDao {
	public  abstract ArrayList<House> findHouses(String info,Integer Type) throws Exception ;
}
