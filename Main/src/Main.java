// UVa 333 Recognizing Good ISBNs
// Current Status: Accepted
// Last Submitted: 2015-04-03 07:06:00 
// Run Time: 0.575

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

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
//		Scanner s = new Scanner(System.in);
		String isbn;
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));  
		try {
			while((isbn = bfr.readLine()) != null)
			{
				isbn = isbn.trim();
				boolean correct = true;
				correct = validate(isbn);
				bfw.write(isbn + " is ");
				if(!correct)
					bfw.write("in");
				bfw.write("correct.");
				bfw.newLine();
			}
		} catch (IOException e) {
			isbn = null;
			e.printStackTrace();
		}
		//s.close();
		try {
			bfr.close();
			bfw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}
	
}
