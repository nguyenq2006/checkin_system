
public class Student implements Comparable<Student>{
	private int id;
	private String last;
	private String first;
	private int points;
	
	public Student(int id, String last, String first, int points){
		this.id = id;
		this.last = last;
		this.first = first;
		this.points = points;
	}
	
	public int getID() {
		return id;
	}
	
	public String getLast(){
		return last;
	}
	
	public String getFirst(){
		return first;
	}
	
	public int getPoints(){
		return points;
	}
	
	public void addPoint(){
		this.points++;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.id, o.id);
	}

}
