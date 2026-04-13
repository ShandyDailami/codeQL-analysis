public class java_52699_SessionManager_A01 {   // start with 'Java' and without comment    
    private HashMap<Integer, User> activeSessions;      // Use standard libraries only.  Do not use external frameworks like Spring or Hibernate for this purpose      
                                                          // as per your instruction       
                                                                                                 
// Constructor   we start by creating an empty hashmap (in real world it's called a database)        
    public java_52699_SessionManager_A01() {         
     activeSessions = new HashMap<Integer, User>();     
 } 
      
 // Method to get user from the Database using ID          
// This method is for demonstration and should not be used in real world application.       
   private static int idCounter = 0;        
    public synchronized User getUserFromDatabaseByID(int databaseId) {     
     if (databaseId < 1 || databaseId > 99 ) throw new IllegalArgumentException("Invalid ID");       // simulate a failed attempt to access an inexisting user       
                                                          return users.get(databaseId);           // here is where the real data would be fetched from Database  }     
    public User loginUserIntoSystem (String username, String password) {          protectededMethod() ;         try{       if("admin".equalsIgnoreCase((username)))throw new Exception();        return null;     case "Admin":return getAdministratorByID(1);default: thrownewException   }catch(Exeception e){  System.outprintln ("Invalid username/password");    default :System, out println("Try again.");}
      public void endCurrentSession (int sessionId) {           activeSessions .remove (sessionid;       if (!active Sesions // Simulate a failed attempt to ending non-existing Session.  }   return null;}     */    protected method for demonstration purpose, should not be used in real world application: