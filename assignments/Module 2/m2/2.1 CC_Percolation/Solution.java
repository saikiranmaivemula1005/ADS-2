import java.util.Scanner;
/**
 * Class for percolation.
 */
 class Percolation {
/**
 * grid matrix.
 */
    private int[][] grid;
    /**
     * top variable.
     */
    private int top = 0;
    /**
     * integer to count.
     */
    private int count;
    /**
     * bottom variable.
     */
    private int bottom;
    /**
     * size variable.
     */
    private int size;
    /**
     * variable for weighted quick addEdge.
     */
    private Graph g;
    /**
     * connected components.
     */
    private CC cc;
    /**
     * constructor for percolation class.
     * @param n integer variable.
     */
     Percolation(final int n) {
        g = new Graph(n * n + 2);
        count = 0;
        grid = new int[n][n];
        cc = new CC(g);
        this.size = n;
    }

    /**
     * @param i integer variable.
     * @param j integer variable.
     * open method for percolation class.
     */
    public void open(final int i, final int j) {
        grid[i - 1][j - 1] = 1;
        if (i == 1) {
            g.addEdge(component(i, j), top);
        }
        if (i == size) {
            g.addEdge(component(i, j), bottom);
        }

        if (j > 1 && isOpen(i, j - 1)) {
            g.addEdge(component(i, j), component(i, j - 1));
        }
        if (j < size && isOpen(i, j + 1)) {
            g.addEdge(component(i, j), component(i, j + 1));
        }
        if (i > 1 && isOpen(i - 1, j)) {
            g.addEdge(component(i, j), component(i - 1, j));
        }
        if (i < size && isOpen(i + 1, j)) {
            g.addEdge(component(i, j), component(i + 1, j));
        }
    }

    /**
     * checks if the given block is open or not.
     * @param i integer variable.
     * @param j integer variable.
     * @return returns true if the given block is open.
     */
    public boolean isOpen(final int i, final int j) {
        return grid[i - 1][j - 1] == 1;
    }

    /**
     * checks if block is full or not.
     * @param i integer variable.
     * @param j integer variable.
     * @return returns true if the given block is full.
     */
    public boolean isFull(final int i, final int j) {
        if (0 < i && i <= size && 0 < j && j <= size) {
            return g.hasEdge(top, component(i, j));
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * checks for percolation.
     * @return returns true if percolation is possible.
     */
    public boolean percolates() {
        return cc.connected(top, bottom);
    }
    /**
     * method to find the component at given indices.
     *
     * @param      i  integer variable.
     * @param      j  integer variable.
     *
     * @return returns the component value.
     */
    private int component(final int i, final int j) {
        return size * (i - 1) + j;
    }
}
class Solution {
	protected Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		Percolation p = new Percolation(size);
		while (sc.hasNext()) {
			p.open(sc.nextInt(), sc.nextInt());
		}
		System.out.println(p.percolates());
	}
}