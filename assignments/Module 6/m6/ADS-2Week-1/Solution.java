import java.util.Scanner;
class PageRank {
	Digraph dg;
	PageRank(Digraph digraph) {
		this.dg = digraph;

	}
}

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		Digraph dg = new Digraph(vertices);
		String[] tokens = sc.nextLine().split(" ");
		for (int i = 1; i < tokens.length; i++) {
			dg.addEdge(Integer.parseInt(tokens[0]),
			           Integer.parseInt(tokens[i]));
		}
		PageRank pg = new PageRank(dg);
		System.out.println(pg);

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
