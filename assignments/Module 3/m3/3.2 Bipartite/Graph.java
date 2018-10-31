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
     *
     * @param      ve  integer variable.
     * @param      e   integer variable.
     */
    public Graph(final int ve, final int e) {
        this(ve);
        for (int i = 0; i < e; i++) {
            int ver = (int) (Math.random() * ve);
            int w = (int) (Math.random() * ve);
            addEdge(ver, w);
        }
    }
   /**
     * Return the number of vertices in the graph.
     */
    public int v() { 
        return v;
    }

   /**
     * Return the number of edges in the graph.
     */
    public int e() { 
        return e;
    }


     /**
      * Adds an edge.
      *
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
     *
     * @return  array.
     */
    public Iterable<Integer> adj(final int ve) {
        return adj[ve];
    }


   // /**
   //   * Return a string representation of the graph.
   //   * @return string representation.
   //   */
   //  public String toString() {
   //      StringBuilder s = new StringBuilder();
   //      String NEWLINE = System.getProperty("line.separator");
   //      s.append(v + " vertices, " + e + " edges " + NEWLINE);
   //      for (int i = 0; i < v; i++) {
   //          s.append(i + ": ");
   //          for (int w : adj[i]) {
   //              s.append(w + " ");
   //          }
   //          s.append(NEWLINE);
   //      }
   //      return s.toString();
   //  }

}

