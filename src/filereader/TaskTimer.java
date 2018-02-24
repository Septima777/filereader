package filereader;

/**
 * This class will compute and print the elapsed time for any task
 * @author Noppawan Kulchol
 *
 */
public class TaskTimer {
	
	/**
	 * measure the time and print description of any tasks.
	 * @param task
	 */
	public void measureAndPrint(Runnable task){
		Stopwatch timer = new Stopwatch();
		timer.start();
		task.run();
		timer.stop();
		System.out.print(task.toString());
		System.out.printf(" in %.6f sec.\n", timer.getElapsed());
	}
	

}
