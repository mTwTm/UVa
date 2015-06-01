// UVa 572 Oil Deposits
// Current Status: Accepted
// Last Submitted: 2015-06-01 13:35:31
// Run Time: 0.815

import java.util.*;

class Main {
	private static class Point implements Comparable{
		public int getX(){
			return x;
		}
		public int getY(){
			return y;
		}
		private int x;
		private int y;
		public Point(){

		}
		public Point(int x, int y)
		{
			this();
			setLocation(x, y);
		}
		public void setLocation(int x, int y){
			this.x = x;
			this.y = y;
		}
		public boolean equals(Object p){
			if(getX()==((Point)p).getX()&&getY()==((Point)p).getY())
				return true;
			else
				return false;
		}
		@Override
		public int compareTo(Object p) {
			if(getX()>((Point)p).getX() || (getX()==((Point)p).getX()&&getY()>((Point)p).getY()))
				return 1;
			else if(equals(p))
				return 0;
			else
				return -1;
		}
		public void printInfo()
		{
			System.out.println("x= "+x+" y= "+y);
		}
	}
	private static class Zone{
		public Zone(){
			coordinates = new TreeSet<Point>();
			searchBuffer = new Point();
		}
		public SortedSet<Point> getCoordinates(){
			return coordinates;
		}
		private SortedSet<Point> coordinates;
		private Point searchBuffer;
		boolean checkMerge(Point target){
			for(int i=-1;i<=1;i++)
			{
				for(int j=-1;j<=1;j++)
				{
					if(i==0&&j==0)
						continue;
					searchBuffer.setLocation(target.getX()+i,target.getY()+j);
					if(coordinates.contains(searchBuffer))
						return true;
				}
			}
			return false;
		}
		void add(Point target){
			coordinates.add(target);
		}
		void merge(Zone target){
			coordinates.addAll(target.getCoordinates());
		}
		public void printInfo()
		{
			System.out.println("Zone Info:");
			System.out.println("=================");
			for(Point p: coordinates)
				p.printInfo();
			System.out.println("=================");
		}
	}
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt())
		{
			int xSize = scan.nextInt();
			int ySize = scan.nextInt();
			scan.nextLine();
			if(xSize==0&&ySize==0)
				break;
			List<Point> pool = new ArrayList<Point>();
			List<Zone> zones = new ArrayList<Zone>();
			for(int i=0;i<xSize;i++)
			{
				String s = scan.nextLine();
				for(int j=0;j<ySize;j++)
				{
					if(s.charAt(j)=='@')
						pool.add(new Point(i,j));
				}
			}
			for(Point p : pool)
			{
				ArrayList<Integer> matches = new ArrayList<Integer>();
				for(int i=0;i<zones.size();i++)
				{
					if(zones.get(i).checkMerge(p)==true)
						matches.add(i);
				}
				if(matches.size()==0)
				{
					Zone newZone = new Zone();
					newZone.add(p);
					zones.add(newZone);
				}
				else
				{
					Zone keep = zones.get(matches.get(0));
					for(int i=1;i<matches.size();i++)
					{
						keep.merge(zones.get(matches.get(i)));
						zones.remove(zones.get(matches.get(i)));
					}
					keep.add(p);
				}
				//System.out.println("After adding point<"+p.getX()+","+p.getY()+">");
				/*for(Zone z : zones)
					z.printInfo();*/
			}
			System.out.println(zones.size());
		}
		scan.close();
	}
}
