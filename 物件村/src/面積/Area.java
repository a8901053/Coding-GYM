package 面積;

import java.util.Scanner;

public class Area {
	private static Scanner input;

	public static void main(String[] args){
		System.out.println("請先輸入數字選擇何種形狀的面積 :1.三角形、2.矩形、3.圓形");
		input = new Scanner(System.in);
		int x=input.nextInt();
		
		if(x==1){
		Triangle a = new Triangle();
		a.show();
		}
		if(x==2){
		Rectangle b = new Rectangle();
		b.show();
		}
		if(x==3){
		Circular c = new Circular();
		c.show();
		}
	}
}



