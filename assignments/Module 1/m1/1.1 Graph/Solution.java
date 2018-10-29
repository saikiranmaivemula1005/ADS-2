import java.util.*;
class Graph {
	private  int vertices;
    private int edges;
    private Bag<Integer>[] adj;
    Graph() {

    }
    Graph(int v, int e) {
    	this.vertices = v;
    	this.edges = e;
    	adj = (Bag<Integer>[]) new Bag[v];
    	for (int i = 0; i < v; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    public int V() {
    	return vertices;
    }
    public int E() {
    	return edges;
    }
    public void addEdge(int v, int w) {
       if (hasEdge(v, w)) {
        edges++;
       }
       if (v == w) {
       	return;
       }
        adj[v].add(w);
        adj[w].add(v);
       }
    public boolean hasEdge(int v, int w) {
    	if (adj[v] == null) {
    		return true;
    	}
    	for (int i : adj[v]) {
    		if (i == w) {
    			return true;
    		}
    	}
    	return false;
    }
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
    public int degree(int v) {
        return adj[v].size();
    }
    public int check(int v, int w) {
        if (hasEdge(v, w) == true) {
        	return 1;
        }
        return 0;
    }
    public Bag[] matrix() {
    	return adj;
    }
    public Bag[] list() {
    	return adj;
    }

}
class Solution {
	protected Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String format = sc.nextLine();
		int vertices = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());
		Graph g = new Graph(vertices, edges);
		System.out.println(g.V() + " vertices, " + edges + " edges");
		String[] inputs = sc.nextLine().split(",");
		SequentialSearchST<Integer, String> st = new SequentialSearchST<Integer, String>();
		for (int i = 0; i < vertices; i++) {
			st.put(i, inputs[i]);
		}
		if (inputs.length < 2) {
			System.out.println("No edges");
			return;
		}
		for (int i = 0; i < edges; i++) {
			String[] tokens = sc.nextLine().split(" ");
			g.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		}
		switch (format) {
			case "Matrix":
				Bag<Integer>[] adj = g.matrix();
				int[][] matrix = new int[vertices][vertices];
				for (int i = 0; i < vertices; i++) {
					for (int j = 0; j < vertices; j++) {
						if (g.hasEdge(i, j)) {
							matrix[i][j] = 1;
						}
					}
				}
				for (int i = 0; i < vertices; i++) {
					for (int j = 0; j < vertices; j++) {
						System.out.print(matrix[i][j] + " ");
					}
					System.out.println();
				}
				break;
			case "List":
				g.list();
				adj = g.list();
				for (int v = 0; v < vertices; v++) {
            	System.out.print((st.get(v) + ": "));
            		for (int w : adj[v]) {
           	 			System.out.print((st.get(w) + " "));
            }
            System.out.print("\n");
        }
		}
	}
}
