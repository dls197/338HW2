
public class Clock extends Algorithm {
	
	//Records the clock/second chance of corresponding pages
	int[] clock;
	
	public int[] getClock() {
		return clock;
	}

	public void setClock(int[] clock) {
		this.clock = clock;
	}

	//Constructor determines the number of page frames
	public Clock(int frameNum) {
		this.frameNum = frameNum;
		this.pageFrame = new String[frameNum];
		this.clock = new int[frameNum];
		
		//Fills the clock array with default value 0
		for(int i = 0; i < frameNum; i++) {
			clock[i] = 0;
		}
	}

	public void printClock(){
		System.out.print("The current page frames look like: ");
		for(int i = 0; i < getFrameNum(); i++) {
			System.out.print(getPageFrame()[i] + " ");
		}
		System.out.print(" {");
		for (int i = 0; i < getClock().length; i++){
			System.out.print(getClock()[i]);
		}
		System.out.print("}");
		System.out.println();
	}

	
	//Determines whether a page fault occurs
	public boolean hasPageFault(String page) {
		//If the page frames contains page identical with the input page, no page fault occurs
		for (int i = 0; i < getFrameNum(); i++) {
			if (getPageFrame()[i] == null) {
				return true;
			}
			if(getPageFrame()[i].equals(page)) {
				//Updates the clock when the page matches
				getClock()[i] = 1;
				return false;
			}	
		}
		//If the page frames does not contain identical page, page fault occurs
		return true;	
	}
	
	/*If the clock array is full of 1's
	public boolean allOnes() {
		
		//Iterates through the array. If find a single 0, return false
		for (int i = 0; i < getClock().length; i++) {
			if (getClock()[i] == 0)
				return false;
		}
		
		//If no 0's are find, return true
		return true;
	}
	 */

	//Iterates the pointer of the page frames
	public void pointerIterate() {	
		//If the clock array is all 1's, pointer remains the same
		//if(allOnes()) {
		//	return;
		//}
			
		//If the pointer is at the end of array, iterate to the front
		if (getPointer() == getFrameNum() - 1) {
			setPointer(0);
		}
		
		else {
			//If the pointer is not at the end of array, move the pointer back by one
			setPointer(getPointer() + 1);
		}	
	}
	
	//Iterate pointer till it finds the next zero
	public void findNextZero() {
		//Keeps iterate the pointer until reaches to a slot with 0 as clock
		while(getClock()[getPointer()] == 1){
			//Those that gets skipped reset the clock
			getClock()[getPointer()] = 0;
			
			//If the pointer is at the end of array, iterate to the front
			if (getPointer() == getFrameNum() - 1) {
				setPointer(0);
			}
			
			else {
				//If the pointer is not at the end of array, move the pointer back by one
				setPointer(getPointer() + 1);
			}		
		}		
	}
	//Adding a page
		public String[] addPage(String page) {
			//If no page fault occurs, just return the current page frames
			if (!hasPageFault(page))
				return getPageFrame();
			
			//If the pointer is pointing to a page with a clock = 1
			else if(/*!allOnes() &&*/ getClock()[getPointer()] == 1) {
				
				//Iterates till reaches 0
				findNextZero();
				
				//Adds the page 
				getPageFrame()[getPointer()] = page;
				
				//Iterates the pointer
				pointerIterate();
				
				//Increment number of page fault
				setNumFault(getNumFault() + 1);
				
				return getPageFrame();
			}
			
			else {
				//Adds the page 
				getPageFrame()[getPointer()] = page;
				
				//Iterates the pointer
				pointerIterate();
				
				//Increment number of page fault
				setNumFault(getNumFault() + 1);
				
				return getPageFrame();
			}
		}
}
