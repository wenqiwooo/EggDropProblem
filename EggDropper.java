import java.io.*;
import java.util.*;
import java.lang.Math;

public class EggDropper {

	public static Map<Integer, Integer> table;

	// A utility function to get maximum of two integers
	public static int max(int a, int b) { return (a > b)? a: b; }


    public static void main(String[] args) {
		if (args.length != 4) {
			System.err.println("Usage: EggDropper <noOfEggs> <noOfFloors> <iPadCost> <throwCost>");
			System.exit(-1);
		}

		// Get user inputs
		int eggNo = Integer.parseInt(args[0]);
		int floorNo = Integer.parseInt(args[1]);
		int iPadCost = Integer.parseInt(args[2]);
		int throwCost = Integer.parseInt(args[3]);

		table = new HashMap<Integer, Integer>();

		System.out.println(calculateDrop(eggNo, floorNo, iPadCost, throwCost));
    }

    // e is no of eggs, f is no of floors
    public static int calculateDrop(int e, int f, int iPadCost, int throwCost) {
    	
    	// Base case
		if (e == 1){
			return f;
		}

		if (f == 1 || f == 0){
			return f;
		}

    	// Check if in table
    	// return value if in table
		Integer expt = e * 10000 + f;

		if (table.get(expt) != null){
			return table.get(expt);
		}

    	// If not calculate min no of drops
    	int maxDrops = 0;

    	for (int i = 1; i <= f; i++){
			int d = 1 + max(calculateDrop(e - 1, i - 1, iPadCost, throwCost), calculateDrop(e, f - i, iPadCost, throwCost));

			if (maxDrops == 0){
				maxDrops = d;
			} else {
				if (d < maxDrops) {
					maxDrops = d;
				}
			}

    	}

    	// Save answer in table
		table.put(expt, maxDrops);

    	return maxDrops;
    }
}
