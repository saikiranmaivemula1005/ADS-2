import java.util.Scanner;
class Solution {
	protected Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String synset = sc.nextLine();
		String hypernyms = sc.nextLine();
		try {
			WordNet w = new WordNet(synset, hypernyms);
			String inputType = sc.nextLine();
			if (w.hasCycle) {
				System.out.println("Cycle detected");
				return;
			}
			
			if (inputType.equals("Graph")) {
				w.checkMultipleRoots();
			if (w.hasMultipleRoots) {
				
				return;
			}else{
				
				System.out.println(w.dg);
			}
			}
			if (inputType.equals("Queries")) {
				while (sc.hasNextLine()) {
					String[] tokens = sc.nextLine().split(" ");
					try {
						w.sap(tokens[0], tokens[1]);
						System.out.println("distance = " + w.distance(tokens[0], tokens[1]) + ", ancestor = " + w.sap(tokens[0], tokens[1]));

					} catch (Exception e) {
						System.out.println("IllegalArgumentException");
					}
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}