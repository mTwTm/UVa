// UVa 102 Ecological Bin Packing 
// Current Status: Ready
// Last Submitted: 2015-03-27
// Run Time: 
// Concept: Permutation is O(n!) but is worth a try with n = 3
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[][] bin;
		int[] sum;
		int sumAll;		
		while(s.hasNextInt())
		{
			sumAll = 0;
			bin = new int[3][];
			sum = new int[3];
			for(int i=0;i<3;i++)
				bin[i] = new int[3];
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{										
					bin[i][j] = s.nextInt();					
					sum[i] += bin[i][j];
					sumAll += bin[i][j];
				}
			} 
			String comb = "BCG";
			String ans = null;
			int ansNum = sumAll;
			while(comb!=null)
			{
				int sumThis = sumAll - bin[comb.indexOf('B')][0] - bin[comb.indexOf('C')][2] - bin[comb.indexOf('G')][1];
				if(sumThis<ansNum)
				{
					ans = comb;
					ansNum = sumThis;
				}
				comb = nextPerm(comb);
			}
			System.out.println(ans+" "+ansNum);
		}
		s.close();
	}
	
	private static String nextPerm(String s)
	{
		StringBuilder sb = new StringBuilder(s);
		int last = s.length()-1;
		int firstSmallerThanLast = -1;
		//find where the permutation are done, i.e. the smallest which firstSmallerThanLast..last is not sorted
		for(int i = s.length()-2; i>=0; i--)
		{
			if(s.charAt(i)<s.charAt(i+1))
			{
				firstSmallerThanLast = i;
				break;
			}
		}
		if(firstSmallerThanLast==-1)
			return null;
		//find the nextGreater than firstSmallerThanLast to swap
		int nextGreater = firstSmallerThanLast+1;
		for(int i = s.length()-1; i>=0; i--)
		{
			if(s.charAt(i)>s.charAt(firstSmallerThanLast))
			{
				nextGreater = i;
				break;
			}
		}
		char temp;
		temp = s.charAt(nextGreater);
		sb.setCharAt(nextGreater, s.charAt(firstSmallerThanLast));
		sb.setCharAt(firstSmallerThanLast, temp);
		//reverse sorted Max to Min
		int swapStart = firstSmallerThanLast+1;
		int swapEnd = last;
		for(int i=0;i<(swapEnd-(swapStart)+1)/2;i++) //Do at most (k-j+1)/2 swaps
		{
			temp = sb.charAt(swapStart+i);
			sb.setCharAt(swapStart+i, sb.charAt(swapEnd-i));
			sb.setCharAt(swapEnd-i, temp);
		}
		return sb.toString();
	}
	
}
