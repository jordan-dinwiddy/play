package cx.ath.nb12.stack;

public interface Stack {

	void push(String s) throws Exception;

	String pop() throws Exception;

	int getSize();

}