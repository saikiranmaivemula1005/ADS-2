public class SAP {
    Digraph dg;
    int distance = Integer.MAX_VALUE;
    int ancestor1 =-1;
    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph digraph) {
        dg = digraph;
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        ancestor(v, w);
        return distance;
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        BreadthFirstDirectedPaths b1 = new BreadthFirstDirectedPaths(dg, v);
        BreadthFirstDirectedPaths b2 = new BreadthFirstDirectedPaths(dg, w);
        for (int vertices = 0; vertices < dg.v(); vertices++) {
            if (b1.hasPathTo(vertices) && b2.hasPathTo(vertices)) {
                int newdistance = b1.distTo(vertices) + b2.distTo(vertices);
                if (newdistance < distance) {
                    distance = newdistance;
                    ancestor1 = vertices;
                }
            }
        }
        return ancestor1;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        ancestor(v, w);
        return distance;
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        for (int v1 : v) {
            for (int w1 : w) {
                ancestor1 = ancestor(v1, w1);
            }
        }
        return ancestor1;
    }

    // do unit testing of this class
    // public static void main(String[] args)
}