package hanbit;

public class PeopleRegisterService {
	private PeopleDao peopleDao;
	
	public PeopleRegisterService(PeopleDao peopleDao) {
		this.peopleDao = peopleDao;
	}
	
	public void register(People people) {
		if(verify(people.getsId())) {
			peopleDao.insert(people);
		} else {
			System.out.println("이미 등록된 회원입니다.");
		}
	}
	
	public boolean verify(String id) {
		People people = peopleDao.select(id);
		return people == null ? true : false;
	}
}
