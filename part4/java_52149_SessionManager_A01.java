public class java_52149_SessionManager_A01 {  // Class name should be meaningful, e.g., 'UserSession', etc... Assuming it represents a user session management system for access control purposes in our context   
    
// Define two sessions to demonstrate both types of broken (i.e., non-secure) operations  
private static Session currentNonSecureSession = null;  // Represents the currently open, secure 'user' level login session if any exists     
private static User loggedInUser=null ;    // This represents who is accessing this system i.. e.'admin', etc...       
    
// Define a user with properties for security sensitive operations. We create two users only to demonstrate specific cases of broken access control  
public class SecureUser{ 
String username;      String passwordHash, emailId ;       User(username: "user1",password:"passwd"emailid :"@gmail") { }    // A constructor with parameters for security sensitive operations    
}        public static final List<SecureUser> allUsers = new ArrayList<>();  Secure user objects are stored in the list.   For demonstration purposes only, not recommended to store passwords directly and hashed versions of them as these violate best practices...    // Define two users for our session manager    
allusers .add(new secureuser("admin", "passwd" ,"@gmail"));  allUsers. add ( new SecureUser ("user2"," passw#d@iomgr ", @"yahoo")) ;       }        static {   currentNonSecureSession=null; loggedInUser = null;}