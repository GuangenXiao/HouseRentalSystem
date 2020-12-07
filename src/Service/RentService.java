package Service;


import java.util.ArrayList;

import Dao.HouseDao;
import Dao.HouseDaoImp;
import Dao.RentalDao;
import Dao.RentalDaoImp;
import Entity.House;
import Entity.Rental;


public class RentService implements IRentService {
	public RentService() 
	{
		
	}
	@Override
	public Boolean insertRent(Rental R) {
		// TODO Auto-generated method stub
		RentalDao Ren=new RentalDaoImp();
		Boolean result=null;
		 try {
				result= Ren.insertRental(R);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
	@Override
	public ArrayList<Rental> findReantals(Integer Owner) {
		// TODO Auto-generated method stub
		
		 RentalDao hd =  new RentalDaoImp();
		 ArrayList<Rental> list=null;
		 try {
			list= hd.findrentals(Owner);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return list;
	}
	@Override
	public Boolean updateRental(Integer RentalID) {
		// TODO Auto-generated method stub
		RentalDao Ren=new RentalDaoImp();
		Boolean result=null;
		 try {
				result= Ren.updateRental(RentalID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
	@Override
	public Boolean deteleRental(Integer RentalID) {
		// TODO Auto-generated method stub
		RentalDao Ren=new RentalDaoImp();
		Boolean result=null;
		 try {
				result= Ren.deteleRentalRental(RentalID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
}
