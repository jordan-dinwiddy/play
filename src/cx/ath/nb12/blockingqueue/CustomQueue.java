package cx.ath.nb12.blockingqueue;

public interface CustomQueue<T> {

	void enqueue(T item);
	
	T dequeue();
}
