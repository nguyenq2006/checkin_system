import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class DataBase {
	private TreeMap<Integer, Student> attendence;
	private Set<Student> daily_checkin;
	private File attendees;
	private File checkin;

	public DataBase(){
		this.attendence = new TreeMap<>();
		daily_checkin = new HashSet<Student>();
		attendees = new File("data.txt");
		checkin = new File("per_session.txt");
	}

	public void load() {
		try { 
			Scanner in = new Scanner(attendees);
			while(in.hasNextLine()){
				String line = in.nextLine().trim();
				if(!(line.contains("ID") && line.contains("Last") && line.contains("First"))) {
					String[] info = line.split("\\s+");
					int id = Integer.parseInt(info[0].trim());
					String last = info[1].trim();
					String first = info[2].trim();
					int pts = Integer.parseInt(info[3].trim());
					Student p = new Student(id, last, first, pts);
					attendence.put(id, p);
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Input file not found");
		}	

		try {
			FileWriter out = new FileWriter(checkin.getAbsolutePath(), true);
			out.append("\n");
			GregorianCalendar c = new GregorianCalendar();
			String date = String.format("%02d/%2d/%4d\n", c.get(Calendar.MONTH)+1, c.get(Calendar.DATE), c.get(Calendar.YEAR));
			out.append(date);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot write to file");
		}
	}
	public void save(){
		try {
			PrintStream out = new PrintStream(attendees);
			PrintStream out2 = new PrintStream(new File("attendees.txt"));
			out.flush();
			out2.flush();
			out.printf("%9s%15s%15s%10s\n", "ID", "Last", "First", "Points");
			out2.printf("%9s%15s%15s\n", "ID", "Last", "First");
			for(int id : attendence.keySet()) {
				Student s = attendence.get(id);
				out.printf("%09d%15s%15s%10d\n", s.getID(), s.getLast(), s.getFirst(), s.getPoints());
				out2.printf("%09d%15s%15s\n", s.getID(), s.getLast(), s.getFirst());
			}
			out.close();
			out2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Output file not found");
		}

	}

	public Student getStudent(int id) {
		return attendence.get(id);
	}

	public void updateData(Student s) {
		if(attendence.containsKey(s.getID())) {
			attendence.get(s.getID()).addPoint();
		}
		else {
			attendence.put(s.getID(), s);
		}
		this.save();
		try {
			FileWriter out = new FileWriter(checkin.getAbsolutePath(), true);
			if(!daily_checkin.contains(s)){
				daily_checkin.add(s);
				String student = String.format("%09d%15s%15s\n", s.getID(), s.getLast(), s.getFirst());
				out.append(student);
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot write to file");
		}
	}
}
