// UVa 333 Recognizing Good ISBNs
// Current Status: Accepted|Pending|TooSlow
// Last Submitted: 
// Run Time: 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private boolean validate(String isbn)
	{
		int sum = 0;
		List<Integer> digit = new ArrayList<Integer>();
		for(int i=0;i<isbn.length();i++)
		{
			if(isbn.charAt(i)>='0'&&isbn.charAt(i)<='9')
				digit.add(isbn.charAt(i)-'0');
			else if(isbn.charAt(i)=='X')
			{
				if(digit.size()==9)
					digit.add(10);
				else
					return false;
			}
			else if(isbn.charAt(i)!='-')
				return false;
		}
		if(digit.size()!=10)
			return false;
		for(int i=0;i<digit.size();i++)
		{
			sum += (10-i) * digit.get(i);
		}
		if(sum%11!=0)
			return false;
		return true;
	}
	
	private void run(){
		Scanner s = new Scanner(System.in);
		while(s.hasNext())
		{
			boolean correct = true;
			String isbn = s.next();
			correct = validate(isbn);
			System.out.print(isbn + " is ");
			if(!correct)
				System.out.print("in");
			System.out.println("correct.");
		}
		s.close();
	}
	
	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}
	
}
