import java.util.Scanner;
import java.util.HashMap;
/**
 *class for solution.
 */
final class Solution {
    /**
     *an empty constructor.
     */
    private Solution() {
    }
    /**
     *the main method is to read the user.
     * input.
     *time complexity is O(E + V)
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> maps
        = new HashMap<String, Integer>();
        String[] token = sc.nextLine().split(" ");
        int edges = Integer.parseInt(token[1]);
        String[] vertices = sc.nextLine().split(" ");
        for (int i = 0; i < vertices.length; i++) {
            maps.put(vertices[i], i);
        }
        Edge e;
        EdgeWeightedGraph ewg
        = new EdgeWeightedGraph(vertices.length);
        for (int i = 0; i < edges; i++) {
            String[] directPath = sc.nextLine().split(" ");
            e = new Edge(maps.get(directPath[0]),
                               maps.get(directPath[1]),
                               Double.parseDouble(directPath[2]));
            ewg.addEdge(e);
        }
        int queries = Integer.parseInt(sc.nextLine());
        DijkstraSP d;
        for (int i = 0; i < queries; i++) {
            String[] check = sc.nextLine().split(" ");
            int source = maps.get(check[0]);
            d = new DijkstraSP(ewg, source);
            System.out.println((int) d.distance(maps.get(check[1])));
        }
    }
}
