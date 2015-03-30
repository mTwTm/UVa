// UVa 138 Street Numbers 
// Current Status: Accepted
// Last Submitted: 2015-03-30 16:00:27
// Run Time: 0.695

class Main {
	
	public static long safeSqrt(long square){
		long rough = (long) Math.sqrt(square);
		for(int i=-1;i<=1;i++)
		{
			if( (rough+i) * (rough+i) == square)
				return rough+i;
		}
		return -1;
	}
	
	public static String smartPrint(long i){
		String s = Long.toString(i);
		while(s.length()<10)
		{
			s = " " + s;
		}
		return s;
	}

	public static void main(String[] args) {
		int counter = 0;
		for(long i=2;counter<10;i++)
		{
			long sqrt = safeSqrt( (2*i+1)*(2*i+1)-4*(i-i*i) ); 
			if( sqrt!=-1)
			{
				long k = ( sqrt - (2*i+1) ) / 2; 
				if(k<=0)
					continue;
				System.out.println(smartPrint(i)+smartPrint(i+k));
				counter++;
			}
		}
	}
}
