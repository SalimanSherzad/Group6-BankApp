package myTesting;
import java.util.Date;
import java.util.Random;

public class BankAccount {
	
	private int id; 
	private int pin;
	private double balance; 
	private DebitCard card;
	private Date created; 
	private boolean isOnline = false; 
	private String FirstName; 
	private String LastName; 
	// need to keep a string of logs and need to add actions after a withdraw or deposit 
	private String[] Log;
	private int LogCount;
	
	public BankAccount(int p, double bal, String FN, String LN, int id) {
		// need to make id unique to each instance 
	//	this.id = new Random().nextInt(999999);	// Random 6 digit number
		this.pin = p; 
		this.balance = bal;
		this.created = new Date();
		this.FirstName = FN; 
		this.card = new DebitCard(FN, LN, p);
		this.LastName = LN; 
		this.id = id;
		Log = new String[7];
		this.LogCount = 0;
	}	
	
	public BankAccount(int p, double bal, String FN, String LN) {
		// need to make id unique to each instance 
		this.id = new Random().nextInt(999999);	// Random 6 digit number
		this.pin = p; 
		this.balance = bal;
		this.created = new Date();
		this.FirstName = FN; 
		this.card = new DebitCard(FN, LN, p);
		this.LastName = LN; 
		Log = new String[7];
		this.LogCount = 0;
	}

	public int getId() {
		return this.id;
	}

	public int getPin() {
		return pin;
	}

	public double getBalance() {
		return balance;
	}

	public Date getCreated() {
		return created;
	}

	public boolean isOnline() {
		return isOnline;
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	
	public DebitCard getDebitCard() {
		return card;
	}
	
	public void setPin(int pin) {
		this.pin = pin;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
		/// need to add action to the log 
		String res = "deposited $" + amount;
		addToLog(res);
	}
	
	public void withdraw(double amount) {
		this.balance -= amount;
		// need to add action to log 
		String res = "withdrew $" + amount;
		addToLog(res);
	}
	
	public String getLog() {
		
		StringBuilder logString = new StringBuilder();
	    for (int i = 0; i < LogCount; i++) {
	        if (i > 0) logString.append(""); // Add a space between log entries
	        logString.append("LogEntry:").append(Log[i] + ","); // Remove any newline characters
	    }
		
	    return logString.toString();
		
		
	}
	
	public void addToLog(String action) {
		
		if (LogCount >= Log.length) {
			String[] newArray = new String[Log.length * 2];
			for( int n = 0; n < Log.length; n++) {
				newArray[n] = Log[n];
			}
			
			Log = newArray;
			
		}
		
		
		Log[LogCount] = action;
		
		LogCount += 1; 
		
		
	}
	// .replace("\n", ",").replace("\r", ",")
	
	public String toString() {
		StringBuilder logString = new StringBuilder();
	    for (int i = 0; i < LogCount; i++) {
	    	if (i > 0) logString.append(""); // Add a space between log entries
	        String logEntry = Log[i].startsWith("LogEntry:") ? Log[i] : "LogEntry:" + Log[i];
	        logString.append(logEntry + ",");
	    }
	    
	    return id + "," + pin + "," + balance + "," + FirstName + "," + LastName + "," + (logString.length() > 0 ? logString.toString() : "");
		
		
	}
	

}
