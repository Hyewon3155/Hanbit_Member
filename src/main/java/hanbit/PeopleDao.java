package hanbit;
import java.util.*;

public class PeopleDao {
	private Map<String, People> peopleDB = new HashMap<String, People>();
	
	public void insert(People people) {
		peopleDB.put(people.getsId(), people);
	}
	
	public People select(String id) {
		return peopleDB.get(id);
	}
	
	public void update(People people) {
		peopleDB.put(people.getsId(), people);
	}
	
	public void delete(String id) {
		peopleDB.remove(id);
	}
	
	public Map<String, People> getPeopleDB(){
		return peopleDB;
	}
}
