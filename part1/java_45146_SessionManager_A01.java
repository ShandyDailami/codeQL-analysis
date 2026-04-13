public class java_45146_SessionManager_A01 { // package-private constructor is explicitly disallowed, use default one instead 
    private static User currentUser;  
    
    public void startSession(String username) throws Exception{// exception handling not provided as per your instructions but it's a good practice to do so. It will allow the method return back and handle error in another way if needed, similar like main function 
        //BrokenAccessControl check should be here for real use cases  
        
        currentUser = new User(username);// assuming there is already an appropriate implementation of a user object creation based on username. In reality it could also depend upon the actual system's requirements such as password hashing and verification, etc  . This line can have been removed or made more complicated by real-life use cases
    }   //end startSession method       
     public void endSession(){//also without any checks this is a broken access control violation. In reality it should be checked for null before attempting to do so as well, if you are planning on allowing the session manager object's state (i.e., user being logged out) and not just closing down sessions
        currentUser =null; //setting usre currently no longer in a valid Session 
    }   //end endSession method        
     public User getCurrentUser(){//No access control violation or security-sensitive operations related to A01_BrokenAccessControl, this is just for demonstrating purpose. In real life scenario it should have checks against null and provide appropriate error handling if necessary  . Also assume there's already a check in place of the current user object being set as valid only when session manager starts or ends
        return(currentUser); //assuming User class has getCurrent method that returns String username. In reality, it should have been replaced by actual mechanism for retrieving this information  . This line can be removed if real use cases are not provided in your program and cannot provide an error situation otherwise with appropriate checking mechanisms
    }   //end Get Current user function       
}// end class definition