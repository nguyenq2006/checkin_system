
public class DataManager {
	private DataBase db;
	private static DataManager dm= new DataManager();
	private DataManager() {
		this.db =  new DataBase();
	}
	
	public void start(){
		db.load();
	}
	
	public static DataManager getInstance() {
		return dm;
	}
	
	public Student checkStudent(int id) {
		return db.getStudent(id);
	}
	
	public void update(Student s) {
		db.updateData(s);
	}
 }
