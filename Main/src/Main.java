// UVa 101 The Blocks Problem
// Current Status: Accepted|Pending|TooSlow
// Last Submitted: 2015-03-23
// Run Time: 0.775
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private List<LinkedListNode> blockStacks;
	private int[] lookupWhichStack;
	
	
	private class LinkedListNode
	{
		public LinkedListNode(int value)
		{
			this.value = value;
		}
		public int value;
		public LinkedListNode next;
	}
	
	private void moveOnto(int from, int to){
		
	}
	
	private void moveOver(int from, int to){
		
	}

	private void pileOnto(int from, int to){
	
	}
	
	private void pileOver(int from, int to){
		
	}
	
	private void printStacks()
	{
		for(int i=0; i<blockStacks.size() ;i++)
		{
			System.out.print(i+": ");
			printStack(blockStacks.get(i));
			System.out.println();
		}
	}
	
	private void printStack(LinkedListNode thisE)
	{
		if(thisE == null)
			return;
		else
		{
			LinkedListNode nextE = thisE.next;
			System.out.print(thisE.value);
			if(nextE!=null)
			{
				System.out.print(" ");
				printStack(nextE);				
			}			
		}
	}
	
	private void run()
	{
		Scanner s = new Scanner(System.in);
		int blockCount = Integer.parseInt(s.nextLine());
		blockStacks = new ArrayList<LinkedListNode>();
		lookupWhichStack = new int[blockCount];
		for(int i=0;i<blockCount;i++)
		{
			lookupWhichStack[i] = i;
			blockStacks.add(new LinkedListNode(i));
		}
		while(s.hasNextLine())
		{			
			String nextCmd = s.nextLine();
			String[] nextCmdSplit = nextCmd.split("\\s");
			switch(nextCmdSplit[0])
			{
				case "move":
					switch(nextCmdSplit[2])
					{
						case "onto":
							moveOnto(Integer.parseInt(nextCmdSplit[1]), Integer.parseInt(nextCmdSplit[3]));
							break;
						case "over":
							moveOver(Integer.parseInt(nextCmdSplit[1]), Integer.parseInt(nextCmdSplit[3]));
							break;
					}
					break;
				case "pile":
					switch(nextCmdSplit[2])
					{
						case "onto":
							pileOnto(Integer.parseInt(nextCmdSplit[1]), Integer.parseInt(nextCmdSplit[3]));
							break;
						case "over":
							pileOver(Integer.parseInt(nextCmdSplit[1]), Integer.parseInt(nextCmdSplit[3]));
							break;
					}
					break;
			}
			printStacks();
		}
		//printStacks();
		s.close();
	}
	
	public static void main(String[] args) {
		Main instance = new Main();
		instance.run();		
	}
	
}
