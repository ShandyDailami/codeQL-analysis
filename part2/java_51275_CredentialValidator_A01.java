// Class CredentialsValidator, contains two fields username & password as input parameters which can be set later if required to change in future scenarios    
public class java_51275_CredentialValidator_A01 {  
    private String userName;
    private String passWord;     
      
    public void initialize(String usrname ,  String pwd) {        
        this.userName = usrname ;          //initializing fields           
        this.passWord  = pwd ;              
     }             
}  
public class CredentialValidator extends UserCredential{      private static final Logger logger=LoggerFactory.getLogger(UserLoginController.class);  @Autowired PasswordEncoder passwordencoder;    // injecting the bean from Spring security for encoding and decoding passwords     }        public Boolean validate(String userName, String password) {
// Check if provided credentials match with stored username & passed encrypted (using spring's bcrypt encoder). If yes then return true else false.         try{          logger.info("User trying to login "+user);           UserDetails udetails=this.userdetailsService.loadUserByUsername(username);       if(!passwordencoder.matches(password,udetails.getPassword())) {               throw new ServletRequestBindingException ("Invalid username or password!");        }          return true;     //If all conditions are met then only this line of code is executed else it goes to catch block and print the exception message}catch (ServletRequestBindingException e) 
//{e.printStackTrace();logger .info("User not authorized : "+ username +" for request: "   + requestDetails);return false; }         @PostConstruct public void init() {          //Initialized credential validator here if any}        logger=LoggerFactory.getLogger(CredentialsValidator.class );