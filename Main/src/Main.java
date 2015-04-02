// UVa 253 Cube painting 
// Current Status: Accepted
// Last Submitted: 2015-04-02 07:27:21
// Run Time: 0.206

import java.util.Scanner;

public class Main {

	private StringBuilder one;
	private String two;
	
	private void xrotate() //2->1->5->6->2
	{
		char temp = one.charAt(1);
		one.setCharAt(1, one.charAt(0));
		one.setCharAt(0, one.charAt(4));
		one.setCharAt(4, one.charAt(5));
		one.setCharAt(5, temp);
	}
	
	private void yrotate() //2->3->5->4->2
	{
		char temp = one.charAt(1);
		one.setCharAt(1, one.charAt(2));
		one.setCharAt(2, one.charAt(4));
		one.setCharAt(4, one.charAt(3));
		one.setCharAt(3, temp);
	}
	
	private void zrotate() //1->3->6->4->1
	{
		char temp = one.charAt(0);
		one.setCharAt(0, one.charAt(2));
		one.setCharAt(2, one.charAt(5));
		one.setCharAt(5, one.charAt(3));
		one.setCharAt(3, temp);
	}
	
	private void run(){
		Scanner s = new Scanner(System.in);
		while(s.hasNextLine())
		{
			String line = s.nextLine();
			one = new StringBuilder(line.substring(0, 6));
			two = line.substring(6, 12);
		boolean same = false;
		test:
			for(int i=0;i<6;i++)
			{				
				for(int j=0;j<4;j++)
				{
					xrotate();
					if(one.toString().equals(two))
					{
						same = true;
						break test;
					}
				}
				if(i%2==0)
					yrotate();
				if(i%2==1)
					zrotate();
			}	
		if(same)
			System.out.println("TRUE");
		else
			System.out.println("FALSE");
		}
		s.close();
	}
	
	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}
	
}
