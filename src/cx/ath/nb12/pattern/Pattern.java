package cx.ath.nb12.pattern;

/**
 * An immutable pattern.
 *
 */
public final class Pattern {

	private final String name;
	private final int width;
	private final int height;
	private final BasicElement[][] patternContents;
	
	public static Pattern TORCH;
	public static Pattern BUCKET;
	
	
	static {
		// Create torch pattern
		TORCH = newEmptyPattern("Torch", 1, 2);
		TORCH.setElementAt(0, 0, BasicElement.COAL);
		TORCH.setElementAt(1, 0, BasicElement.STICK);
		
		// Create bucket pattern
		BUCKET = newEmptyPattern("Bucket", 3, 2);
		BUCKET.setElementAt(0, 0, BasicElement.IRON);
		BUCKET.setElementAt(1, 1, BasicElement.IRON);
		BUCKET.setElementAt(0, 2, BasicElement.IRON);
	}
	
	private Pattern(String name, int width, int height) {
		
		if(width < 1 || height < 1) {
			throw new IllegalArgumentException("Pattern must have width/height >= 1");
		}
		
		if(name == null || name.trim().length() < 1) {
			throw new IllegalArgumentException("Pattern name cannot be null/empty string");
		}
		
		this.name = name;
		this.width = width;
		this.height = height;
		this.patternContents = new BasicElement[height][width];
	}
	
	public static Pattern newEmptyPattern(String name, int width, int height) {
		return new Pattern(name, width, height);
	}
	
	public String getName() {
		return name;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	private void setElementAt(int row, int col, BasicElement element) {
		this.patternContents[row][col] = element;
	}
	
	public BasicElement getElementAt(int row, int col) {
		
		rangeCheck(row, col);
		
		return this.patternContents[row][col];
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
