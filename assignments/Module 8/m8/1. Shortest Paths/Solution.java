import java.util.Scanner;
import java.util.HashMap;
/**
 *class for solution.
 */
class Solution {
    /**
     * constructor.
     */
    private Solution() {
    }
    /**
     * main method.
     *
     *time complexity : O(E + V)
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Integer> h
            = new HashMap<String, Integer>();
        String[] tokens = scan.nextLine().split(" ");
        int edges = Integer.parseInt(tokens[1]);
        String[] vertices = scan.nextLine().split(" ");
        for (int i = 0; i < vertices.length; i++) {
            h.put(vertices[i], i);
        }
        Edge e;
        EdgeWeightedGraph ewg
            = new EdgeWeightedGraph(vertices.length);
        for (int i = 0; i < edges; i++) {
            String[] directPath = scan.nextLine().split(" ");
            e = new Edge(h.get(directPath[0]),
                         h.get(directPath[1]),
                         Double.parseDouble(directPath[2]));
            ewg.addEdge(e);
        }
        int queries = Integer.parseInt(scan.nextLine());
        DijkstrasSP dsp;
        for (int i = 0; i < queries; i++) {
            String[] check = scan.nextLine().split(" ");
            int source = h.get(check[0]);
            dsp = new DijkstrasSP(ewg, source);
            System.out.println((int) dsp.distance(h.get(check[1])));
        }
    }
}