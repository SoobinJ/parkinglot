package jsbAssignment;

import java.util.Scanner;

public class assignment02 {

	public static Scanner scanner =new Scanner(System.in);
	
	static final int ROW = 4;
	static final int COL = 3;
	
	public static void main(String[] args) {

		String [][] parkingSpace = new String [ROW][COL];	
	
		while(true) {
			System.out.println("주차관리 (202011780 전수빈)");
			System.out.println();
			System.out.println("  1 2 3");
			for(int i=0;i<parkingSpace.length;i++) {
				System.out.print(i+1);
				for(int j=0;j<parkingSpace[i].length;j++) {
					if(parkingSpace[i][j]==null) {
						System.out.print(" ♡");
					}
					else
						System.out.print(" ♥");
					}
				System.out.println();
				}		
			System.out.println();
			System.out.println("1) 주차하기 2) 출차하기 3) 종료");
			System.out.print("메뉴를 선택하세요 : ");
			String menu = scanner.next();
			switch(menu) {
			case "1":
				scanner.nextLine();
				System.out.print("주차할 위치를 선택해 주세요 (입력예 : 2 1) : ");
				int location1 = scanner.nextInt();
				int location2 = scanner.nextInt();
				if(location1>ROW||location2>COL) {
					System.out.print("위치 번호를 확인해 주세요.");
					System.out.println("처음부터 다시 시작해 주세요.");
					System.out.println();
					break;
				}
				if(parkingSpace[location1-1][location2-1]!=null) {
					System.out.print("다른 차량이 주차되어 있습니다.");
					System.out.println("처음부터 다시 시작해 주세요.");
					System.out.println();
					break;
				}
				
				System.out.print("차량 번호를 입력해 주세요 (입력예 : 20가1234) : ");
				String number = scanner.next();
				scanner.nextLine();
				System.out.print("차량 번호 "+number+" 맞습니까(y/n)?");
				String a = scanner.nextLine();
				if(a.equals("y")) {
					System.out.println(number+"차량의 주차를 완료하였습니다.");
					System.out.println();
					parkingSpace[location1-1][location2-1]=number;
					}		
				else {
					System.out.println("처음부터 다시 진행해 주세요."); 
					System.out.println();
					break;
				}
				break;
			case "2":
				System.out.print("차량 번호를 입력해 주세요 : ");
				String num = scanner.next();
				int count=0;
				for(int i=0;i<parkingSpace.length;i++){
					for(int j=0;j<parkingSpace[i].length;j++) {
						if(parkingSpace[i][j]!=null) {
							if(parkingSpace[i][j].equals(num)) {
								System.out.println(num+" 차량이 출차되었습니다. 안녕히가세요.");
								System.out.println();
								parkingSpace[i][j]=null;
								break;
							}
							else {
								count++;
							}
						}
						else
							count++;
					}
				}
				if(count==ROW*COL) {
					System.out.println("차량이 존재하지 않습니다. 차량번호 확인 후 처음부터 다시 진행해 주세요."); 
					System.out.println();
				}
				break;
			
			case "3":
				scanner.close();
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("메뉴 번호를 확인 후 다시 입력해 주세요.");
				System.out.println();
				
			}
		}
		
	}

}
