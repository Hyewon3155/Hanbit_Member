package hanbit;

public class PeopleDeleteService {
	private PeopleDao peopleDao = new PeopleDao();
	
	public PeopleDeleteService(PeopleDao peopleDao) {
		this.peopleDao = peopleDao;
	}
	
	public void delete(String id) {
		if(verify(id)) {
			peopleDao.delete(id);
		} else {
			System.out.println("등록되지 않은 회원입니다.");
		}
	}
	
	public boolean verify(String id) {
		People people = peopleDao.select(id);
		return people != null ? true : false;
	}
}
