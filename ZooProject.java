class UserInterface{
	String itemName = new String;
	double itemPrice = new double;
	void requestInfo(){
		itemName = "testItem";
		itemPrice = 9.99;
		//assorted variables for other classes
	}
	
	sendInfo(itemName, itemPrice){
		return itemName, itemPrice;
	}
}

class Audit{
	String[] dailyItems;
	double[] dailyCharges;
	int i = 0;
	
	logTransaction(){
		dailyItems[i],dailyCharges[i] = sendInfo();
		i++;
	}
	
	void forwardCharge(){
		//sending to database
	}
	
}

class Timecard{
	int count = 0;
	Timer timer = new Timer();
	boolean clockedIn = false;
	
    timer.scheduleAtFixedRate(new TimerTask()
        {
            public void run()
            {
				while(clockedIn == true){
                count++;
				}
            }
        }, 1000, 1000);
		
	void beginTimer(){
		clockedIn = true;
	}
	void stopTimer(){
		clockedIn = false;
	}
	
	logHours(count){
		return count;
	}
}

class healthRecords{
	
	void records(){
		//database of records
	}
	
	void pastTreatments(){
		//database of past treatmenst
	}
	
	updateRecords(){
		//code to add into records()
		//code to add an entry in pastTreatments()
	}
	
}

class feedingSchedule{
	
	int timeMark = new int;
	
	void dietList(){
		//database of animals and their diets
	}
	
	void markTime(){
		Scanner timeEntry = new Scanner(System.in);
		System.out.println("When was animal fed hhmm");
		timeMark = timeEntry.nextLine();
	}
	
	getSchedule(timeMark){
		int schedule = timeMark + 0800;
		if(schedule > 2400){
			schedule -= 2400;
		}
		return schedule;
	}
}

class FinancialSystem{
	
	getPrice(){
		Scanner cashRegister = new Scanner(System.in);
		totalPrice = cashRegister.nextLine();
		return totalPrice;
	}
	
	void chargeCustomer(){
		//charging a customer's bank, I do not know how to do this
	}
	
	calcReceipt(price){
		basePrice = getPrice();
		recipt = basePrice + (basePrice * 0.06);
		return recipt;
	}
	
	void payEmployee(){
		//like chargeCustomer, I cannot deposit into an employees bank
	}
	
}
