package 基本多型知識.人;

import java.util.Scanner;
import java.util.ArrayList;

public class Runprogram {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Human> mylist = new ArrayList();

	public static void main(String[] args){
		System.out.println("請輸入男生(B/b)或女生(G/g): ");
		String sInput = input.next();
		for(int i=0;i<sInput.length();i++)
		{
			char a = sInput.charAt(i);
			
			if(a=='b'||a=='B'){
				mylist.add(new Man());
			}
			else if(a=='g'||a=='G'){
				mylist.add(new Woman());
			}
			
		}
		for(Human ouputA:mylist){
			ouputA.eat();
		}
		for(Human ouputB:mylist){
			ouputB.sleep();
		}
	}
}
