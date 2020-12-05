package Service;

import java.util.ArrayList;

import Entity.House;
import Entity.HouseType;
import Entity.User;

public interface IHouseService {
	public  abstract ArrayList<House> findHouses(String info,Integer Type);
	public  abstract ArrayList<HouseType> findHTypes();
	public  abstract Boolean insertHouse(House h);
}
