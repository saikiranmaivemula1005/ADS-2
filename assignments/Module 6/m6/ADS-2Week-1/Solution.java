import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
class PageRank {
	Digraph dg;
	double[] pagerank;
	double initalpr;
	int[] indegrees;
	int prev = 0;
	ArrayList<Integer> outdegree;
	PageRank(Digraph digraph) {
		this.dg = digraph;
		pagerank = new double[dg.v()];
		initalpr = 1d / dg.v();
		indegrees = new int[dg.v()];
		outdegree = new ArrayList<Integer>();
		// System.out.println(initalpr);
		for (int i = 0; i < dg.v(); i++) {
			System.out.println("incoming nodes of " + i + "are" +dg.h.get(i));
			outdegree.add(dg.h.get(i).get(i));
			indegrees[i] = dg.indegree(i);
			for (int j = 0; j < 1000; j++) {
				for (int k = 0; k < indegrees[i]; k++) {
					pagerank[i] += initalpr / dg.outdegree(prev) / 1000;
					prev = outdegree.get(indegrees[i]);
				}
			}
			System.out.println(i + " - " +pagerank[i]);
		}
	}
}

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices
		Scanner sc = new Scanner(System.in);
		int vertices = Integer.parseInt(sc.nextLine());
		Digraph dg = new Digraph(vertices);
		while (sc.hasNextLine()) {
			String[] tokens = sc.nextLine().split(" ");
			for (int i = 1; i < tokens.length; i++) {
				dg.addEdge(Integer.parseInt(tokens[0]),
				           Integer.parseInt(tokens[i]));
			}
		}
		System.out.println(dg);
		PageRank pg = new PageRank(dg);

		// iterate count of vertices times
		// to read the adjacency list from std input
		// and build the graph


		// Create page rank object and pass the graph object to the constructor

		// print the page rank object

		// This part is only for the final test case

		// File path to the web content
		String file = "WebContent.txt";

		// instantiate web search object
		// and pass the page rank object and the file path to the constructor

		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky

	}
}
