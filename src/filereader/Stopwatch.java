package filereader;

public class Stopwatch {
	private long startTime;
	private long endTime;
	private boolean running;
	private static final double NANOSECOND = 1.0E-9;

	public Stopwatch() {
		running = false;
	}

	public void start() {
		if (running) return;
		else{
			startTime = System.nanoTime();
			running = true;
		}
	}

	public void stop() {
		if (!running) return;
		else{
			endTime = System.nanoTime();
			running = false;
		}
	}

	public boolean isRunning() {
		return running;
	}

	public double getElapsed() {
		if (running)
			return (System.nanoTime() - startTime) * NANOSECOND;
		else
			return (endTime - startTime) * NANOSECOND;
	}
}
