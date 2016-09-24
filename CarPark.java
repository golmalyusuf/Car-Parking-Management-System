import java.util.*;
import java.awt.*;
import javax.swing.*; 
 
public class CarPark extends Car {
	public static int countCar = 0;
	public static int countCar2 = 1;
	static Car[] allCar=new Car[20];
	Car cars = new Car();
	public static void main(String args[]){
		 
		 
		CarPark carPark = new CarPark();
		Scanner in = new Scanner(System.in);
		int userInputForChoice =  0;
		
		while(userInputForChoice != 5){
			 
			System.out.print("Welcome to the Rocky car park system.");
			
			System.out.println("Please select form the following");
			System.out.println("1. Enter licence plate, hours and fees");
			System.out.println("2. Display all licence plates, hours and fees");
			System.out.println("3. Display statistics");
			System.out.println("4. Search for cars");
			System.out.println("5. Exit Application");
			
			System.out.println("Enter Choice==>");
			userInputForChoice = in.nextInt();
			  
			if(userInputForChoice == 1){ // used for input the car licence plate and hour stayed.
				carPark.enterCar();
				System.out.println("");
				System.out.println("");
			}
			else if(userInputForChoice == 2){ // used for displaying all cars.
				System.out.println("");
				
				if(countCar != 0){
					carPark.displayAllCars();
				}else{
					 JFrame frame4 = new JFrame("Input Hours Parked");
				     JOptionPane.showMessageDialog(frame4, "You must enter at least one car");
				}
				 
				 System.out.println("");
			}
			else if(userInputForChoice == 3){ // used for displaying statistics.
				System.out.println("");
				
				if(countCar != 0){
					carPark.displayStatistics();
				}else{
					 JFrame frame4 = new JFrame("Input Hours Parked");
				     JOptionPane.showMessageDialog(frame4, "You must enter at least one car");
				 }
				
				 System.out.println("");
			}
			else if(userInputForChoice == 4){ //used for search the expected car's licence plate.
				System.out.println("");
				 
				if(countCar != 0){
					carPark.searchCar();
				}else{
					 JFrame frame4 = new JFrame("Input Hours Parked");
				     JOptionPane.showMessageDialog(frame4, "You must enter at least one car");
				}
				System.out.println("");
			}
			else if(userInputForChoice == 5){ // exit the program.
				countCar = 0;
				System.out.println("Thank you for using the rocky car park system");
				System.out.println("Program written by 12022525");
				System.exit(0);
			}
		}
	}
	
	/**
	 *This method take input from the user.
	 *It takes licence plate number and amount of hours parked
	 *and then store it in the Cars classes array.
	 *It also displays the user input. It also checks whether the 
	 *number of cars is above 20. If the number of cars is above 20 then 
	 *it won't store in array.
	 */
	public void enterCar(){
		 
		JFrame frame = new JFrame("Input Licence Plate");
		String licenceNumber = JOptionPane.showInputDialog(frame, "Please enter the licence plate of the car"); // take user input for the car licence plate.
		 
		while(licenceNumber.isEmpty()){
			JFrame frame3 = new JFrame("Input Licence Plate");
			JOptionPane.showMessageDialog(frame3, "Error- Licence Plate cannot be blank");
			licenceNumber = JOptionPane.showInputDialog(frame3, "Please enter the licence plate of the car");
		}
		
		JFrame frame2 = new JFrame("Input Hours Parked");
		String hoursStayed = JOptionPane.showInputDialog(frame2, "Enter the number of hours the was parked (1-12)");
		
		int hr = 0;
		if(hoursStayed.isEmpty()){
			hr = 0;
		}
		else{
			hr = Integer.parseInt(hoursStayed);
		}
		while(hoursStayed.isEmpty() || !(hr > 0 && hr<13) ){ //|| !(  hr>=1 &&  hr<= 12)
			JFrame frame3 = new JFrame("Input Hours Parked");
			JOptionPane.showMessageDialog(frame3, "Hours must be between 1-12");
			hoursStayed = JOptionPane.showInputDialog(frame3, "Enter the number of hours the was parked (1-12)");
			if(hoursStayed.isEmpty()){
				hr = 0;
			}
			else{
				hr = Integer.parseInt(hoursStayed);
			}
		}
		    
		for(int i=countCar;i<countCar2;i++){
			 allCar[i] = new Car(hr,licenceNumber);
		}
	    if(countCar2 != 20){
			countCar++; 
			countCar2++;
			System.out.println("Details for car "+countCar+"entered");
			System.out.println("Licence Plate            Hours            Fee");
			System.out.println( licenceNumber+"                    "+ hr+"               "+cars.calculateFee(hr));
				  
	    }else{
	    	JFrame frame4 = new JFrame("Input Hours Parked");
	    	JOptionPane.showMessageDialog(frame4, "Error maximum cars to be entered has been reached");
	    }
	}
	
