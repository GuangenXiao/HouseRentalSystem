package Dao;

import java.util.ArrayList;

import Entity.Rental;

public interface RentalDao {
	public abstract Boolean insertRental(Rental R) throws Exception;
	public abstract ArrayList<Rental> findrentals(Integer owner)throws Exception;
	public abstract Boolean updateRental(Integer rentalID)throws Exception;
	public abstract Boolean deteleRentalRental(Integer rentalID)throws Exception;
}
