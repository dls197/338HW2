
import java.util.Scanner;
import java.lang.Math;

public class Algorithm {
	static public String input = "n";
	static public int length = 20;

	
	//Number of Page Frames
	protected int frameNum;
	
	//The Page Frame
	protected String[] pageFrame;

	//The Page Reference
	protected static String[] pageRef;
	
	//Number of Page Faults
	protected int numFault = 0;
	
	//Pointer for Page Frames
	protected int pointer = 0;
	

	public int getFrameNum() {
		return frameNum;
	}

	public void setFrameNum(int frameNum) {
		this.frameNum = frameNum;
	}

	public String[] getPageFrame() {
		return pageFrame;
	}

	public void setPageFrame(String[] pageFrame) {
		this.pageFrame = pageFrame;
	}

	public int getNumFault() {
		return numFault;
	}

	public void setNumFault(int numFault) {
		this.numFault = numFault;
	}

	public int getPointer() {
		return pointer;
	}

	public void setPointer(int pointer) {
		this.pointer = pointer;
	}
	
	//Prints out the current page frame's content
	public void printFrame() {
		System.out.print("The current page frames look like: ");
		
		for(int i = 0; i < getFrameNum(); i++) {
			System.out.print(getPageFrame()[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many pages? ");
		input = scan.nextLine();
		try {
			length = Integer.valueOf(input);
		} catch (NumberFormatException e) {
			System.out.println("So 20?");
		}
		pageRef = new String[length];


		System.out.println("The reference for equiprobable requests is: ");
		for (int i = 0; i < length; i++) {
			pageRef[i] = Integer.toString(RandomGenerator.uniformRandom(length));
			System.out.print(pageRef[i] + " ");
		}
		System.out.println("\n\nFIFO algorithm:");
		FIFO fifo1 = new FIFO(3);
		long fifo1st = System.nanoTime();
		for (int i = 0; i < length; i++) {
			fifo1.addPage(pageRef[i]);
			fifo1.printFrame();
		}
		long fifo1et = System.nanoTime();
		System.out.println("Number of Page Fault Occurs: " + fifo1.getNumFault());
		System.out.println("Runtime is " + (fifo1et - fifo1st) + " nanoseconds");

		System.out.println("\nCLOCK algorithm:");
		Clock clock1 = new Clock(3);
		long clock1st = System.nanoTime();
		for (int i = 0; i < length; i++) {
			clock1.addPage(pageRef[i]);
			clock1.printClock();
		}
		long clock1et = System.nanoTime();
		System.out.println("Number of Page Fault Occurs: " + clock1.getNumFault());
		System.out.println("Runtime is " + (clock1et - clock1st) + " nanoseconds");


		System.out.println("\nThe reference for an exponential distribution is: ");
		for (int i = 0; i < length; i++) {
			pageRef[i] = Integer.toString(RandomGenerator.expRandom(length));
			System.out.print(pageRef[i] + " ");
		}
		System.out.println("\n\nFIFO algorithm:");
		FIFO fifo2 = new FIFO(3);
		long fifo2st = System.nanoTime();
		for (int i = 0; i < length; i++) {
			fifo2.addPage(pageRef[i]);
			fifo2.printFrame();
		}
		long fifo2et = System.nanoTime();
		System.out.println("Number of Page Fault Occurs: " + fifo2.getNumFault());
		System.out.println("Runtime is " + (fifo2et - fifo2st) + " nanoseconds");

		System.out.println("\nCLOCK algorithm:");
		Clock clock2 = new Clock(3);
		long clock2st = System.nanoTime();
		for (int i = 0; i < length; i++) {
			clock2.addPage(pageRef[i]);
			clock2.printClock();
		}
		long clock2et = System.nanoTime();
		System.out.println("Number of Page Fault Occurs: " + clock2.getNumFault());
		System.out.println("Runtime is " + (clock2et - clock2st) + " nanoseconds");


		System.out.println("\nThe reference for a strongly biased probability to request any of 3<k<10 is: ");
		for (int i = 0; i < length; i++) {
			pageRef[i] = Integer.toString(RandomGenerator.myRandom(length));
			System.out.print(pageRef[i] + " ");
		}
		System.out.println("\n\nFIFO algorithm:");
		FIFO fifo3 = new FIFO(3);
		long fifo3st = System.nanoTime();
		for (int i = 0; i < length; i++) {
			fifo3.addPage(pageRef[i]);
			fifo3.printFrame();
		}
		long fifo3et = System.nanoTime();
		System.out.println("Number of Page Fault Occurs: " + fifo3.getNumFault());
		System.out.println("Runtime is " + (fifo3et - fifo3st) + " nanoseconds");

		System.out.println("\nCLOCK algorithm:");
		Clock clock3 = new Clock(3);
		long clock3st = System.nanoTime();
		for (int i = 0; i < length; i++) {
			clock3.addPage(pageRef[i]);
			clock3.printClock();
		}
		long clock3et = System.nanoTime();
		System.out.println("Number of Page Fault Occurs: " + clock3.getNumFault());
		System.out.println("Runtime is " + (clock3et - clock3st) + " nanoseconds");

		System.out.println("\nResult comparisons:");
		System.out.println("\nequiprobable clock and equiprobable fifo faults: " + clock1.getNumFault()/fifo1.getNumFault());
		System.out.println("equiprobable clock and equiprobable fifo runtime: " + (clock1et - clock1st)/(fifo1et - fifo1st));
		System.out.println("e\nxponential clock and exponential fifo faults: "+ clock2.getNumFault()/fifo2.getNumFault());
		System.out.println("exponential clock and exponential fifo runtime: " + (clock2et - clock2st)/(fifo2et - fifo2st));
		System.out.println("\nbiased clock and biased fifo faults: " + clock3.getNumFault()/fifo3.getNumFault());
		System.out.println("biased clock and biased fifo runtime: " + (clock3et - clock3st)/(fifo3et - fifo3st));

		System.out.println("\nbiased clock and exponential clock faults: " + clock3.getNumFault()/clock2.getNumFault());
		System.out.println("exponential clock and equiprobable clock faults: " + clock2.getNumFault()/clock1.getNumFault());
		System.out.println("biased clock and equiprobable clock faults: " + clock3.getNumFault()/clock1.getNumFault());

		System.out.println("\nbiased fifo and exponential fifo faults: " + fifo3.getNumFault()/fifo2.getNumFault());
		System.out.println("exponential fifo and equiprobable fifo faults: " + fifo2.getNumFault()/fifo1.getNumFault());
		System.out.println("biased fifo and equiprobable fifo faults: " + fifo3.getNumFault()/fifo1.getNumFault());

		System.out.println("\nbiased clock and exponential clock runtime: " + (clock3et - clock3st)/(clock2et - clock2st));
		System.out.println("exponential clock and equiprobable clock runtime: " + (clock2et - clock2st)/(clock1et - clock1st));
		System.out.println("biased clock and equiprobable clock runtime: " + (clock3et - clock3st)/(clock1et - clock1st));

		System.out.println("\nbiased fifo and exponential fifo runtime: " + (fifo3et - fifo3st)/(fifo2et - fifo2st));
		System.out.println("exponential fifo and equiprobable fifo runtime: " + (fifo2et - fifo2st)/(fifo1et - fifo1st));
		System.out.println("biased fifo and equiprobable fifo runtime: " + (fifo3et - fifo3st)/(fifo1et - fifo1st));
	}
}
