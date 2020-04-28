package phonebook04.list;

import java.util.ArrayList;
import java.util.Iterator;

// CONTROLLER 객체
//   어플리케이션의 동작, 데이터 처리(CRUD), (Business logic 담당)
public class PhonebookManager implements Pb {

	private ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
	
	// singleton적용
	private PhonebookManager() {}
	private static PhonebookManager instance = null;
	public static PhonebookManager getInstance() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	} // end getInstance()	
	
	// 전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {
		
		// 매개변수 검증 : 이름 필수
		if(name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름입력오류: ", Pb.ERR_EMPTY_STRING);
		}
		
		// TODO
		PhonebookModel model = new PhonebookModel(name, phoneNum, memo);
		model.setUid(getMaxUid() + 1);
		pbList.add(model);
		
		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {
		PhonebookModel[] arrModel = new PhonebookModel[pbList.size()];
		int i = 0;
		for(PhonebookModel m : pbList) {
			arrModel[i] = m;
			i++;
		}
		return arrModel; // TODO;
	}

	// 특정 uid 의 데이터 검색 리턴
	// 못찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {
		
		// TODO
		Iterator<PhonebookModel> itr = pbList.iterator();
		while(itr.hasNext()) {
			PhonebookModel model = itr.next();
			if(model.getUid() == uid)
				return model;
		}
		
		return null;  // 못찾으면 null 리턴
	}// end selectByUid()

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {
		
		// 매개변수 검증
		if(uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, Pb.ERR_UID);
		if(name == null || name.trim().length() == 0)
			throw new PhonebookException("update() 이름입력 오류: ", Pb.ERR_EMPTY_STRING);
		
		// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
		int index = findIndexByUid(uid);
		if(index < 0)
			throw new PhonebookException("update() 없는 uid: " + uid, Pb.ERR_UID);
		
		// TODO
		pbList.get(index).setName(name);
		pbList.get(index).setPhoneNum(phoneNum);
		pbList.get(index).setMemo(memo);
		
		return 1;
	}

	@Override
	public int deleteByUid(int uid) {
		
		// 매개변수 검증
		if(uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류: " + uid, Pb.ERR_UID);
		
		int index = findIndexByUid(uid);
		if(index < 0)
			throw new PhonebookException("deleteByUid() 없는 uid: " + uid, Pb.ERR_UID);
		
		// TODO
		pbList.remove(index);
		
		return 1;
	}
	
	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;
		
		// TODO
		Iterator<PhonebookModel> itr = pbList.iterator();
		while(itr.hasNext()) {
			PhonebookModel model = itr.next();
			if(maxUid < model.getUid())
				maxUid = model.getUid();
		}
		
		return maxUid;
	}
	
	// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
	// 못찾으면 -1 리턴
	private int findIndexByUid(int uid) {

		// TODO
		Iterator<PhonebookModel> itr = pbList.iterator();
		int index = 0;
		while(itr.hasNext()) {
			PhonebookModel model = itr.next();
			if(model.getUid() == uid)
				return index;
			index++;
		}
		
		return -1;
	}

}	

// 예외 클래스 정의
// 예외 발생하면 '에러코드' + '에러메세지'를 부여하여 관리하는게 좋다.
class PhonebookException extends RuntimeException {
	private int errCode = Pb.ERR_GENERIC;
	
	public PhonebookException() {
		super("Phonebook 예외 발생");
	}
	
	public PhonebookException(String msg) {
		super(msg);
	}
	
	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}
	
	// Throwable 의 getMessage 를 오버라이딩 가능
	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] +
				" " + super.getMessage();
		return msg;
	}
	
}
