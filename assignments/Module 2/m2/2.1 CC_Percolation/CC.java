/**
 * Class for cc.
 */
public class CC {
    /**
     * { var_description }.
     */
    private boolean[] marked;
    /**
     * { var_description }.
     */
    private int[] id;
    /**
     * { var_description }.
     */
    private int[] size;
    /**
     * { var_description }.
     */
    private int count;

    /**
     * Constructs the object.
     *
     * @param      g     { parameter_description }
     */
    public CC(final Graph g) {
        marked = new boolean[g.v()];
        id = new int[g.v()];
        size = new int[g.v()];
        for (int v = 0; v < g.v(); v++) {
            if (!marked[v]) {
                dfs(g, v);
                count++;
            }
        }
    }
    /**
     * dfs method.
     *
     * @param      g     { parameter_description }
     * @param      v     { parameter_description }
     */
    private void dfs(final Graph g, final int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    /**
     * id method.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int id(final int v) {
        validateVertex(v);
        return id[v];
    }

    /**
     * size method.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int size(final int v) {
        validateVertex(v);
        return size[id[v]];
    }

    /**
     * Returns the number of connected components in the graph {@code G}.
     *
     * @return the number of connected components in the graph {@code G}
     */
    public int count() {
        return count;
    }

    /**
     * connected method.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean connected(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }

    /**
     * are connected method.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    @Deprecated
    public boolean areConnected(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }
    /**
     * validate vertex.
     *
     * @param      v     { parameter_description }
     */
    private void validateVertex(final int v) {
        int markedlength = marked.length;
        if (v < 0 || v >= markedlength) {
            throw new
            IllegalArgumentException("vertex "
             + v + " is not between 0 and " + (markedlength - 1));
        }
    }
}
