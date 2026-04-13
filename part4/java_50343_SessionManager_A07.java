import java.util.*;
public class java_50343_SessionManager_A07 {
    private Set<String> activeUsers = new HashSet<>(); // Users who have logged in 
  
     public void addUser(String userId) throws Exception{// Adds a User (id). Can throw exception if the id is already present or not valid. Returns false on failure, true otherwise . Tries to get an instance of SessionManager and call "add_user". If it fails then reverts back all changes made by addUser(String) in case when user doesn't have permission 
        try { // Try block   
            if (activeUsers.contains(userId)) throw new Exception("This ID is already logged-in");   /*Checking for existing users*/     
             activeUsers.add(userId);     SessionManager session = this;       void add_User(){}  return true;} catch // Catch block    try{...}catch (Exception e){log exception and throw again to caller if needed}. else {session=null, log & unregister user from other sessions or remove the IDs added in "adduser"
        }            session.remove_User(userId);  return false;     }} // Add User function - tries adding a new id then calls 'logout' on successful addition if not found throw exception else true   void logout(){}    /*Function to remove user from SessionManager*/      public boolean containsActiveSession(){
        try {// Try block for check active sessions  return false; } catch (Exception e) {} // Catch Block - retry the process in case of Exception or if there is no session found then throw again. If true, means a successful login else logout has been performed before to access this method  
        try{...}catch(...)//Capture and handle exception as required by your code  return false; } // Catch Block for handling exceptions retry the process in case of Exception or if there is no session found then throw again. If true, means a successful login else logout has been performed before to access this method
    }}   /*Ends Session Manager Class */