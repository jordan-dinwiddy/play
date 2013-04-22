package cx.ath.nb12.pattern;

import java.util.HashSet;
import java.util.Set;

public class BasicMatching {

	public static enum Element {
		STICK,
		COAL,
		IRON;
		
		public String toString() {
			return this.name();
		}
	}
	
	public static class Pattern {
		
		private Element[][] patternArr;
		private String name;
		
		public Pattern() {
			
		}
		
		public Pattern(String name, Element[][] patternArr) {
			this.patternArr = patternArr;
			this.name = name;
		}
		
		public void setPatternArray(Element[][] patternArr) {
			this.patternArr = patternArr;
		}
		
		public Element[][] getPatternArr() {
			return this.patternArr;
		}
		
		public String toString() {
			return "[Pattern: " + name + "]";
		}
	}
	
	Set<Pattern> knownPatterns = new HashSet<Pattern>();
	
	public BasicMatching() {
		initKnownPatterns();
	}
	
	private void initKnownPatterns() {
		
		/**
		 * 
		 * The Grid
		 * 
		 *  -------------------
		 *  | 0,0 | 0,1 | 0,2 |
		 *  -------------------
		 *  | 1,0 | 1,1 | 1,2 |
		 *  -------------------
		 *  | 2,0 | 2,1 | 2,2 |
		 *  -------------------
		 */
		
		/**
		 * 
		 * Torch
		 * 
		 *  -------------
		 *  | C |   |   |
		 *  -------------
		 *  | S |   |   |
		 *  -------------
		 *  |   |   |   |
		 *  -------------
		 */
		Element[][] torchArr = new Element[2][1];
		torchArr[0][0] = Element.COAL;
		torchArr[1][0] = Element.STICK;
		knownPatterns.add(new Pattern("Torch", torchArr));
		
		/**
		 * 
		 * The Bucket
		 * 
		 *  -------------
		 *  | I |   | I |
		 *  -------------
		 *  |   | I |   |
		 *  -------------
		 *  |   |   |   |
		 *  -------------
		 */
		Element[][] bucketArr = new Element[2][3];
		bucketArr[0][0] = Element.IRON;
		bucketArr[1][1] = Element.IRON;
		bucketArr[0][2] = Element.IRON;
		knownPatterns.add(new Pattern("Bucket", bucketArr));
	}
	
	public Pattern gridMatchPattern(Element[][] grid) {
		for(Pattern p : knownPatterns) {
			if(matchPattern(grid, p)) {
				return p;
			}
		}
		
		return null;
	}
	
