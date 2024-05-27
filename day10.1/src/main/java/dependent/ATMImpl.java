package dependent;

import com.mysql.cj.jdbc.exceptions.MySQLTransactionRollbackException;

import dependency.Transport;

public class ATMImpl implements ATM {
	private long cash; //mandatory dependency
	private Transport myTransport;// optional dependency
	

	private ATMImpl(long cash1) {
		this.cash=cash1;
		System.out.println("in cnstr of " + getClass() + " "+cash+" "+ myTransport);
	}

	public ATMImpl(Transport t12) {
		// TODO Auto-generated constructor stub
	}

	public void setMyTransport(Transport myTransport) {
		System.out.println("in set mytransport");
		this.myTransport = myTransport;
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
	}
	
	// custom init method
	public void anyInit() {
		System.out.println("in init " + myTransport);
	}

	// custom destroy method
	public void anyDestroy() {
		System.out.println("in destroy " + myTransport);
	}
	
	//add a factory method for DI
	public static ATMImpl myFactoryMethod(Transport t12) {
		System.out.println("in factory method");
		return new ATMImpl(t12);
	}
	
	
	
	
	

}
