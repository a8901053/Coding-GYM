package 學生資訊系統;

import java.util.Scanner;

public class StudentSystem {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args){
		System.out.println("請輸入學生人數: ");
		StudentInformation[] number  = new StudentInformation[input.nextInt()];
		int k,t;
		int i;
		for(i=0;i<number.length;i++){
			number [i] = new StudentInformation(input.nextFloat(),input.nextFloat(),
							input.nextInt(),input.next() );	
			
			}
		for(k=0;k<number.length-1;k++)
			for(t=k+1;t<number.length;t++)
				if ( number[k].getGrade() > number[t].getGrade() )
				{
					StudentInformation v = number[t];
					number[t] = number[k];
					number[k] = v;
		}
		for ( StudentInformation result : number )
			System.out.println(result);
		
	}
}
