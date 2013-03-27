package cx.ath.nb12;

public interface MyQueue<T> {

	void enqueue(T item);
	
	T dequeue();
}
