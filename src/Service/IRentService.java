package Service;

import java.util.ArrayList;

import Entity.Rental;


public interface IRentService {
	public abstract Boolean insertRent(Rental R);
	public abstract ArrayList<Rental> findReantals(Integer OwenerID);
	public abstract Boolean updateRental(Integer RentalID);
	public abstract Boolean deteleRental(Integer RentalID);
}
