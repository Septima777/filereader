package filereader;

public class Main {
	public static void main(String[] args) {
		TaskTimer taskTimer = new TaskTimer();
		String fileName = "C:/Users/Septima/workspace/filereader/src/Alice-in-Wonderland.txt";
		taskTimer.measureAndPrint(new AppendStringTask(fileName));
		taskTimer.measureAndPrint(new AppendStringBuilderTask(fileName));
		taskTimer.measureAndPrint(new AppendStringBufferedReaderTask(fileName));
		
	}
}
