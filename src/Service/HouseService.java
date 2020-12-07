package Service;

import java.util.ArrayList;

import Dao.HouseDao;
import Dao.HouseDaoImp;
import Dao.UserDao;
import Dao.UserDaoImp;
import Entity.House;
import Entity.HouseType;
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

	@Override
	public ArrayList<HouseType> findHTypes() {
		// TODO Auto-generated method stub
		 HouseDao hd =  new HouseDaoImp();
		 ArrayList<HouseType> list=null;
		 try {
			list= hd.findHTypes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return list;
	}
	@Override
	public Boolean insertHouse(House h) {
		// TODO Auto-generated method stub
		
		 HouseDao hd =  new HouseDaoImp();
		 Boolean result=null;
		 try {
			result=hd.insertHouse(h);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public House serachhouseById(String ID) {
		// TODO Auto-generated method stub
		
		 HouseDao hd =  new HouseDaoImp();
		 House h = new House.Builder().hId(Integer.parseInt(ID)).Build();
		 House result=null;
		 try {
			
			result=hd.searchHouseByID(h);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
