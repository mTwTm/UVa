// UVa 401 Palindromes
// Current Status: Accepted
// Last Submitted: 2015-05-09 00:28:21
// Run Time: 1.066

import java.util.Scanner;


class Main {

	static char mirror(char c){
		switch(c)
		{
			case 'A':
			case 'H':
			case 'I':
			case 'M':
			case 'O':
			case 'T':
			case 'U':
			case 'V':
			case 'W':
			case 'X':
			case 'Y':
			case '1':
			case '8':
				return c;
			case 'E':
				return '3';
			case 'J':
				return 'L';
			case 'L':
				return 'J';
			case 'S':
				return '2';
			case 'Z':
				return '5';
			case '2':
				return 'S';
			case '3':
				return 'E';
			case '5':
				return 'Z';
			default:
				return 0;
		}
	}

	public static void main(String[] args) {
		Scanner s;
		s = new Scanner(System.in);
		while(s.hasNextLine()){
			boolean isPalindrome = true;
			boolean isMirrored = true;
			String word = s.nextLine();
			word = word.trim();
			for(int i=0;i<=(word.length())/2;i++){
				if(word.charAt(i)!=word.charAt(word.length()-i-1))
					isPalindrome = false;
				if(word.charAt(i)!=mirror(word.charAt(word.length()-i-1)))
					isMirrored = false;
			}
			System.out.print(word);
			if(isPalindrome&&isMirrored)
				System.out.println(" -- is a mirrored palindrome.");
			if(isPalindrome&&!isMirrored)
				System.out.println(" -- is a regular palindrome.");
			if(!isPalindrome&&isMirrored)
				System.out.println(" -- is a mirrored string.");
			if(!isPalindrome&&!isMirrored)
				System.out.println(" -- is not a palindrome.");
			System.out.println();
		}
		s.close();
	}

}