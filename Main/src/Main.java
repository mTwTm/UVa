// UVa 706 LCD Display
// Current Status: Accepted
// Last Submitted: 
// Run Time: 

//UVA 706 - LCD Display
import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		final boolean[][] digitSegments= {
				{true,  true,  true, true,  true,  true,  false},
				{false, true,  true, false, false, false, false},
				{true,  true, false, true,  true,  false, true },
				{true,  true,  true, true,  false, false, true },
				{false, true,  true, false, false, true,  true },
				{true,  false, true, true,  false, true,  true },
				{true,  false, true, true,  true,  true,  true },
				{true,  true , true, false, false, false, false},
				{true,  true , true, true,  true,  true,  true },
				{true,  true , true, true,  false, true,  true },
		};
		Scanner s = new Scanner(System.in);
		boolean first = true;
		while(s.hasNextInt())
		{
			int size = s.nextInt();
			String [] printBuffer = new String[2*size+3];
			for(int i=0;i<printBuffer.length;i++)
				printBuffer[i] = "";
			int number = s.nextInt();
			if(number==0&&size==0)
				break;
			int[] numberSplit = new int[8];
			for(int i=0;i<8;i++)
			{
				numberSplit[i]=-1;
			}
			if(number==0)
				numberSplit[7]=0;
			for(int i=7;number!=0;i--)
			{
				numberSplit[i] = number%10;
				number/=10;
			}
			for(int i=0;i<8;i++){
				if(numberSplit[i]==-1)
					continue;
				printBuffer[0] = printBuffer[0].concat(" ");
				for(int j=0;j<size;j++)
				{
					if(digitSegments[numberSplit[i]][0]==true)
						printBuffer[0] = printBuffer[0].concat("-");
					else
						printBuffer[0] = printBuffer[0].concat(" ");
				}
				printBuffer[0] = printBuffer[0].concat(" "); //Print part a;
				for(int j=0;j<size;j++)
				{
					if(digitSegments[numberSplit[i]][5]==true)
						printBuffer[1+j] = printBuffer[1+j].concat("|");
					else
						printBuffer[1+j] = printBuffer[1+j].concat(" ");
					for(int k=0;k<size;k++)
						printBuffer[1+j] = printBuffer[1+j].concat(" ");
					if(digitSegments[numberSplit[i]][1]==true)
						printBuffer[1+j] = printBuffer[1+j].concat("|");
					else
						printBuffer[1+j] = printBuffer[1+j].concat(" ");
				}//Print part b&f;
				printBuffer[size+1] = printBuffer[size+1].concat(" ");
				for(int j=0;j<size;j++)
				{
					if(digitSegments[numberSplit[i]][6]==true)
						printBuffer[size+1] = printBuffer[size+1].concat("-");
					else
						printBuffer[size+1] = printBuffer[size+1].concat(" ");
				}
				printBuffer[size+1] = printBuffer[size+1].concat(" ");//Print part g;
				for(int j=0;j<size;j++)
				{
					if(digitSegments[numberSplit[i]][4]==true)
						printBuffer[size+2+j] = printBuffer[size+2+j].concat("|");
					else
						printBuffer[size+2+j] = printBuffer[size+2+j].concat(" ");
					for(int k=0;k<size;k++)
						printBuffer[size+2+j] = printBuffer[size+2+j].concat(" ");
					if(digitSegments[numberSplit[i]][2]==true)
						printBuffer[size+2+j] = printBuffer[size+2+j].concat("|");
					else
						printBuffer[size+2+j] = printBuffer[size+2+j].concat(" ");
				}//Print part e&c;
				printBuffer[2*size+2] = printBuffer[2*size+2].concat(" ");
				for(int j=0;j<size;j++)
				{
					if(digitSegments[numberSplit[i]][3]==true)
						printBuffer[2*size+2] = printBuffer[2*size+2].concat("-");
					else
						printBuffer[2*size+2] = printBuffer[2*size+2].concat(" ");
				}
				printBuffer[2*size+2] = printBuffer[2*size+2].concat(" "); //Print part g;
				if(i!=7){
					for(int j=0;j<printBuffer.length;j++)
					{
						printBuffer[j] = printBuffer[j].concat(" ");
					}
				}
			}
			for(int i=0;i<printBuffer.length;i++)
				System.out.println(printBuffer[i]);
			System.out.println();
		}
		s.close();
	}
}
