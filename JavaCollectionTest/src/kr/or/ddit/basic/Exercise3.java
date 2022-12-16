package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Exercise3 {
	private  Scanner scanner;
	private  Map<String, Hotel> hotelMap;
	public Exercise3() {
		scanner = new Scanner(System.in);
		hotelMap = new HashMap<String, Hotel>();
	}
	
	public static void main(String[] args) {
		new Exercise3().hotelStart();
	}
	
	public void hotelStart() {
		System.out.println("**********************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**********************");
		System.out.println();
		while(true) {
			System.out.println("***********************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인2.체크아웃3.객실상태4.업무종료");
			System.out.println("***********************************");
			System.out.print("메뉴 선택 =>");
			int input = scanner.nextInt();
			
			switch (input) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				room();
				break;
			case 4:
				System.out.println("**********************");
				System.out.println("호텔 문을 닫았습니다.");
				System.out.println("**********************");
				return;
			default:
				System.out.println("잘못 입력했습니다.");
			}
		}
	}

	private void checkIn() {
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		scanner.nextLine();
		String roomNum = scanner.nextLine();
		if(hotelMap.get(roomNum) != null) {
			System.out.println(roomNum+"방에는 이미 사람이 있습니다.");
			return;
		}
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
		
		String name = scanner.nextLine();
		
		Hotel h = new Hotel(roomNum, name);
		
		hotelMap.put(roomNum, h);
		System.out.println("체크인 되었습니다.");
	}		
	private void room() {
		/*Set<String> entrySet = hotelMap.keySet();
		Iterator<String> entryIt = entrySet.iterator();
		
		if(entrySet.size() == 0) {
			System.out.println("객실이 존재하지 않습니다.");
		}
		else {
			while(entryIt.hasNext()) {
				String roomNum = entryIt.next();
				hotel h = hotelMap.get(roomNum);
				
				System.out.println("방번호 : "+h.getRoomNum()+", 투숙객 : "+h.getName());
			}
		}*/
		Set<Map.Entry<String, Hotel>> entrySet = hotelMap.entrySet();
		Iterator<Map.Entry<String, Hotel>> entryIt = entrySet.iterator();
		
		if(entrySet.size() == 0) {
			System.out.println("객실이 존재하지 않습니다.");
		}
		else {
			while(entryIt.hasNext()) {
				Map.Entry<String, Hotel> entry = entryIt.next();
				System.out.print("방번호 : "+entry.getKey()+", ");
				System.out.println("투숙객 : "+entry.getValue());
			}
		}
	}
	private void checkOut() {
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		scanner.nextLine();
		String roomNum = scanner.nextLine();
		
		if(hotelMap.remove(roomNum) == null) {
			System.out.println(roomNum+"방에는 체크인한 사람이 없습니다.");
		}
		else {
			System.out.println("체크아웃 되었습니다");
		}
	}
}
class Hotel{
	private String roomNum;
	private String name;
	
	public Hotel(String roomNum, String name) {
		this.roomNum = roomNum;
		this.name = name;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public String getName() {
		return name;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((roomNum == null) ? 0 : roomNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (roomNum == null) {
			if (other.roomNum != null)
				return false;
		} else if (!roomNum.equals(other.roomNum))
			return false;
		return true;
	}

	
	
	
	
}


