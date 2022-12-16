package kr.or.ddit.basic;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Exercise2 {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		lottoMain();
	}
	public static int lottoMain() {
		//Scanner scanner = new Scanner(System.in);
		System.out.println("=================================");
		System.out.println("Lotto 프로그램");
		System.out.println("-------------------------");
		System.out.println("1.Lotto 구입");
		System.out.println("2.프로그램 종료");
		System.out.println("=================================");
		System.out.print("메뉴 선택 : ");
		int input = scanner.nextInt();
		
		switch (input) {
		case 1:
			return lotto();
		case 2:
			System.out.println("감사합니다.");
			break;
		}
		return 0;
		
	}
	
	public static int lotto() {
		System.out.println("Lotto 구입 시작");
		System.out.println();
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.print("금액 입력 : ");
		int money = scanner.nextInt();
		int conut = money / 1000;
		System.out.print("행운의 로또번호는 아래와 같습니다.");
		
		for(int i = 0; i<conut; i++) {
			Set<Integer> intRnd = new HashSet<Integer>();
			while(intRnd.size() < 6) {
				int num = (int)(Math.random()*45+1);
				intRnd.add(num);
			}
			System.out.print("\n로또번호"+(i+1)+" : ");
			for(Integer num : intRnd) {
				System.out.print(num + " ");
			}
			
//			List<Integer> intRndList = new ArrayList<Integer>(intRnd);
//			System.out.print("\n로또번호"+(i+1)+" : ");
//			for(Integer num : intRndList) {
//				System.out.print(num + " ");
//			}
			
		}
		System.out.println();
		System.out.println("받은 금액은 "+money+"원 이고 거스름돈은 "+money%1000+"원 입니다.");
		return lottoMain();
	}
}
