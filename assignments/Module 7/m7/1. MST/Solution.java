import java.util.Scanner;
class Solution {
	protected Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		int edges = sc.nextInt();
		EdgeWeightedGraph ewd = new EdgeWeightedGraph(vertices);
		while (sc.hasNextLine()) {
			String[] tokens = sc.nextLine().split(" ");
			Edge e = new Edge(Integer.parseInt(tokens[0]),
			                  Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
			ewd.addEdge(e);
		}
		KruskalMST mst = new KruskalMST(ewd);
		System.out.format("%.5f", mst.weight());
	}
}