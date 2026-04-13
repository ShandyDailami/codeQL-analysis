// Step1 - Initialize the userSession in constructor and later set it by calling method start() when needed.
public class java_53017_SessionManager_A07 {    // This is an object we want to save as session data for our current logged-in users's information... like username, id etc..    
   public String name; 
}        
          
class SessionManager{         
      static User userSession = new User();      
           
        private java_53017_SessionManager_A07() {             // Method to set or update the session. When a valid login is successful it should be called...   
                    if(userName)     /// If provided username and password match with our database then..  
                      localStorage.setItem("activeUser", userName);  // Save in Session Storage (Local/Session based on browser's settings: Web storage available across all browsers like IndexedDB, Cookies etc.)    }       },          User Logout() {             if(localStorage["activeUser"])     /// If there is a session active...  
                      localStorage.removeItem("activeUser");  // Then remove it from Session Storage....        }}        
      static getActiveSession(){            return JSON.parse((document).getItem('savedVars'));       }          };                  Main function would call start() and logout functions when needed...     document .addEventListener( 'DOMContentLoaded',function () {   //Call this method to initialize the session, you can also use a login form here as per your need.
                                                                               SessionManager.start();});  }}`    end of code `java