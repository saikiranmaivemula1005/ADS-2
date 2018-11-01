import java.util.Scanner;
/**
 * Class for graph.
 */
class Graph {
    /**
     * integer variable vertices.
     */
    private  int vertices;
    /**
     * integer variable edges.
     */
    private int edges;
    /**
     * array of bag type.
     */
    private Bag<Integer>[] adj;
    /**
     * Constructs the object.
     */
    Graph() {

    }
    /**
     * Constructs the object.
     * Time complexity : O(V).
     * @param      v     integer variable.
     */
    Graph(final int v) {
        this.vertices = v;
        this.edges = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    /**
     * returns vertices.
     * Time complexity O(1).
     * @return  vertices.
     */
    public int v() {
        return vertices;
    }
    /**
     * returns edges.
     * Time complexity : O(1).
     * @return edges.
     */
    public int e() {
        return edges;
    }
    /**
     * Adds an edge.
     * Time complexity O(V)
     * @param      v     integer variable.
     * @param      w     integer variable.
     */
    public void addEdge(final int v, final int w) {
        if (!hasEdge(v, w)) {
            edges++;
            adj[v].add(w);
            adj[w].add(v);
        }
        if (v == w) {
            return;
        }
    }
    /**
     * Determines if it has edge.
     *
     * @param      v     integer variable.
     * @param      w     integer variable.
     * Time complexity O(V)
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v, final int w) {
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
    /**
     * iterable function.
     *
     * @param      v integer variable.
     * Time complexity : O(1)
     * @return   array.
     */
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }
    /**
     * matrix method.
     * Time complexity : O(1)
     * @return   array.
     */
    public Bag[] matrix() {
        return adj;
    }
    /**
     * list method.
     * Time complexity : O(1)
     * @return  array.
     */
    public Bag[] list() {
        return adj;
    }
}
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {

    }
    /**
     * main method.
     *Time complexity : O(V^2)
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String format = sc.nextLine();
        int vertices = Integer.parseInt(sc.nextLine());
        int edges = Integer.parseInt(sc.nextLine());
        Graph g = new Graph(vertices);
        String[] inputs = sc.nextLine().split(",");
        if (inputs.length > 2) {
            for (int i = 0; i < edges; i++) {
                String[] tokens = sc.nextLine().split(" ");
                g.addEdge(Integer.parseInt(tokens[0]),
                 Integer.parseInt(tokens[1]));
            }
        }
        System.out.println(g.v() + " vertices, " + g.e() + " edges");
        if (inputs.length < 2) {
            System.out.println("No edges");
            return;
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
                System.out.print((inputs[v] + ": "));
                for (int w : adj[v]) {
                    System.out.print((inputs[w] + " "));
                }
                System.out.print("\n");
            }
            break;
        default:
        }
    }
}



