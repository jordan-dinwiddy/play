package cx.ath.nb12.hex;

/**
 * Implements with the if-else
 * @author jo
 *
 */
public class HexDigitImpl1 implements HexadecimalDigit {

	private char digit;
	
	@Override
	public int getDecimalValue() {
		if( digit == '0' )
			return 0;
		else if( digit == '1' )
			return 1;
		else if( digit == '2' )
			return 2;
		else if( digit == '3' )
			return 3;
		else if( digit == '4' )
			return 4;
		else if( digit == '5' )
			return 5;
		else if( digit == '6' )
			return 6;
		else if( digit == '7' )
			return 7;
		else if( digit == '8' )
			return 8;
		else if( digit == '9' )
			return 9;
		else if( digit == 'a' )
			return 10;
		else if( digit == 'b' )
			return 11;
		else if( digit == 'c' )
			return 12;
		else if( digit == 'd' )
			return 13;
		else if( digit == 'e' )
			return 14;
		else 
			return 15;
	}

	@Override
	public void setDigit(char digit) {
		this.digit = digit;
		
	}

}
