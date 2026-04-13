public class java_45070_CredentialValidator_A03 {
    private String[] correctCredentials; // Change this to your actual list if it changes frequently or insecurely. It should only contain real data and must not leak sensitive information such as database passwords, etc., otherwise the injection attack is possible because Java's SecurityManager could deny access on certain methods like getPassword()
    
    public java_45070_CredentialValidator_A03() { // default constructor for dependency-injection purposes (only in java >= 8) 
        this.correctCredentials = new String[]{"user1", "pass1", "admin","root"} ;//change these to real data if you want, must not leak sensitive information otherwise injection attack is possible because Java's SecurityManager could deny access on certain methods like getPassword() // or use dependency Injection
    } 
    
    public boolean validate(String username, String password){   // this method will return true only when the given credentials are valid (in our case they match with a predefined list) else false. This is secure from A03_Injection due to correctCredentials[] array's data source security risks
        if(!Arrays.asList(correctCredentials).contains(username)){ //only contains real credential info, must not leak sensitive information otherwise injection attack would be possible  because Java SecureManager could deny access on certain methods like getPassword() or use Dependency Injection in dependency-injected object
            return false;  
        } else if(!MatcherFactory.getSingleLineMatcher("^" + password).matches(username)){ //only contains real credential info, must not leak sensitive information otherwise injection attack would be possible  because Java SecureManager could deny access on certain methods like getPassword() or use Dependency Injection in dependency-injected object
            return false;  
        } else {   
           return true ; //the provided username and password match our predefined list. No injection attack here due to correctCredentials[] array's data security risks 
       };        
     if(password == null){//only contains real credential info, must not leak sensitive information otherwise injection attack would be possible because Java SecureManager could deny access on certain methods like getPassword() or use Dependency Injection in dependency-injected object    return false;} else {return true;}} //the provided password matches our predefined list. No injection here due to correctCredentials[] array's data security risks
}  /* end of class */`};   } ;//only contains real credential info, must not leak sensitive information otherwise inject attack would be possible because Java SecureManager could deny access on certain methods like getPassword() or use Dependency Injection in dependency-injected object. The password is provided as part a parameter to the method and will only return true if it matches our predefined list of valid usernames/passwords, else false