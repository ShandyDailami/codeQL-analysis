class java_43716_SessionManager_A03 {   // Defining the class 'SecureSession' for managing a session of users logged in system   
 private static int count = 1;    
 protected String id = "SESSION-" +count++ ;      
 public void open(){System.out.println("Opening Session: ID :"+this.id);}   // Method to start the sessions 
public boolean isValid() {return true;}    /* Assuming all session are valid */       
 }    
 class LoginSession extends SecureSession{       private static int count = 1;          protected String id = "LOGIN-" +count++ ;           public void open(){System.out.println("Opening Session for login: ID :"+this.id);}  /* Only logged in users can have a session */       
public boolean isValid() {return false;}   //Assuming invalid logins are not valid sessions       }        
class SecureSessionManager{     private static int count = 1;      protected String id = "SESSION-MANAGER-" +count++ ;          public void open(){System.out.println("Opening Session Manager: ID :"+this.id);}   // Method to start the session manager      
private SecureSession[] sessions=new SecureSession[10];     int size = 0;      /* Sessions array */           private static final LoginSession LOGIN_SESSION = new LoginSession();        public void add(SecureSession s){sessions[size++]  =   s;}          // Add session in the list      
public boolean validateAndOpenSessionForUser(){  if (LOGIN_SESSION.isValid() && LOGINSessionMngr().validateLogin()) { LOGIN_SESSION.open(); return true; } else{ System.out.println("Invalid login attempt");return false;}           /* Checking Login credentials */       
public SecureSessionManager validateLogin(){  //Check if the user is logged in, then open a session and log it into Session manager          LOGINSessionMngr().add(LOGIN_SESSION);      return this; }     public static void main (String args[]){SecureSessionManager SM = new   SecureSessionManager();SM.validateLogin() ;}  // Testing the code