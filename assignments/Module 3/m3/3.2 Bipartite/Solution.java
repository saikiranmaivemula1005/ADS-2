import java.util.Scanner;
class Solution {
	protected Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		Graph g = new Graph(vertices);
		int edges = sc.nextInt();
		while (sc.hasNext()) {
			g.addEdge(sc.nextInt(), sc.nextInt());
		}
		Bipartite b = new Bipartite(g);
		if (b.isBipartite()) {
			System.out.println("Graph is bipartite");
		} else {
			System.out.println("Graph is not a bipartite");
		}
	}
}