
public class SeamCarver {
	Picture pic;
	public SeamCarver(Picture picture) {
		this.pic = picture;
	}
	// current picture
	public Picture picture() {
		return pic;
	}
	// width of current picture
	public int width() {
		return pic.width();
	}

	// height of current picture
	public int height() {
		return pic.height();
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		if (x == 0 || y == 0 || x == pic.width() - 1 || y == pic.height() - 1) {
			return 1000;
		}
		double red = pic.get(x, y).getRed();
		double green = pic.get(x, y).getGreen();
		double blue = pic.get(x, y).getBlue();

		return pic.get(x, y).getGreen();
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}