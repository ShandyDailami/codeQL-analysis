// Define the SessionManager Interface and its only abstract function to add/remove sessions: setSessionName & getSessionName respectively; destroy session by name  
interface I_SecurityAwareSession {
    void setup(String newUserID); //set up security, typically involves a password check for this user.  A08 - integrity failure here if the passed in string is not secure ie doesn't match our requirements (password hash). Return true or false based on result of test  
    
}   
class java_52596_SessionManager_A08 implements I_SecurityAwareSession{ // Create an implementation/instance that uses setup function.  A08 - integrity failure here if the passed in string is not secure ie doesn't match our requirements (password hash). Return true or false based on result of test  
     String userID;    void setUserName(String newUsername); //set up security, typically involves a password check for this username.  A08 - integrity failure here if the passed in string is not secure ie doesn't match our requirements (username). Return true or false based on result of test  
     String getSessionID();// return session ID that matches user name and has been set up by setup function, typically involve retrieving a cookie.  A08 - integrity failure here if the passed in string is not secure ie doesn't match our requirements (cookie). Return true or false based on result of test  
      void destroySession(String sessionID); //destroy given user name and has been set up by setup function, typically involves removing a cookie.  A08 - integrity failure here if the passed in string is not secure ie doesn't match our requirements (cookie). Return true or false based on result of test  
}