	/**
	 * This method displays all the cars have been parked. 
	 **/
	public void displayAllCars(){
		 
		System.out.println("Licence Plate            Hours            Fee");
		for(int i=0; i<countCar; i++){
			 System.out.println( allCar[i].getPlateNumber()+"                    "+ allCar[i].getHours()+"               "+cars.calculateFee(allCar[i].getHours())); 
		}
	}
	/**
	 * This method will display the statistics of the 
	 * car park. It calculates total hours that all the
	 * cars stayed and calculate the amount of money earned.
	 */
	 public void displayStatistics(){
			 
			int totalHoursOfAllCars = 0;
			double totalAmountofMoney = 0;
			int findMinMaxValueFromAllCars[] = new int[countCar];
			
			for(int i=0; i<countCar; i++){
				 findMinMaxValueFromAllCars[i] =  allCar[i].getHours();
				 totalHoursOfAllCars += allCar[i].getHours();
				 totalAmountofMoney += cars.calculateFee(allCar[i].getHours());
			}
			
			int max = getMax(findMinMaxValueFromAllCars);
			int min = getMin(findMinMaxValueFromAllCars);
		    
		    for(int i=0; i<countCar; i++){
		    	if(allCar[i].getHours() == max){
		    		System.out.println(allCar[i].getPlateNumber()+" has maximum stay of "+allCar[i].getHours()+" hour(s)");
		    	}
		    	if(countCar>1){
			    	if(allCar[i].getHours() == min){
			    		System.out.println(allCar[i].getPlateNumber()+" has minimum stay of "+allCar[i].getHours()+" hour(s)");
			    	}
		    	}
		    }
		    
			try{
				System.out.println("The average stay is "+(double)totalHoursOfAllCars/(double)countCar);
				System.out.println("The total fee collected is: "+totalAmountofMoney);
			}catch(Exception ex){
				
			}
	}
	 /**
	 * Method for getting the maximum value
	 */ 
	  public static int getMax(int[] inputArray){ 
	    int maxValue = inputArray[0]; 
	    for(int i=1;i < inputArray.length;i++){ 
	      if(inputArray[i] > maxValue){ 
	         maxValue = inputArray[i]; 
	      } 
	    } 
	    return maxValue; 
	  }
	  
	/**
	 * Method for getting the minimum value
	 */ 
	  public static int getMin(int[] inputArray){ 
	    int minValue = inputArray[0]; 
	    for(int i=1;i<inputArray.length;i++){ 
	      if(inputArray[i] < minValue){ 
	        minValue = inputArray[i]; 
	      } 
	    } 
	    return minValue; 
	  } 
	/**
	 * This method will search the array of Cars class and find
	 * out the expected car licence plate. 
	 * If the car licence plate is not found then it will 
	 * show the error message.
	 */
	public void searchCar(){ // search car licence plate
		
		JFrame frame = new JFrame("Input Licence Plate");
		String licenceNumber = JOptionPane.showInputDialog(frame, "Please enter the licence plate of the car");
		boolean foundCar = false;
		
		for(int i=0; i<countCar; i++){
			if(allCar[i].getPlateNumber().contains(licenceNumber)){
				System.out.println("Car found.");
				System.out.println("Licence Plate             Hours            Fee");
				System.out.println( allCar[i].getPlateNumber()+"                    "+ allCar[i].getHours()+"               "+cars.calculateFee(allCar[i].getHours()));
				foundCar = true;
			}
		}
		if(!foundCar){
			JFrame frame4 = new JFrame("Input Hours Parked");
			JOptionPane.showMessageDialog(frame4, licenceNumber+" not found");
		}
	}
}