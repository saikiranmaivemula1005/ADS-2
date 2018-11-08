
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
		double redtop = pic.get(x - 1, y).getRed();
		double greentop = pic.get(x - 1, y).getGreen();
		double bluetop = pic.get(x - 1, y).getBlue();
		double redbottom = pic.get(x + 1, y).getRed();
		double greenbottom = pic.get(x + 1, y).getGreen();
		double bluebottom = pic.get(x + 1, y).getBlue();
		double deltax = Math.pow(redtop - redbottom, 2)
		+ Math.pow(greentop - greenbottom, 2) + Math.pow(bluetop - bluebottom, 2);
		double redright = pic.get(x, y + 1).getRed();
		double greenright = pic.get(x, y + 1).getGreen();
		double blueright = pic.get(x, y + 1).getBlue();
		double redleft = pic.get(x, y - 1).getRed();
		double greenleft = pic.get(x, y - 1).getGreen();
		double blueleft = pic.get(x, y - 1).getBlue();
		double deltay = Math.pow(redright - redleft, 2)
		+ Math.pow(greenright - greenleft, 2) + Math.pow(blueright - blueleft, 2);
		double sum = Math.sqrt(deltax + deltay);
		return sum;
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