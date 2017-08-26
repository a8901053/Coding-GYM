package 銀行;

public class Bank {
	
	private static Bank instance;
	private int balance;
	private int depositMoney;
	private int drawMoney;
	
	public static Bank getInstance() {
		if (instance == null)
			instance = new Bank();
		return instance;
	}
	
	public Bank() {
		setBalance(10000);
		drawMoney = 0;
		depositMoney = 0;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public synchronized void deposit(int money) {
		if (!hasBlance()) 
			return;
		balance += money;
		depositMoney += money;
		System.out.println(Thread.currentThread().getName() + "存$ " + money + ", 剩$ " + getBalance());
	}
	
	public synchronized void draw(int money) {
		if (!hasBlance()) 
			return;
		if (balance >= money) {
			balance -= money;
			drawMoney += money;
			System.out.println(Thread.currentThread().getName() + "要提$ " + money + ", 得到$ " + money + ", 剩$ " + getBalance());
		}
		else {
			System.out.println(Thread.currentThread().getName() + "要提$ " + money + ", 得到$ " + balance + ", 剩$ 0");
			drawMoney += balance;
			setBalance(0);
			compareMoney();
		}
	}
	
	public boolean hasBlance() {
		if (getBalance() == 0) {
			try {
				Thread.currentThread().join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		return true;
	}
	
	public void compareMoney() {
		System.out.println("10000 + " + depositMoney + " = " + drawMoney);
	}
	
}
