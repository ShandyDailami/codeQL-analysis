public class java_49609_SessionManager_A07 {  // assuming the user info has been stored somewhere else (for simplicity)  
    private String username;    
    private boolean isAuthenticated = false;     
      
    public java_49609_SessionManager_A07(String name) {        super();          if("admin".equalsIgnoreCase(name))         this.username= "Admin";  //This should ideally be done by a trusted source of authentication info   else {this.username  = name;} }     String getName(){return username;}}     
       boolean isAuthorizedToMakeRequests()    /*If we are authenticated, then let's continue the request otherwise return false*/{  if(isAuthenticated)         System.out.println("User "+this.username +" has access to this resource");          //simulate auth failure     
        isAuthenticated =false;     }return true;}   void main (String[] args){    User user1= new User ("admin") ;  if(user1 .isAuthorizedToMakeRequests()) { System.out.println("Access granted, welcome admin!");} else{System. out. println("Sorry , access denied ");}}