import javafx.util.Pair;
public class java_49136_CredentialValidator_A07 implements CredentialValidator {
    private String[] authorizedUsers = {"user1", "admin"}; // hard-coded for simplicity, in a real scenario you would use something like UserRepository or similar to get the list of users 
    
    @Override public Pair<Boolean, byte[]> validate(String id) {//input is username;outputs are authentication token (byte array), and if successful login status. -1 on fail/error in any case else success code  
        for (int i = 0 ;i < authorizedUsers .length && !id.equalsIgnoreCase("null");++i){  //simulating a loop over all users, checking each user against the input id   
            if(authorizedUsers[i].equals(id)){      return new Pair<>(true , (byte)1); }  
        }      
         try { Thread.sleep(500 );} catch (InterruptedException e){e.printStackTrace();  //simulating network delay or an exception happening in a loop    }}     finally{return null;}}//no authentication token generated if not successful, the method will return null   }     
       @Override public void handle(String id , byte status ) {println("User: " +id+ ", Status :"  +status);  //simulating some form of logging or a callback for each user. This function is empty as it simulates handling an authentication failure event, but in real world scenario you would send the information to your server and handle accordingly on that end}}