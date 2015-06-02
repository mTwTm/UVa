// UVa 673 Parentheses Balance
// Current Status: Accepted
// Last Submitted: 2015-06-02 12:02:56
// Run Time: 0.613

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	private BufferedReader r;
	private BufferedWriter w;
	private Stack<Character> input;

	private void run(){

		try{

			r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			while( ( nextLine = r.readLine() ) != null )
			{
				int count = Integer.parseInt(nextLine);
				for(int i=0 ; i<count ; i++) {
					nextLine = r.readLine();
					boolean isBalance = true;
					input = new Stack<>();
					for(int j=0 ; j<nextLine.length() ; j++) {

						char head = input.size()==0 ? '\0' : input.peek();
						char next = nextLine.charAt(j);
						if(head!='\0') {
							if(head=='(') {
								if(next=='('||next=='[')
									input.push(next);
								else if(next==')') {
									input.pop();
									continue;
								}
								else if(next==']') {
									isBalance = false;
									break;
								}
							}
							else if (head == '[') {
								if(next=='('||next=='[')
									input.push(next);
								else if(next==']') {
									input.pop();
									continue;
								}
								else if(next==')') {
									isBalance = false;
									break;
								}
							}
						}
						else {
							input.push(next);
						}
					}
					if(input.size()!=0)
						isBalance = false;
					if(isBalance) {
						w.write("Yes\n");
					}
					else {
						w.write("No\n");
					}
				}
			}
			r.close();
			w.close();
		}
		catch(IOException ex)
		{
			//Nothing to do
		}

	}

	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}

}
