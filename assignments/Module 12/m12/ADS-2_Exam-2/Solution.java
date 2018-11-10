import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // Self loops are not allowed...
        // Parallel Edges are allowed...
        // Take the Graph input here...
        Scanner sc = new Scanner(System.in);
        int numberOfCities = Integer.parseInt(sc.nextLine());
        int numberOfRoadlines = Integer.parseInt(sc.nextLine());
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(numberOfCities);
        for (int i = 0; i < numberOfRoadlines; i++) {
            String[] tokens = sc.nextLine().split(" ");
            Edge e = new Edge(Integer.parseInt(tokens[0]),
                              Integer.parseInt(tokens[1]),
                              Double.parseDouble(tokens[2]));
            ewg.addEdge(e);
        }
        String caseToGo = sc.nextLine();
        switch (caseToGo) {
        case "Graph":
            ewg.print();
            break;

        case "DirectedPaths":
            // Handle the case of DirectedPaths, where two integers are given.
            // First is the source and second is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            String[] line = sc.nextLine().split(" ");
            int source = Integer.parseInt(line[0]);
            int destination = Integer.parseInt(line[1]);
            DijkstraSP dsp = new DijkstraSP(ewg, source);
            if (dsp.hasPathTo(destination)) {
                System.out.println(dsp.distance(destination));
            } else {
                System.out.println("No Path Found.");
            }

            break;

        case "ViaPaths":
            // Handle the case of ViaPaths, where three integers are given.
            // First is the source and
            // second is the via is the one where path should pass throuh.
            // third is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            line = sc.nextLine().split(" ");
            source = Integer.parseInt(line[0]);
            int via = Integer.parseInt(line[1]);
            destination = Integer.parseInt(line[2]);
            dsp = new DijkstraSP(ewg, source);
            if (dsp.hasPathTo(via)) {
                double temp = dsp.distance(via);
                source = via;
                dsp = new DijkstraSP(ewg, source);
                if (dsp.hasPathTo(destination)) {
                    System.out.println(dsp.distance(destination) + temp);
                    System.out.print(source + " ");
                    dsp.path(destination);
                    System.out.print(destination);
                } else {
                    System.out.println("No Path Found.");
                }
            } else {
                System.out.println("No Path Found.");
            }
            break;

        default:
            break;
        }

    }
}