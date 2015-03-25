// UVa 101 The Blocks Problem
// Current Status: Wrong Answer
// Last Submitted: 2015-03-25 08:03:18
// Run Time: 0.955
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	private List<List<Integer>> blockStacks;
	private int[] box2stacklookup;		
	
	private List<Integer> pile(int from, boolean pile)
	{
		List<Integer> removed = new ArrayList<Integer>();
		List<Integer> fromStack = blockStacks.get(box2stacklookup[from]);
		ListIterator<Integer> it = fromStack.listIterator();		
		while(it.hasNext())
		{
			if(it.next()==from)
				break;
		}
		removed.add(from);
		it.remove();
		if(pile)
		{
			while(it.hasNext())
			{
				removed.add(it.next());
				it.remove();
			}		
		}
		return removed;
	}
	
	private void over(List<Integer> insert, int to, boolean over)
	{
		List<Integer> toStack = blockStacks.get(box2stacklookup[to]);		
		ListIterator<Integer> it = toStack.listIterator(toStack.size());
		if(!over)
		{
			while(it.hasPrevious())
			{
				if(it.previous()==to)
				{
					it.next();
					break;
				}
			}
		}
		for(int insertElement : insert)
		{
			it.add(insertElement);
			box2stacklookup[insertElement] = box2stacklookup[to];
		}
	}
	
	private void moveOnto(int from, int to){
		over(pile(from, false), to, false);		
	}
	
	private void moveOver(int from, int to){
		over(pile(from, false), to, true);
	}

	private void pileOnto(int from, int to){
		over(pile(from, true), to, false);
	}
	
	private void pileOver(int from, int to){
		over(pile(from, true), to, true);
	}
	
	private void printStacks()
	{
		for(int i=0; i<blockStacks.size() ;i++)
		{
			System.out.print(i+":");
			printStack(blockStacks.get(i));
			if(i!=blockStacks.size()-1)
				System.out.println();
		}
	}
	
	private void printStack(List<Integer> list)
	{
		Iterator<Integer> i = list.iterator();
		while(i.hasNext())
		{
				System.out.print(" ");
			System.out.print(i.next());			
		}
	}
	
	private void run()
	{
		Scanner s = new Scanner(System.in);
		int blockCount = Integer.parseInt(s.nextLine());		
		blockStacks = new ArrayList<List<Integer>>();
		box2stacklookup = new int[blockCount];
		for(int i=0;i<blockCount;i++)
		{
			LinkedList<Integer> next = new LinkedList<Integer>();
			next.add(i);
			blockStacks.add(next);
			box2stacklookup[i] = i;
		}
		while(s.hasNextLine())
		{			
			String nextCmd = s.nextLine();
			if(nextCmd.equals("quit"))
				break;
			String[] nextCmdSplit = nextCmd.split("\\s");
			if(box2stacklookup[Integer.parseInt(nextCmdSplit[1])]==box2stacklookup[Integer.parseInt(nextCmdSplit[3])])
				continue;
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
		}		
		printStacks();
		s.close();		
	}
	
	public static void main(String[] args) {
		Main instance = new Main();
		instance.run();		
	}
	
}
