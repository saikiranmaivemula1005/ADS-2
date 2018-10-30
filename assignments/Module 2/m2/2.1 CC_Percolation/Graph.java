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
     * Time complexity : O(n).
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
     * Time complexity O(n)
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
     * Time complexity O(n)
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
}