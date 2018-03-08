import java.util.Arrays;

/*
 * @author Vilvesh Srinivasan
 * Task is to write the SortingThread class so it works in combination with the code in lab10.zip. 
 * SortingThread should implement the Runnable interface so that when SortingThreadTest is ran
 */
public class SortingThread implements Runnable{

	private int[] aV;
	private SortingBuffer b;
	private int tNum;
	
	public SortingThread(int p, int[] a, SortingBuffer b){
		aV = a;
		this.b = b;
		tNum = p;
	}
	/*
	 * This method will print unsynchronized values out first 
	 * then the method will print the synchronized values of threads.
	 */
	public void run(){
			Arrays.sort(aV);
			for(int g : aV){
				System.out.printf("%d unsynchronized %d", tNum, g);
				System.out.println();
			}
			try{
				for(int q : aV){
					b.waitUntilMinimum(tNum,q);
					System.out.printf("%d synchronized %d", tNum, q);
					System.out.println();
				}
				b.finished(tNum);
			}catch (InterruptedException e) {
					System.err.println(e);
				}

			}
	
}
