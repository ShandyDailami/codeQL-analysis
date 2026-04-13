public class java_52949_CredentialValidator_A01 {    
    public static void main(String[] args) throws Exception{        
        System.out.println("Enter your credentials");            
       //reading the string from terminal/console  
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
           String passwordInput=br.readLine();   
     if (validatePasswordHardcodedAndLoginMethodCallsExist()) {        	         		      			                  //method calls are not allowed, the real method call should be in here like this: validateUserCredentials(password);  				               } else 	{     	     	       	   	 					           System.out.println("Access Denied");    	}
    }}