package 例外處理.登入;
import java.util.Scanner;

import Loginsystem.*;

public class SignIn {
	public static Scanner input = new Scanner(System.in);
	

public static void main(String[] args){
	boolean checkright = false;
	while(checkright==false){
	try{
		Check.checkinformation(accountinput(),passwordinput());
		checkright = true;
	}catch(Accounterror | Passworderror | Allerror ex){
		System.out.println(ex.getMessage());
	}
	
	}
	
	System.out.println("登入成功");
}

public static String accountinput(){
	System.out.println("input your account: ");
	String account = input.next();
	return account;
}

public static String passwordinput(){
	System.out.println("input your password: ");
	String password = input.next();
	return password;
}

}

