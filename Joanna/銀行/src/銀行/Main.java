package �Ȧ�;

public class Main {
	
	public static void main(String[] args) {
	
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setName(i + "��");
			user.start();
		}
		
	}
	
}
