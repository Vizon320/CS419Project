package pkg;

import java.io.*;
import java.util.*;

public class Algorithms {
	static double MAX_DOUBLE = Double.MAX_VALUE;
	
	/* Combines listPlusEndpoints and shortestPath into one handy function */
	public static List<StoreProduct> shortestPathPlusEndpoints(List<StoreProduct> list) {
		List<StoreProduct> extendedList = shortestPath(list);
		return listPlusEndpoints(extendedList);
	}
	
	/* Assumes that List list contains the necessary products in path order, without endpoints */
	public static List<StoreProduct> listPlusEndpoints(List<StoreProduct> list) {
		// TODO: Kevin - Add necessary endpoints to List list.
		return list;
	}
	
	/* Returns a list in the order of the shortest path that hits every item in the list */
	/* Assumes that List list contains only the necessary products and/or endpoints */
	/* Adapted from code by Sean Maginnis */
	public static List<StoreProduct> shortestPath(List<StoreProduct> list) {		
		// Adjacency matrix is no longer needed! Woohoo
		//File adjacencies = makeAdjacencyMatrix(list);
		
		// Counterpart to numcities
		int numItems = list.size();
		
		// Counterpart to permutationtable, will hold the calculated path distances during the recursive function
		ArrayList<ArrayList<Pair<String, Double>>> pathTable = new ArrayList<ArrayList<Pair<String, Double>>>();
		
		for(int i = 0; i < numItems; i++) {
			pathTable.add(new ArrayList<Pair<String, Double>>(Collections.nCopies((1 << numItems) - 1, new Pair<String, Double>("", MAX_DOUBLE))));
		}
		
		// Counterpart to citymatrix, a 2D ArrayList holding the values from the adjacency matrix
		ArrayList<ArrayList<Double>> itemMatrix = populateMatrix(list);
		
		// Counterpart to finalPair, holds the optimal path after being calculated and the total distance
		Pair<String, Double> finalPair = calculatePathDistances(itemMatrix, 0, 1, pathTable);
		
		List<StoreProduct> finalPath = new ArrayList<StoreProduct>();
		
		if(finalPair.second() == MAX_DOUBLE) {
			// Have website print an error message or something if the return is null
			return null;
		}
		else {
			System.out.println("Optimal Path Cost = [" + finalPair.second() + "]");
			// myLine will contain the string of path indexes, including the index value of the starting city
			// TODO: Kevin - But what if the starting city isnt first in ArrayList list?
			String myline = "0 " + finalPair.first();
			Scanner pathf = new Scanner(myline);
			while (pathf.hasNextInt()) {
				// Add the object at the next index so that finalPath is ordered correctly
				finalPath.add(list.get(pathf.nextInt()));
			}
			pathf.close();
		}
		
		return finalPath;
	}
	
	/* Calculates distances for each permutation of paths and returns a Pair containing the path as a string and the shortest total distance as a double */
	static Pair<String, Double> calculatePathDistances(ArrayList<ArrayList<Double>> matrix, int position, int previous, ArrayList<ArrayList<Pair<String, Double>>> table) {
		if (previous == ((1 << matrix.size()) - 1)) {
			// We have reached the end and need to go back to the starting point
			if (matrix.get(position).get(0) != -1) {
				// Distance to starting point is finite
				return new Pair<String, Double>(" ", matrix.get(position).get(0));
			}
			else {
				// Distance to starting point is undefined/infinite
				return new Pair<String, Double>(" ", MAX_DOUBLE);
			}
		}
		
		if (table.get(position).get(previous).second() != MAX_DOUBLE) {
			// Means a distance for this subpath permutation has already been calculated, so just return that
			return table.get(position).get(previous);
		}
		
		// Loop through every item
		for (int i = 0; i < matrix.size(); i++) {	
			// When ((previous & (1 << i)) != 0) it is fine, when ((previous & (1 << i)) == 1) it is infinite
			if ((i == position) || ((previous & (1 << i)) != 0) || (matrix.get(position).get(i) == -1)) {
				// Revisiting current city, or city is already in the path, or city has no path to it
				continue;
			}		
			
			Pair<String, Double> recurse = calculatePathDistances(matrix, i, previous | (1 << i), table);
			Pair<String, Double> distance = new Pair<String, Double>(i + " " + recurse.first() + " ", matrix.get(position).get(i) + recurse.second());
			
			// Updates the distance of the current path sequence traversed if it has not been calculated yet or if it is less than the current value
			if ((distance.second() < table.get(position).get(previous).second()) && (distance.second() > 0)) {
				table.get(position).set(previous, distance);
			}
		}
		
		// The final return statement, for when the shortest path has really been calculated
		return table.get(position).get(previous);
	}
	
	/* Returns a 2D ArrayList containing the distances between products in List items */
	public static ArrayList<ArrayList<Double>> populateMatrix(List<StoreProduct> items) {
		int count = items.size();
		ArrayList<ArrayList<Double>> returnMatrix = new ArrayList<ArrayList<Double>>();
		
		for(int row = 0; row < count; row++) {
			// Initialize returnMatrix so the ArrayList at row is not null
			returnMatrix.add(new ArrayList<Double>());
			
			for(int column = 0; column < items.size(); column++) {
				// Add the distance between items.get(row) and items.get(column)
				returnMatrix.get(row).add(distanceBetweenItems(items.get(row), items.get(column)));
			}
		}
		
		return returnMatrix;
	}
	
	/* Not actually used anymore, this step gets to be skipped */
	/* Returns a file containing the adjacency matrix for the given list */
	public static File makeAdjacencyMatrix(List<StoreProduct> list) {
		String filename = "output.txt";
		
		FileWriter writeOut = null;
		try {
			writeOut = new FileWriter(filename);
			
			// Would write adjacency matrix to file using the list indices as ids
			//writeOut.write("sbubby");
			
			writeOut.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return new File(filename);
	}
	
	/* Calculates the distance between two StoreProducts based on their coordinates */
	public static double distanceBetweenItems(StoreProduct p1, StoreProduct p2) {
		return taxicabDistanceBetweenPoints(p1.getX(), p1.getY(), p2.getX(), p2.getY()); 
	}
	
	/* Calculates the distance between Cartesian coordinates (x1, y1) and (x2, y2) */
	public static double distanceBetweenPoints(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
	}
	
	/* Calculates the Manhattan distance between Cartesian coordinates (x1, y1) and (x2, y2) */
	public static double taxicabDistanceBetweenPoints(int x1, int y1, int x2, int y2) {
		return Math.abs(x2 - x1) + Math.abs(y2 - y1);
	}
}

/* The counterpart to C++ pairs, made specifically for this project */
class Pair<T, U> {
	
	T left;
	U right;

	public Pair(T left, U right) {
		this.left = left;
		this.right = right;
	}
	
	public T first() {
		return left;
	}
	
	public U second() {
		return right;
	}
	
	public void print() {
		System.out.println(left + ", " + right);
	}

}