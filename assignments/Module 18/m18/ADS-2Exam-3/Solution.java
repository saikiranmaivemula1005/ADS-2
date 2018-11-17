import java.util.Scanner;
import java.util.*;

public class Solution {

	// Don't modify this method.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String cases = scan.nextLine();

		switch (cases) {
		case "loadDictionary":
			// input000.txt and output000.txt
			BinarySearchST<String, Integer> hash = loadDictionary("/Files/t9.csv");
			while (scan.hasNextLine()) {
				String key = scan.nextLine();
				System.out.println(hash.get(key));
			}
			break;

		case "getAllPrefixes":
			// input001.txt and output001.txt
			T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
			while (scan.hasNextLine()) {
				String prefix = scan.nextLine();
				t9.getAllWords(prefix);
				// for (String each : t9.getAllWords(prefix)) {
				// 	System.out.println(each);
				// }
			}
			break;

		case "potentialWords":
			// input002.txt and output002.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			int count = 0;
			while (scan.hasNextLine()) {
				String t9Signature = scan.nextLine();
				for (String each : t9.potentialWords(t9Signature)) {
					count++;
					System.out.println(each);
				}
			}
			if (count == 0) {
				System.out.println("No valid words found.");
			}
			break;

		case "topK":
			// input003.txt and output003.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			Bag<String> bag = new Bag<String>();
			int k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				bag.add(line);
			}
			// for (String each : t9.getSuggestions(bag, k)) {
			// 	System.out.println(each);
			// }
			t9.getSuggestions(bag, k);

			break;

		// case "t9Signature":
		// 	// input004.txt and output004.txt
		// 	t9 = new T9(loadDictionary("/Files/t9.csv"));
		// 	bag = new Bag<String>();
		// 	k = Integer.parseInt(scan.nextLine());
		// 	while (scan.hasNextLine()) {
		// 		String line = scan.nextLine();
		// 		for (String each : t9.t9(line, k)) {
		// 			System.out.println(each);
		// 		}
		// 	}
		// break;

		default:
			break;

		}
	}

	// Don't modify this method.
	public static String[] toReadFile(String file) {
		In in = new In(file);
		return in.readAllStrings();
	}

	public static BinarySearchST<String, Integer> loadDictionary(String file) {
		BinarySearchST<String, Integer>  st = new BinarySearchST<String, Integer>();
		String[] words = toReadFile(file);
		for (int i = 0; i < words.length; i++) {
			String word = words[i].toLowerCase();
			if (st.contains(word)) {
				st.put(word, st.get(word) + 1);
			} else {
				st.put(word, 1);
			}
		}
		return st;
	}

}

class T9 {
	TST<Integer> tst = new TST<Integer>();
	public T9(BinarySearchST<String, Integer> st) {
		Iterable<String> words = st.keys();
		int i = 0;
		for (String str : words) {
			tst.put(str, i++);
		}
	}

	// get all the prefixes that match with given prefix.
	public void getAllWords(String prefix) {
		for (String str : tst.keysWithPrefix(prefix)) {
			System.out.println(str);
		}
	}

	public Iterable<String> potentialWords(String t9Signature) {
		// your code goes here
		return null;
	}

	// return all possibilities(words), find top k with highest frequency.
	public void getSuggestions(Iterable<String> words, int k) {
		// MaxPQ<Integer> maxpq = new MaxPQ<Integer>();
		// for (String str : words) {
		// 	maxpq.insert(tst.get(str));
		// }
		// for (int i = 0; i < k; i++) {
		// 	for (String str : words) {
		// 		if (maxpq.delMax() == tst.get(str)) {
		// 			System.out.println(str);
		// 		}
		// 	}
		// }
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		for (String str : words) {
			hmap.put(str, tst.get(str));
			arraylist.add(tst.get(str));
		}
		Collections.sort(arraylist);
		for (int i=0;i<k;i++){
			System.out.println(hmap.get(arraylist.get(i)));
		}

	}

	// final output
	// Don't modify this method.
	// public Iterable<String> t9(String t9Signature, int k) {
	// 	return getSuggestions(potentialWords(t9Signature), k);
	// }
}
