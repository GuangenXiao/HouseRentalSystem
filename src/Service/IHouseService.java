package Service;

import java.util.ArrayList;

import Entity.House;
import Entity.User;

public interface IHouseService {
	public  abstract ArrayList<House> findHouses(String info,Integer Type);
}
