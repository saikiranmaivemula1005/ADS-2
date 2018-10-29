import java.util.Scanner;
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
    }
    public int V() {
    	return vertices;
    }
    public int E() {
    	return edges;
    }
    // private void validateVertex(int v) {
    //     if (v < 0 || v >= vertices)
    //         System.out.println("vertex " + v + " is not between 0 and " + (vertices-1));
    // }
    public void addEdge(int v, int w) {
       if (hasEdge(v, w)) {
        edges++;
       }
        adj[v].add(w);
        adj[w].add(v);
       }
    public boolean hasEdge(int v, int w) {
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
    public void matrix() {
    	for (int v = 0; v < vertices; v++) {
            System.out.println((v + ": "));
            for (int w : adj[v]) {
            System.out.print(check(v, w) + " ");
            }
            System.out.print("\n");
        }
    }
    public void list() {
    	for (int v = 0; v < vertices; v++) {
            System.out.println((v + ": "));
            for (int w : adj[v]) {
            System.out.println((w + " "));
            }
            // System.out.print("\n");
        }
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
		System.out.println(g.V() + " vertices, " + g.E() + " edges");
		String[] inputs = sc.nextLine().split(",");
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		for (int i = 0; i < vertices; i++) {
			st.put(inputs[i], i);
		}
		if (inputs.length < 2) {
			System.out.println("No edges");
		}
		for (int i = 0; i < edges; i++) {
			String[] tokens = sc.nextLine().split(" ");
			g.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		}
		switch (format) {
			case "Matrix":
				g.matrix();
				break;
			case "List":
				g.list();
		}
	}
}
