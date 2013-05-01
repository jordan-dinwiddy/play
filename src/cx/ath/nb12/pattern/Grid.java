package cx.ath.nb12.pattern;

public class Grid {

	private int width;
	private int height;
	private BasicElement[][] gridContents;

	public Grid(int width, int height) {

		if(width < 1 || height < 1) {
			throw new IllegalArgumentException("Grid must have width/height >= 1");
		}

		this.width = width; 
		this.height = height; 

		gridContents = new BasicElement[height][width];
	}

	public BasicElement getElementAt(int row, int col) {

		rangeCheck(row, col);

		return gridContents[row][col];
	}

	public void setElementAt(int row, int col, BasicElement element) {

		rangeCheck(row, col);

		gridContents[row][col] = element;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	private void rangeCheck(int row, int col) {

		if(row < 0 || row > (height - 1)) {
			throw new IllegalArgumentException("Row must be in the range 0 - " + (height - 1));
		}

		if(col < 0 || col > (width - 1)) {
			throw new IllegalArgumentException("Col must be in the range 0 - " + (width - 1));
		}
	}
}
