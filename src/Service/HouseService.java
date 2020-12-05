package Service;

import java.util.ArrayList;

import Dao.HouseDao;
import Dao.HouseDaoImp;
import Dao.UserDao;
import Dao.UserDaoImp;
import Entity.House;
import Entity.User;

public class HouseService implements IHouseService {

	public HouseService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<House> findHouses(String info,Integer Type) {
		// TODO Auto-generated method stub
		
		 HouseDao hd =  new HouseDaoImp();
		 ArrayList<House> list=null;
		 try {
			list= hd.findHouses(info, Type);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return list;
	}

}
