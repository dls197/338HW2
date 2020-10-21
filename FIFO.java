
public class FIFO extends Algorithm {
	
	//Constructor determines the number of page frames
	public FIFO(int frameNum) {
		this.frameNum = frameNum;
		this.pageFrame = new String[frameNum];
	}
	
	//Determines whether a page fault occurs
	public boolean hasPageFault(String page) {
		//If the page frames contains page identical with the input page, no page fault occurs
		for (int i = 0; i < getFrameNum(); i++) {
			if (getPageFrame()[i] == null){
				return true;
			}
			if(getPageFrame()[i].equals(page)) {
				return false;
			}
		}
		
		//If the page frames does not contain identical page, page fault occurs
		return true;	
	}
	
	//Iterates the pointer of the page frames
	public void pointerIterate() {
		//If the pointer is at the end of array, iterate to the front
		if (getPointer() == getFrameNum() - 1) {
			setPointer(0);
		}
		
		//If the pointer is not at the end of the array, iterate to the next slot
		else {
			setPointer(getPointer() + 1);
		}
	}
	
	//Adding a page
	public String[] addPage(String page) {
		//If no page fault occurs, just return the current page frames
		if (!hasPageFault(page))
			return getPageFrame();
		
		else {
			//Adds the page to the pointer's slot
			getPageFrame()[getPointer()] = page;
			
			//Iterates the pointer
			pointerIterate();
			
			//Increment number of page fault
			setNumFault(getNumFault() + 1);
			
			return getPageFrame();
		}
	}
	
	
}
