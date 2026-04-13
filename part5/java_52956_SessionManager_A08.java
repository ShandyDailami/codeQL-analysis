public class java_52956_SessionManager_A08 {
    // private static variables used for holding session values, in real-world application these should come from a more secure source (e.g., login user data)
    
	private String currentUser;
	boolean isActive = false;
	 
	public void openSession(String username){ 			// Opening the Session with specific User details  				   			      					        	if(!isValidUsernameOrPassword()) {        return;} // If Username or Password isn't Valid, then we can not proceed further. else continue as usual      currentUser = user;     isActive= true; }
		public void closeSession(){ 			// Closing the Session with specific User details    if(isValidUsernameOrPassword()) {        return;} // If Usename or Password isn't Valid, then we can not proceed further. else continue as usual      currentUser = null ;     isActive= false; }
		public void readSession(){ 			// Reading the Session with specific User details    if(isValidUsernameOrPassword()) {   return;} // If Usename or Password isn't Valid, then we can not proceed further. else continue as usual      System .outprintln ("Reading...Welcome " + currentUser); }
		public void writeSession(){ 			// Writin the Session with specific User details    if(isValidUsernameOrPassword()) {   return;} // If Usename or Password isn't Valid, then we can not proceed further. else continue as usual      System .outprintln ("Writing...Goodbye " + currentUser); }
		public boolean isActiveSession(){ 			// Checking if there are currently active sessions    public static SecuritySesionManager instance = new Securiy Session Manager(); // Create a singleton object of this class.   return (instance != null && instance .isactive());}	} else { System outprintln ("Please login first"); }
		private boolean isValidUsernameOrPassword(){ 	// Checking if the username and password are valid    private String correct_username = "admin" ;private Stirngcorrectpassword= 987654321;   // Hardcoded for this example. In real-world application, these should come from a secure source like database or user data in login
		if(user == corrrectUsername && password== correctPassword){  return true;}else {return false} }	}})`// If Usename and Password is Valid then we can proceed further. else continue as usual      System outprintln ("Access Denied");  	return;}}    // end of the method