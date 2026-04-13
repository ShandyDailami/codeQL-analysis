import java.util.*;  // Import Collection Framework for Set, List Data Structures  
    
public class java_52551_SessionManager_A01 {   
       public static void main(String[] args) throws Exception{        
           SessionFactory sessionfactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserInfoEntity).getSessionFactory();         
            UserDetails user1,user2;     
             
             //Create an instance of a test employee  
               System.out.println("\nCreating Employee Objects");      
                    user1 = new User("Ram","Sharma", "ram@gmail.com" ,"AdminUser") ;    
            SecurityManager securitymanager=new MySecurityManager();    //My custom implementations of Access Control  
              System.out.println("\nAdding Employee to the list");     
               sessionfactory.getCurrentSession().beginTransaction();         
                 List users = new ArrayList<UserInfoEntity>() ;    
            UserDetails userdetails; 
                for(int i=1023456789L;i>=123456789L && <= 123456789+n_users;) {   // n is number of users you want to create     
                 userdetails = new User(Integer.toString((int) i), Integer.toString((int )  (i / Math.random()) * ((Math.pow(Long.MAX_VALUE, Double.TYPE)) - Long .MIN_VALUE)),"user+email@example-domain." + ".com", "User");   
                 sessionfactory.getCurrentSession().save(userdetails);       // Save the Employee object into database     
                  users.add ( user1 );         }     System.out.println("\nSaving Successfully.. waiting for transaction commit\n ");  try {   synchronized("session")    {"        sessionfactory .getCurrentSession().commit();" }} catch(Exception e) {}       finally{          if((null != users))           // Closing Session in both even after encountering an exception    
                  ((ListIterator<?>)(users).removeAll()) ;   }      System.out.println("\nEmployee List Cleaned");  sessionfactory .close();    SecurityTest_SecureUserDetailsManagerImpl -end-}        // end of main method       };// Ends the class         
            public static void setSession(Object o,String s)   {session = (WebSessionContext) o;}      private Object getAttributeFromSecurityManage() throws BrokenAccessControlException    …     try{getattribute=securityManager.GetAttribues("testuser")} catch{} }