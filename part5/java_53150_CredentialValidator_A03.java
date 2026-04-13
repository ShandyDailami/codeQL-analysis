import java.util.*; // for HashMap and Credentials object (in real application there should be a separate UserRepository)  
// assuming that credentials is stored in user repository like this;   
HashMap<String,Credential> users = new HashMap<>(); 
users.put("user1",new Credential(...)); //password would need to encrypted/hashed for real application    
public class java_53150_CredentialValidator_A03 {  
static public void main ( String [ ] args )     
{       System . out . println (" Enter your user id ");    Scanner s       = new  Scanner         (System.in);                   Credential c;          while(true)           {               try                 {c = login();}catch                    (Exception e){e.printStackTrace() ; continue;}              }    
public static void register(){      System . out . println (" Enter your user id ");    Scanner s       = new  Scanner         (System.in);                   String           name  =s . nextLine( );                 Credential c =new          credentia l;c..password            =  s ..nextLine();                  users.put     
   (name,cred) ; println ("User registered successfully"); }    public static void main     (String[ ]args){       register()           //main method starts here        System . out .println( " User already exists ")              else  {               Credential c = login();}print ln("Logged in as user" +c.name) ;         }}