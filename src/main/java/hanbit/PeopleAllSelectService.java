package hanbit;

import java.util.Map;

import hanbit.People;
import hanbit.PeopleDao;

public class PeopleAllSelectService {
	private PeopleDao peopleDao;
	
	public PeopleAllSelectService(PeopleDao peopleDao) {
		this.peopleDao = peopleDao;
	}
	
	public Map<String, People> allSelect() {
		return peopleDao.getPeopleDB();
	}
	
}
