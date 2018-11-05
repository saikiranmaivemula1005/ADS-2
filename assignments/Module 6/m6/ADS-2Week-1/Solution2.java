import java.util.Scanner;
class PageRank {
    /**.
     * graph as g
     */
    private Digraph g;
    /**.
     * reverse of the given graph as reversegraph
     */
    private Digraph reversegraph;
    /**.
     * variable for vertices
     */
    private int vertices;
    /**.
     * array to store the pageRanks
     */
    private Double[] pgRank;
    /**.
     * constructor
     *
     * @param      gr    The graphics
     */
    PageRank(final Digraph gr) {
        this.g = gr;
        this.reversegraph = g.reverse();
        this.vertices = g.v();
        pgRank = new Double[vertices];
        int ver = g.v();
        for (int i = 0; i < vertices; i++) {
            pgRank[i] = 1.0 / ver;
        }
        findPageRank();
    }
    /**.
     * method to calculate the page Rank
     */
    public void findPageRank() {
        for (int i = 0; i < vertices; i++) {
            if (g.outdegree(i) == 0) {
                for (int j = 0; j < vertices; j++) {
                    if (i != j) {
                        g.addEdge(i, j);
                    }
                }
            }
        }
        Double[] tempPR = new Double[vertices];
        final int thou = 1000;
        for (int k = 0; k < thou; k++) {
            for (int i = 0; i < vertices; i++) {
                Double sum = 0.0;
                for (int each : g.reverse().adj(i)) {
                    sum = sum
                          + pgRank[each] / g.outdegree(each);
                }
                tempPR[i] = sum;
            }
        }
        pgRank = tempPR;
    }
    void print() {
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " - " + pgRank[i]);
        }
    }
    class WebSearch {
    }
}
class Solution2 {
    /**.
     * constructor
     */
    protected Solution2() {
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int noOfVertices = Integer.parseInt(s.nextLine());
        Digraph g = new Digraph(noOfVertices);
        for (int i = 0; i < noOfVertices; i++) {
            String[] tokens = s.nextLine().split(" ");
            for (int j = 1; j < tokens.length; j++) {
                int id = Integer.parseInt(tokens[0]);
                int node = Integer.parseInt(tokens[j]);
                g.addEdge(id, node);
            }
        }
        System.out.println(g.toString());
        PageRank pg = new PageRank(g);
        pg.print();
        // Create page rank object to
        //pass the graph object to the constructor
        // print the page rank object

        // This part is only for the final test case

        // File path to the web content
        String file = "WebContent.txt";

        // instantiate web search object
        // and pass the page rank object
        // and the file path to the constructor

        // read the search queries from std in
        // remove the q= prefix and extract the search word
        // pass the word to iAmFeelingLucky method of web search
        // print the return value of iAmFeelingLucky

    }
}