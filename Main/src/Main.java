// UVa 445 Marvelous Mazes
// Current Status: Accepted
// Last Submitted: 2015-05-10 06:42:33
// Run Time: 0.249

//Does not accept pure newline but should output exactly the blank line when there is a blank...lol
import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		Scanner s;
		s = new Scanner(System.in);
		boolean start = true;
		while(s.hasNextLine())
		{
			String line = s.nextLine();
			start = false;
			int repeat = 0;
			for(int i=0;i<line.length();i++)
			{
				switch(line.charAt(i))
				{
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
					case '0':
						repeat += line.charAt(i)-'0';
						break;
					case 'b':
						for(int j=0;j<repeat;j++)
							System.out.print(' ');
						repeat = 0;
						break;
					case '!':
						System.out.println();
						break;
					case '*':
					case 'A':
					case 'B':
					case 'C':
					case 'D':
					case 'E':
					case 'F':
					case 'G':
					case 'H':
					case 'I':
					case 'J':
					case 'K':
					case 'L':
					case 'M':
					case 'N':
					case 'O':
					case 'P':
					case 'Q':
					case 'R':
					case 'S':
					case 'T':
					case 'U':
					case 'V':
					case 'W':
					case 'X':
					case 'Y':
					case 'Z':
					case 'a':
					case 'c':
					case 'd':
					case 'e':
					case 'f':
					case 'g':
					case 'h':
					case 'i':
					case 'j':
					case 'k':
					case 'l':
					case 'm':
					case 'n':
					case 'o':
					case 'p':
					case 'q':
					case 'r':
					case 's':
					case 't':
					case 'u':
					case 'v':
					case 'w':
					case 'x':
					case 'y':
					case 'z':
						for(int j=0;j<repeat;j++)
							System.out.print(line.charAt(i));
						repeat = 0;
						break;
					default:
				}
			}
			if(line.trim().length()==0)
			{
				System.out.println(line);
				continue;
			}

			System.out.println();
		}
		s.close();
	}
}