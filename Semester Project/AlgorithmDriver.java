package supermarketChainStore;

public class AlgorithmDriver {

	public static void main(String[] args) {
		
		NearestNeighbor nna = new NearestNeighbor();
		
		//int answer = nna.nearestNeighbor(6);
		//System.out.println(answer);
		
		System.out.println("The optimal city trip order is: " + nna.nearestNeighborAl(0));
		System.out.println("The total distance is: " + nna.nnaDistance() + " miles");
		System.out.println("The total time is: " + nna.totalTime() + " hours");
		System.out.println("The diesel fuel cost is: $" + nna.dieselfuelCost());
		System.out.println("The driver salary is: $" + nna.driverSalary());
		System.out.println("The helper salary is: $" + nna.helperSalary());
		System.out.println("The hotel cost is: $" + nna.hotelCost());
		System.out.println("The food cost is: $" + nna.foodCost());
		System.out.println("The wear, tear, toll, and maintenance cost is: $" + nna.wttmCost());
		System.out.println("The total cost is: $" + nna.totalCost());
		System.out.println(nna.toString());
		
	}

}
