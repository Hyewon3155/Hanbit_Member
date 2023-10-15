package hanbit;
import hanbit.People;
import hanbit.PeopleDao;

public class PeopleModifyService {
	private PeopleDao peopleDao;
	
	public PeopleModifyService(PeopleDao peopleDao) {
		this.peopleDao = peopleDao;
	}
	
	public void modify(People people) {
		if(verify(people.getsId())) {
			peopleDao.update(people);
		} else {
			System.out.println("등록되지 않은 회원입니다.");
		}
	}
	
	public boolean verify(String id) {
		People people = peopleDao.select(id);
		return people != null ? true : false;
	}
}
