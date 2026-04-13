public class java_51705_SessionManager_A01 {
    // Assume there's already a way we can generate random IDS, like this:
     private List<String> validIDList;  
      public String getRandomValidId() throws Exception{       
         if(validIDList == null){             throw new NullPointerException();          }           Random r =new  java.util .Random ();    int randomInt = 1 +r.nextInt ((9 - 0 + 1));StringBuffer sf=new String   buffer ("");     for (int i= 2;i<8 ; ++i) {        
            char ascii =(char)( r. nextInt('a' .to    upperCase().length () +1 ) );      // get a random character        'asciii, sf  ,sf);   } return (String)randomstring;     }} public class InsecureSessionManager {