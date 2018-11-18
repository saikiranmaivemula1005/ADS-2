import java.util.*;
public class BoggleSolver {
	TrieST tst;
	// Initializes the data structure using the given array of strings as the dictionary.
	// (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
	public BoggleSolver(String[] dictionary) {
		tst = new TrieST();
		for (int i = 0; i < dictionary.length; i++) {
			tst.add(dictionary[i]);
		}
    }
    // Returns the set of all valid words in the given Boggle board, as an Iterable.
	public Iterable<String> getAllValidWords(BoggleBoard board) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < board.rows(); i++) {
			for (int j = 0; j < board.cols(); j++) {
				boolean[][] marked = new boolean[board.rows()][board.cols()];
				dfs(list, "", i, j, marked, board);
            }
		}
		return list;
	}
	public void dfs(ArrayList<String> lst, String ch, int row, int col, boolean[][] marked, BoggleBoard board) {
		if (marked[row][col]) {
			return;
		}
		char c = board.getLetter(row, col);
		String st = ch;
		if (c == 'Q') {
			st += "QU";
		} else {
			st += c;
		}
		if (!tst.hasPrefix(st)) {
            return;
		}
		if (st.length() > 2 && tst.contains(st)) {
			if (!lst.contains(st)) {
			    lst.add(st);
			}
		}
		marked[row][col] = true;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				if ((row + i >= 0) && (row + i < board.rows()) && (col + j >= 0) && (col + j < board.cols())) {
					dfs(lst, st, i + row, j + col, marked, board);
				}
            }
		}
		marked[row][col] = false;
    }
    // Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the uppercase letters A through Z.)
	public int scoreOf(String word) {
		if (tst.contains(word)) {
			if(word.length() >= 0 && word.length() <= 2) {
		        return 0;
	        }

			if (word.length() >= 3  && word.length() <= 4) {
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
            if (word.length() >= 8) {
                return 11;
            } 
	    }return 0;
	}
}