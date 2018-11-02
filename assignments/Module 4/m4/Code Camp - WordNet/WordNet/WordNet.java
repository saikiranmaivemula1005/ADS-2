import java.util.*;
import java.io.*;
/**
 * Class for word net.
 */
public class WordNet {
    HashMap<String, ArrayList<Integer>> h = new HashMap<String, ArrayList<Integer>>();
    HashMap<Integer, String> h2 = new HashMap<Integer, String>();
    Digraph dg;
    SAP sap;
    boolean hasCycle = false;
    boolean hasMultipleRoots = false;
    /**
     * Constructs the object.
     *
     * @param      synsets    The synsets
     * @param      hypernyms  The hypernyms
     */
    public WordNet(final String synsets, final String hypernyms) {
        try {
        File fileOne = new File("C:\\Users\\sai kiranmai\\Documents\\ADS-2\\assignments\\Module 4\\m4\\Code Camp - WordNet\\WordNet\\Files" + "\\" + synsets);
        Scanner fOne = new Scanner(fileOne);
        File fileTwo = new File("C:\\Users\\sai kiranmai\\Documents\\ADS-2\\assignments\\Module 4\\m4\\Code Camp - WordNet\\WordNet\\Files" + "\\" + hypernyms);
        Scanner fTwo = new Scanner(fileTwo);
           while (fOne.hasNext()) {
            String[] tokens = fOne.nextLine().split(",");
            h2.put(Integer.parseInt(tokens[0]), tokens[1]);
            String[] words = tokens[1].split(" ");
            for (int i = 0; i < words.length; i++) {
                if (h.containsKey(words[i])) {
                    ArrayList arraylist = h.get(words[i]);
                    arraylist.add(tokens[0]);
                } else {
                    ArrayList<Integer> arraylist = new ArrayList<Integer>();
                    arraylist.add(Integer.parseInt(tokens[0]));
                    h.put(words[i], arraylist);
                }
            }
        }
        dg = new Digraph(h.size());
        while (fTwo.hasNextLine()) {
            String[] tokens = fTwo.nextLine().split(",");
            for (int i = 1; i < tokens.length; i++) {
                dg.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[i]));
            }
            DirectedCycle dc = new DirectedCycle(dg);
            if (dc.hasCycle()) {
                hasCycle = true;
            }
            // int roots = 0;
            // for (int i = 0; i < dg.v(); i++) {
            //     if (dg.adj(i).hasNext()) {
            //         roots++;
            //     }
            // }
        }
    
    } catch(Exception e) {
        System.out.println(e);
    }
}
     

    // returns all WordNet nouns
    // public Iterable<String> nouns()

    // // is the word a WordNet noun?
    public boolean isNoun(final String word) {
        // for (String s : h.getKeys()) {
        //     if (s.equals(word)) {
        //         return true;
        //     }
        // }
        return true;
    }

    // // distance between nounA and nounB (defined below)
    public int distance(final String nounA, final String nounB) {
        ArrayList id1 = h.get(nounA);
        ArrayList id2 = h.get(nounB);
        sap = new SAP(dg);
        return sap.length(id1, id2);
    }

    // // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // // in a shortest ancestral path (defined below)
    public String sap(final String nounA, final String nounB) {
        if (!isNoun(nounA) || isNoun(nounB)) {
            System.out.println("Exception");
        }
        ArrayList id1 = h.get(nounA);
        ArrayList id2 = h.get(nounB);
        sap = new SAP(dg);
        int ans = sap.ancestor(id1, id2);
        return h2.get(ans);
    }

}
