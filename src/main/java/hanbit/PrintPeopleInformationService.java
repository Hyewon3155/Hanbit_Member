package hanbit;

import java.util.*;
import hanbit.People;
public class PrintPeopleInformationService {
	PeopleAllSelectService allSelectService;
	
	public PrintPeopleInformationService(PeopleAllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}
	
	public void printPeopleInfo() {
		Map<String, People> allPeople = allSelectService.allSelect();
		Set<String> keys = allPeople.keySet();
		Iterator<String> iterator = keys.iterator();
		System.out.println("PEOPLE LIST START -------------");
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			People people = allPeople.get(key);
			System.out.println("id:" + people.getsId() + "\t");
			System.out.println("pw:" + people.getsPw() + "\t");
			System.out.println("phoneNum:" + people.getsPhoneNum() + "\t");
			System.out.println("email:" + people.getsEmail() + "\t");
			System.out.println("regDate:" + people.getsRegDate() + "\t");
			System.out.println("updateDate:" + people.getsUpdateDate() + "\t");
		}
		System.out.println("END --------------");
	}
}
