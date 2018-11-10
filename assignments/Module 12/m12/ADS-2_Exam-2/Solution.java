import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner sc = new Scanner(System.in);
		int numberOfCities = Integer.parseInt(sc.nextLine());
		int numberOfRoadlines = Integer.parseInt(sc.nextLine());
		EdgeWeightedGraph ewg = new EdgeWeightedGraph(numberOfCities);
		for (int i = 0; i < numberOfRoadlines; i++) {
			String[] tokens = sc.nextLine().split(" ");
			Edge e = new Edge(Integer.parseInt(tokens[0]),
			                  Integer.parseInt(tokens[1]),
			                  Float.parseFloat(tokens[2]));
			ewg.addEdge(e);
		}
		String caseToGo = sc.nextLine();
		switch (caseToGo) {
		case "Graph":
			ewg.print();
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}

	}
}