// UVa 100 The 3n + 1 problem
// Current Status: Pending
// Last Submitted: NOTYET
// Run Time: NOTYET
import java.util.Scanner;

public class Main {
	
	private static int calLength(int target)
	{
		int count = 1;
		while(target!=1)
		{
			count++;
			if(target%2==1)
				target = 3 * target +1;
			else
				target = target / 2;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNextInt())
		{
			int i = s.nextInt();
			int j = s.nextInt();
			int maxCycle = 0;
			for(int c = i ; c<=j ; c++)
			{
				int result = calLength(c);
				if(result>maxCycle)
					maxCycle = result;
			}
			System.out.println(i+" "+j+" "+maxCycle);
		}
		s.close();
	}
	
}
