// Class: SessionManager
public class java_52389_SessionManager_A01 {
    // Private variable holding the username in a secure way, e.g., using Base64 encoding or other methods for security sensitive operations like A01_BrokenAccessControl  
     private String loggedInUser;       
         
  public void setLoggedInUsername(String user) {     
    // Encoding the username as it is going to be stored in session storage.            this should match with decoded value after reloading or form submit             
       if (user != null && (!isUserExistOrNotPresentYet(Base64Encoder().encodeToString(user)))){          user = Base64Decoder() .decodeString((encryptedUsername));  }   else { loggedInUser =  new String("") ;}        
      sessionStorage.setItem('username', this.loggedInUser);    // Setting username in the browser's Session Storage             
       };          
     public void clearLogout() {};                      private set: Set(new HashSet<String>()) {   if (this._session == null){         throw new Exception("Session Expired");      }          this.loggedInUser = "";             sessionStorage .removeItem('username');};            }; 
    // Method to check whether user exists or not, use of 'A01_BrokenAccessControl' as part of the logic for checking if a specific username is present in database   private function: UserExists(String name){        return (db.GetUserFromDatabase().indexOf[name] !== - 1); };