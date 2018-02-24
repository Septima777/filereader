package filereader;

public class TaskTimer {
	
	public void measureAndPrint(Runnable task){
		Stopwatch timer = new Stopwatch();
		timer.start();
		task.run();
		timer.stop();
		System.out.print(task.toString());
		System.out.printf(" in %.6f sec.\n", timer.getElapsed());
	}
	

}
