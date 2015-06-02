// UVa 640 Self Numbers
// Current Status: Accepted
// Last Submitted: 2015-06-02 11:02:40
// Run Time: 2.046

import java.util.PriorityQueue;

class Main {

	public static void main(String[] args) {
		PriorityQueue<Integer> selfNumber = new PriorityQueue<Integer>();
		for(int i=1;i<=1000000;i++){
			int sum=i;
			int temp = i;
			while(temp!=0)
			{
				sum+=temp%10;
				temp/=10;
			}
			selfNumber.add(sum);
		}
		int next = selfNumber.poll();
		for(int i=1;i<=1000000;i++){
			if(next>i)
				System.out.println(i);
			else
			{
				while(next==i)
					next = selfNumber.poll();
			}
		}
		int a =0;
	}
}
