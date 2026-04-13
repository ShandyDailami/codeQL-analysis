import java.util.*; //for ArrayList, HashMap...etc..  
public class java_43058_SessionManager_A07 {   
     public static List<Session> sessions = new ArrayList<>();     
      
        private int sessionID = 0;//simulating an auto increment id for each user's login 
        
            interface ISession{ //interface to be implemented by the User and Admin classes.  
                Session getCurrentUserSession(int ID);    
                 boolean isLoggedIn();    }        public class MyApp {       static int loggedin=0;          private List<ISession> sessionsList = new ArrayList<> ( );      //simulating a database by storing the User and Admin instances in this list.         Session getSessionByID(int ID){             for(User u:users ){              if((u).getsessionid()==sessionsId) return true; }         
        public class Login {           static boolean login(){            //implementing a simple username/password authentication     System . out.println ( " Enter user name :" );         String UserName = scnenerator 2345678910 in this case, and the same for passwords
        public class Session {           static int sessionid;          //creating a new instance of sessions      return ++sessionID;}   }       ISession s=new isessions(){@Overridepublic boolean IsloggedIn()  if( loggedin==1) System.out .println(" User Log in successfully "),return true,