import java.util.*;

public class Car{
	private String plateNumber;
	private int hours;
	 
	//default Constructor
	Car(){
		
	}
	Car( int hours, String plateNumber ) {
	        this.hours = hours;
	        this.plateNumber = plateNumber;
	} 
	public String getPlateNumber(){
      return plateNumber;
    }

    public void setPlateNumber( String pnumber){
      plateNumber = pnumber;
    }
	
	public int getHours(){
      return hours;
    }

    public void setHours( int hr){
      hours = hr;
    }
     
	public double calculateFee(int h){
		double firstHour = 7.50;
		double otherHour = 4.50;
		int exceptFirsthour = h -1; 
		double exceptFirsthourAmount = exceptFirsthour * otherHour; 
		double totalAmount = exceptFirsthourAmount + firstHour;
		 
		return totalAmount;
	}
	 
}