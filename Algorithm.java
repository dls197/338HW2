
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
		for (int i = 0; i < length; i++) {
			fifo1.addPage(pageRef[i]);
			fifo1.printFrame();
		}
		System.out.println("Number of Page Fault Occurs: " + fifo1.getNumFault());
		System.out.println("\nCLOCK algorithm:");
		Clock clock1 = new Clock(3);
		for (int i = 0; i < length; i++) {
			clock1.addPage(pageRef[i]);
			clock1.printClock();
		}
		System.out.println("Number of Page Fault Occurs: " + clock1.getNumFault());
		System.out.println("\n");

		System.out.println("The reference for an exponential distribution is: ");
		for (int i = 0; i < length; i++) {
			pageRef[i] = Integer.toString(RandomGenerator.expRandom(length));
			System.out.print(pageRef[i] + " ");
		}
		System.out.println("\n\nFIFO algorithm:");
		FIFO fifo2 = new FIFO(3);
		for (int i = 0; i < length; i++) {
			fifo2.addPage(pageRef[i]);
			fifo2.printFrame();
		}
		System.out.println("Number of Page Fault Occurs: " + fifo2.getNumFault());
		System.out.println("\nCLOCK algorithm:");
		Clock clock2 = new Clock(3);
		for (int i = 0; i < length; i++) {
			clock2.addPage(pageRef[i]);
			clock2.printClock();
		}
		System.out.println("Number of Page Fault Occurs: " + clock2.getNumFault());
		System.out.println("\n");

		System.out.println("The reference for a strongly biased probability to request any of 3<k<10 is: ");
		for (int i = 0; i < length; i++) {
			pageRef[i] = Integer.toString(RandomGenerator.myRandom(length));
			System.out.print(pageRef[i] + " ");
		}
		System.out.println("\n\nFIFO algorithm:");
		FIFO fifo3 = new FIFO(3);
		for (int i = 0; i < length; i++) {
			fifo3.addPage(pageRef[i]);
			fifo3.printFrame();
		}
		System.out.println("Number of Page Fault Occurs: " + fifo3.getNumFault());
		System.out.println("\nCLOCK algorithm:");
		Clock clock3 = new Clock(3);
		for (int i = 0; i < length; i++) {
			clock3.addPage(pageRef[i]);
			clock3.printClock();
		}
		System.out.println("Number of Page Fault Occurs: " + clock3.getNumFault());
		System.out.println("\n");

	}
}
