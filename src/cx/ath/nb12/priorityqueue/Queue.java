package cx.ath.nb12.priorityqueue;

public interface Queue<T> {

	void enqueue(T item);
	
	T dequeue();
}
