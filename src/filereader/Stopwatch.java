package filereader;

/**
 * This class uses for compute the time.
 * @author Noppawan Kulchol
 *
 */
public class Stopwatch {
	private long startTime;
	private long endTime;
	private boolean running;
	private static final double NANOSECOND = 1.0E-9;

	/**
	 * Initialize running to be false.
	 */
	public Stopwatch() {
		running = false;
	}

	/**
	 * start the time.
	 */
	public void start() {
		if (running) return;
		else{
			startTime = System.nanoTime();
			running = true;
		}
	}

	/**
	 * stop the time.
	 */
	public void stop() {
		if (!running) return;
		else{
			endTime = System.nanoTime();
			running = false;
		}
	}

	/**
	 * check status of running.
	 * @return
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * return the time of tasking.
	 * @return the time of tasking.
	 */
	public double getElapsed() {
		if (running)
			return (System.nanoTime() - startTime) * NANOSECOND;
		else
			return (endTime - startTime) * NANOSECOND;
	}
}
