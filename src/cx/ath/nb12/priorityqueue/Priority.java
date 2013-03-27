package cx.ath.nb12.priorityqueue;

public enum Priority {
	LOW(0),
	MEDIUM(1),
	HIGH(2);

	public int nValue;

	private Priority(int nValue) {
		this.nValue = nValue;
	}

	public int getNValue() {
		return nValue;
	}
}
