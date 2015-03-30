// UVa 120 Stacks of Flapjacks
// Current Status: Accepted|Pending|TooSlow
// Last Submitted: 2015-03-23
// Run Time: 0.775

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private String[] numStrs;
	private int[] index2rank;
	private int[] rank2index;
	private int arranged;
	
	private void flip(int flipNum){						
		System.out.print((flipNum)+" ");
		int swapHead = 0;
		int swapTail = numStrs.length-flipNum;
		for(int i=0;i<=(swapHead+swapTail)/2;i++)
		{
			int temp = index2rank[swapHead+i];
			index2rank[swapHead+i] = index2rank[swapTail-i];
			index2rank[swapTail-i] = temp;
			rank2index[index2rank[swapHead+i]] = swapHead+i;
			rank2index[temp] = swapTail-i;
		}
	}
	
	private void arrange(int rank){						
		if(rank2index[rank]!=rank)
		{
			if(index2rank[0]!=rank)
				flip(numStrs.length-(rank2index[rank]));
			if(rank2index[rank]!=rank)
				flip(arranged+1);
		}
		arranged++;
	}
	
	private void run(){
		Scanner s = new Scanner(System.in);
		while(s.hasNextLine())
		{
			String line = s.nextLine();
			numStrs = line.split("\\s");
			index2rank = new int[numStrs.length];
			rank2index = new int[numStrs.length];
			arranged = 0;
			List<Integer> nums = new ArrayList<Integer>();
			for(String nextNum : numStrs)
			{
				nums.add(Integer.parseInt(nextNum));
			}
			Collections.sort(nums);
			for(int i=0;i<nums.size();i++)
			{
				index2rank[i] = nums.indexOf(Integer.parseInt(numStrs[i]));
				rank2index[nums.indexOf(Integer.parseInt(numStrs[i]))] = i;  
			}
			for(int i=0;i<nums.size();i++)
			{
				if(i!=0)
					System.out.print(" ");
				System.out.print(numStrs[i]);				
			}
			System.out.println();
			for(int i=nums.size()-1;i>=0;i--)
			{
				arrange(i);		
			}
			System.out.println(0);
		}
		s.close();
	}
	
	public static void main(String[] args) {
		Main thisMain = new Main();
		thisMain.run();
	}
	
}
