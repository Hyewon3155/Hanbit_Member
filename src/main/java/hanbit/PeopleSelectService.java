package hanbit;


public class PeopleSelectService {
	private PeopleDao peopleDao;
	
	public PeopleSelectService(PeopleDao peopleDao) {
		this.peopleDao = peopleDao;
	}
	public People select(String id) {
		if(verify(id)) {
			return peopleDao.select(id);
		} else {
			System.out.println("등록되지 않은 회원입니다.");
		}
		
		return null;
	}
	
	public boolean verify(String id) {
		People people = peopleDao.select(id);
		return people != null ? true : false;
	}
}
