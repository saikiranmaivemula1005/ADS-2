/**
 * Class for graph.
 */
public class Graph {
    /**
     * integer variable.
     */
    private final int v;
    /**
     * integer variable.
     */
    private int e;
    /**
     * array of bag type.
     */
    private Bag<Integer>[] adj;
    /**
     * array of bag type.
     */
    private Bag<Boolean>[] visited;
   /**
     * array of bag type.
     */
    private Bag<Integer>[] colour;
    /**
     * Constructs the object.
     *
     * @param      ve   vertex.
     */
    public Graph(final int ve) {
        this.v = ve;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    /**
     * Constructs the object.
     *Time Complexity : O(N).
     * @param      ve  integer variable.
     * @param      ed   integer variable.
     */
    public Graph(final int ve, final int ed) {
        this(ve);
        for (int i = 0; i < ed; i++) {
            int ver = (int) (Math.random() * ve);
            int w = (int) (Math.random() * ve);
            addEdge(ver, w);
        }
    }
   /**
     * Return the number of vertices in the graph.
     * Time Complexity : O(1).
     * @return v
     */
    public int v() {
        return v;
    }

   /**
     * Return the number of edges in the graph.
     * Time Complexity : O(1).
     * @return e
     */
    public int e() {
        return e;
    }


     /**
      * Adds an edge.
      *Time Complexity : O(1).
      * @param      ve  integer variable.
      * @param      w   integer variable.
      */
    public void addEdge(final int ve, final int w) {
        e++;
        adj[ve].add(w);
        adj[w].add(ve);
    }


    /**
     * iterable.
     *
     * @param      ve integer variable.
     *Time Complexity : O(N).
     * @return  array.
     */
    public Iterable<Integer> adj(final int ve) {
        return adj[ve];
    }
}


