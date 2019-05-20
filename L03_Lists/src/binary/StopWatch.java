package binary;

public class StopWatch {
	private long elapsedTime;
	private long startTime;
	private boolean isRunning;

	public StopWatch() {
		reset();
	}

	public void start() {
		if (isRunning) {
			return;
		}
		isRunning = true;
		startTime = System.currentTimeMillis();
	}

	public void stop() {
		if (!isRunning) {
			return;
		}
		long endTime = System.currentTimeMillis();
		isRunning = false;
		elapsedTime = elapsedTime + endTime - startTime;
	}

	

	public long getElapsedTime() {
		if (isRunning) {
			long endTime = System.currentTimeMillis();
			return elapsedTime + endTime - startTime;
		} else {
			return elapsedTime;
		}
	}

	public void reset() {
		elapsedTime = 0;
		isRunning = false;
	}
}