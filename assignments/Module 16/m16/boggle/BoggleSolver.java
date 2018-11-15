public class BoggleSolver {
	// Initializes the data structure using the given array of strings as the dictionary.
	// (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
	public BoggleSolver(String[] dictionary) {

	}

	// Returns the set of all valid words in the given Boggle board, as an Iterable.
	public Iterable<String> getAllValidWords(BoggleBoard board) {
		return new Bag<String>();
	}

	// Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the uppercase letters A through Z.)
	public int scoreOf(String word) {
		if (word.length() <= 4 && word.length() >= 3) {
			return 1;
		}
		if (word.length() == 5) {
			return 2;
		}
		if (word.length() == 6) {
			return 3;
		}
		if (word.length() == 7) {
			return 5;
		}
		if (word.length() >= 7) {
			return 11;
		}
		return 0;
	}
}