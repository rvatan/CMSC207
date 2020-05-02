package supermarketChainStore;

import java.util.*;
import java.text.DecimalFormat;

/**
 * Here is the class that creates the Nearest Neighbor Algorithm
 * for The Supermarket Chain Store problem for CMSC 207 course.
 * This algorithm returns the shortest optimal total distance for a single truck
 * and a single delivery trip from Rockville, MD to six other cities then back 
 * Rockville, MD. 
 * @TeamMembers Ramiz Vatan
 * Date: 04/28/2020
 */

public class NearestNeighbor {
	
	public String[] cities = {"Rockville","Silver Spring","Philadelphia","Pittsburgh","Baltimore",
			"Cleveland","New York City"};
	
	public final int NUM_OF_CITIES = 7;
	public int[][] travelDist = {
			{0,   13,  142, 225, 40,  352, 227},
			{13,  0,   136, 237, 34,  363, 222},
			{141, 135, 0,   305, 101, 432, 97},
			{226, 237, 304, 0,   248, 133, 371},
			{40,  34,  106, 248, 0,   374, 192 },
			{352, 364, 431, 133, 375, 0,   462},
			{228, 222, 97,  370, 188, 462, 0}};
	
	public int distTraveled = 0;
	public int currentDist = 9999999;
	public String currentCity = null;
	public int previousCityIndex = 0;
	ArrayList<Integer> visitedCities = new ArrayList<Integer>();
	
	public ArrayList<Integer> nearestNeighborAl (int currentCityIndex) {
		int nextCityIndex = 0;
		for(int i=0;i<travelDist.length;i++) {
			currentDist = 99999;
			currentCityIndex = nextCityIndex;
			visitedCities.add(currentCityIndex);
			for (int j=0;j<travelDist[i].length;j++) {
				if (travelDist[currentCityIndex][j]!=0 && 
						travelDist[currentCityIndex][j]<currentDist && !visitedCities.contains(j)) {
					currentDist = travelDist[currentCityIndex][j];
					nextCityIndex=j;
				}
			}
		}
		while (visitedCities.get(visitedCities.size()-1) == 0) {
			   visitedCities.remove(visitedCities.size()-1);
		    }
		visitedCities.add(0);
		return visitedCities;
	}
	
	public int nnaDistance(){
		ArrayList<Integer> citiesVisited = nearestNeighborAl(0);
		int distance = 0;
		for (int i=0;i+1<citiesVisited.size();i++) {
					distance += travelDist[citiesVisited.get(i)][citiesVisited.get(i+1)];
		}
		return distance;
	}
	
	DecimalFormat df = new DecimalFormat("0.00");
	int distance = nnaDistance();
	
	public double totalTime() {
		String totalTimeStr = df.format(distance/60.0);  
		double totalTime = Double.parseDouble(totalTimeStr); 
		return totalTime;
	}
	
	public double dieselfuelCost() {
		double gallons = distance/7.0;
		String fuelCostStr = df.format(gallons*3.32);
		double fuelCost = Double.parseDouble(fuelCostStr);
		return fuelCost;
	}
	
	public double driverSalary(){
		String driverSalaryStr = df.format(1200+(0.56*distance));
		double driverSalary = Double.parseDouble(driverSalaryStr);
		return driverSalary;
	}
	
	public double helperSalary() {
		String helperSalaryStr = df.format(900+(0.42*distance));
		double helperSalary = Double.parseDouble(helperSalaryStr);
		return helperSalary;
	}
	
	public double hotelCost(){
		double hotelCost = (NUM_OF_CITIES-1)*200;
		return hotelCost;
	}
	
	public double foodCost() {
		double foodCost = (NUM_OF_CITIES-1)*68*2;
		return foodCost;
	}
	
	public double wttmCost() {
		double wttmCost = 0.88*distance;
		return wttmCost;
	}
	
	public double totalCost() {
		String totalCostStr = df.format(wttmCost()+foodCost()+hotelCost()+dieselfuelCost());
		double totalCost = Double.parseDouble(totalCostStr);
		return totalCost;
	}
	
	public String toString() {
		return "As the number of cities increases, the Nearest Neighbor Algorithm \ntakes longer to "
				+ "return the order of the cities.";
	}
}
