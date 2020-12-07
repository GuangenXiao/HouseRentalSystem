package Service;


import Dao.RentalDao;
import Dao.RentalDaoImp;
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
}
