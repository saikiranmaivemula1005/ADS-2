import java.util.Scanner;
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
     * Time complexity : O(V).
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        Digraph dg = new Digraph(vertices);
        while (sc.hasNext()) {
            dg.addEdge(sc.nextInt(), sc.nextInt());
        }
        DirectedCycle dc = new DirectedCycle(dg);
        dc.dfs(dg, 0);
        if (dc.hasCycle()) {
            System.out.println("Cycle exists.");
        } else {
            System.out.println("Cycle doesn't exists.");
        }
    }
}
