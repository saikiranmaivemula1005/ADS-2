import java.util.ArrayList;
public class BoggleSolver {
	TST<Integer> tst;
	public BoggleSolver(String[] dictionary) {
		tst = new TST<Integer>();
		for (int i = 0; i < dictionary.length; i++) {
			tst.put(dictionary[i], i);
		}
	}

	// Returns the set of all valid words in the given Boggle board, as an Iterable.
	public Iterable<String> getAllValidWords(BoggleBoard board) {
		boolean[][] marked = new boolean[board.rows()][board.cols()];
		ArrayList<String> arraylist = new ArrayList<String>();
		for (int i = 0; i < board.rows(); i++) {
			for (int j = 0; j < board.cols(); j++) {
				String str = "" + board.getLetter(i, j);
				marked[i][j] = true;
				dfs(arraylist, str, i, j, marked, board);
			}
		}
		return new Bag<String>();
	}
	public void dfs(ArrayList<String> lst, String ch, int row, int col, boolean[][] marked, BoggleBoard board) {
		if (ch.length() >= 3 && tst.contains(ch)) {
			lst.add(ch);
		}
		if (!tst.hasPrefix(ch)) {
			return;
		}
		for (int i = 0; i < board.rows(); i++) {
			for (int j = 0; j < board.cols(); j++) {
				if (marked[row][col] == true) {
					continue;
				}
				ch += "" + board.getLetter(i, j);
				marked[row][col] = true;
				dfs(lst, ch, i, j, marked, board);
			}
		}
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