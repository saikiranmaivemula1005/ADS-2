import java.util.Scanner;
class Graph {
	private final int vertices;
    private int edges;
    private Bag<Integer>[] adj;
    Graph() {
    	vertices = 0;
    	edges = 0;
    }
    public int V() {
    	return vertices;
    }
    public int E() {
    	return edges;
    }
    private void validateVertex(int v) {
        if (v < 0 || v >= vertices)
            System.out.println("vertex " + v + " is not between 0 and " + (vertices-1));
    }
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        edges++;
        adj[v].add(w);
        adj[w].add(v);
    }
    public boolean hasEdge(int v, int w) {
    	return (contains(v, w));
    }
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
    public boolean contains(int v, int w) {
    	// for (int i = 0; i < adj.length; i++) {
    	// 	if (adj[i] = w) {
    	// 		return true;
    	// 	}
    	// }
    	return true;
    }
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices + " vertices, " + edges + " edges " + "\n");
        for (int v = 0; v < vertices; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    public void matrix() {
    	
    }
    public void list() {
    	return;
    }

}
class Solution {
	protected Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Graph g = new Graph();
		String format = sc.nextLine();
		int vertices = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());
		String[] inputs = sc.nextLine().split(",");
		for (int i = 0; i < edges; i++) {
			String[] tokens = sc.nextLine().split(" ");
			g.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		}
		System.out.println(vertices + " vertices, " + edges + " edges");
		switch (format) {
			case "Matrix":
				g.matrix();
				break;
			case "List":
				g.list();
		}
	}
}
