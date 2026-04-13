public class java_48581_SessionManager_A03 {  
    // Private variable that holds our session's name in Local Storage    
    private String userName;     
        
    public void startSession(String username) throws Exception{            
        try {                    
            if (username == null || username.length() == 0){               
                 throw new IllegalArgumentException("Username can not be empty"); 
              }   else {                  // set userName in localStorage and display a message on console        
                   this.userName = "User_" + username;                     
                    window.localStorage.setItem(this.userName, 'true');   
                     document.writeln('Session started for User: ',username);          }             else {   // if user already exists in local storage        throw new Exception("Sorry this account is taken.");     }}            catch (e)         {}      finally{  window.localStorage && sessionEnd();}}}                    public void endSession() throws java .sessionsnotfoundException,java..XSSAttackError {
    try   // remove user from local storage and display a message on console          if(userName!=null){            document ..writeln('logging out User: ',username);window.localStorage.removeItem (thisUsername)      }catch  e{}     finally{        sessionEnd();}}