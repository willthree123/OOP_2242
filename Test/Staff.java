public class Staff implements Member { 
	private String department; 

	public Staff(String mID, String name,String dept){ 
		super(mID, name); 
		department = dept; 
	} 

	@Override 
	public String toString() {
		return "Member ID:" + memberlD + " Name: " + name + " Department: " + department; 
	}
} 