	private boolean matchPattern(Element[][] grid, Pattern p) {
		
		Element e0 = p.getPatternArr()[0][0];
		
		for(int r = 0; r < grid.length; r++) {
			for(int c = 0; c < grid[0].length; c++) {
				Element gridElement = grid[r][c];
				
				// We've found a potential matching sector
				if(gridElement == e0) {
					if(matchSector(grid, p, r, c)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean matchSector(Element[][] grid, Pattern p, int r, int c) {
		
		Element[][] patternArr = p.getPatternArr();
		int patternRows = patternArr.length;
		int patternCols = patternArr[0].length; 
		
		for(int i = 0; i < patternRows; i++) {
			for(int j = 0; j < patternCols; j++) {
				
				// Map pattern element to grid element for this sector
				int gridRow = i + r;
				int gridCol = j + c;
				
				if(gridRow >= grid.length || gridCol >= grid[0].length) {
					return false;
				}
				
				if(grid[gridRow][gridCol] != patternArr[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		

		BasicMatching bm = new BasicMatching();
		
		/**
		 * 
		 * Torch
		 * 
		 *  -------------
		 *  | C |   |   |
		 *  -------------
		 *  | S |   |   |
		 *  -------------
		 *  |   |   |   |
		 *  -------------
		 */
		Element[][] gridA = new Element[3][3];
		gridA[0][0] = Element.COAL;
		gridA[1][0] = Element.STICK;
		printPatternMatch(gridA, bm);
		
		/**
		 * 
		 * Torch
		 * 
		 *  -------------
		 *  |   |   | C |
		 *  -------------
		 *  |   |   | S |
		 *  -------------
		 *  |   |   |   |
		 *  -------------
		 */
		Element[][] gridB = new Element[3][3];
		gridB[0][2] = Element.COAL;
		gridB[1][2] = Element.STICK;
		printPatternMatch(gridB, bm);
		
		/**
		 * 
		 * Torch
		 * 
		 *  -------------
		 *  |   |   |   |
		 *  -------------
		 *  |   |   | C |
		 *  -------------
		 *  |   |   | S |
		 *  -------------
		 */
		Element[][] gridC = new Element[3][3];
		gridC[1][2] = Element.COAL;
		gridC[2][2] = Element.STICK;
		printPatternMatch(gridC, bm);
		
		/**
		 * 
		 * Bucket
		 * 
		 *  -------------
		 *  | I |   | I |
		 *  -------------
		 *  |   | I |   |
		 *  -------------
		 *  |   |   |   |
		 *  -------------
		 */
		Element[][] gridD = new Element[3][3];
		gridD[0][0] = Element.IRON;
		gridD[1][1] = Element.IRON;
		gridD[0][2] = Element.IRON;
		printPatternMatch(gridD, bm);
		
		/**
		 * 
		 * Not a bucket
		 * 
		 *  -------------
		 *  | I |   | C |
		 *  -------------
		 *  |   | I |   |
		 *  -------------
		 *  |   |   |   |
		 *  -------------
		 */
		Element[][] gridE = new Element[3][3];
		gridE[0][0] = Element.IRON;
		gridE[1][1] = Element.IRON;
		gridE[0][2] = Element.COAL;
		printPatternMatch(gridE, bm);
		
		/**
		 * 
		 * Bucket
		 * 
		 *  -------------
		 *  |   |   |   |
		 *  -------------
		 *  | I |   | I |
		 *  -------------
		 *  |   | I |   |
		 *  -------------
		 */
		Element[][] gridF = new Element[3][3];
		gridF[1][0] = Element.IRON;
		gridF[2][1] = Element.IRON;
		gridF[1][2] = Element.IRON;
		printPatternMatch(gridF, bm);
		
		/**
		 * 
		 * Not a bucket
		 * 
		 *  -------------
		 *  |   |   |   |
		 *  -------------
		 *  | I |   | I |
		 *  -------------
		 *  |   | I | I |
		 *  -------------
		 */
		Element[][] gridG = new Element[3][3];
		gridG[1][0] = Element.IRON;
		gridG[2][1] = Element.IRON;
		gridG[1][2] = Element.IRON;
		gridG[2][2] = Element.IRON;
		printPatternMatch(gridG, bm);
		
		/**
		 * 
		 * Probably shouldn't be a torch
		 * 
		 *  -------------
		 *  | C |   |   |
		 *  -------------
		 *  | S |   |   |
		 *  -------------
		 *  |   |   | S |
		 *  -------------
		 */
		Element[][] gridH = new Element[3][3];
		gridH[0][0] = Element.COAL;
		gridH[1][0] = Element.STICK;
		gridH[2][2] = Element.STICK;				//	<----------------- NEED TO FIX
		printPatternMatch(gridH, bm);
		
		
		// TODO:
		// I'm thinking for the pattern matching, matchSector(grid, pattern, r, c) should
		// normalize the pattern with respect to r,c. 
		// Examples
		
		/**
		 * 
		 *  -----
		 *  | C |
		 *  -----
		 *  | S |
		 *  -----
		 */
		
		/**
		 *
		 * 
		 *  -------------
		 *  | C |   |   |
		 *  -------------
		 *  | S |   |   |
		 *  -------------
		 *  |   |   |   |
		 *  -------------
		 */
		
		/**
		 * 
		 * Torch
		 * 
		 * r = 0, c = 1
		 *  -------------
		 *  |   | C |   |
		 *  -------------
		 *  |   | S |   |
		 *  -------------
		 *  |   |   |   |
		 *  -------------
		 */
		
		/**
		 * 
		 * Torch
		 * 
		 * r = 1, c = 2
		 *  -------------
		 *  |   |   |   |
		 *  -------------
		 *  |   |   | C |
		 *  -------------
		 *  |   |   | S |
		 *  -------------
		 */
		
		// void overlay(grid, pattern, startRow, startCol)
		// Loop over each element in patter, + startRow +startCol, grid[+startRow][+startCol] = x;
		
		
		
	}

	private static void printPatternMatch(Element[][] grid, BasicMatching bm) {
		
		Pattern matchedPattern = bm.gridMatchPattern(grid);
		System.out.println("Grid: " + matchedPattern);
		
	}
}
