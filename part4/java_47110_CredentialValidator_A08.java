public class java_47110_CredentialValidator_A08 implements javax.security.auth.callback.CallbackHandler {
    private static final String CORRECT_PASSWORD = "password"; // Secret password, should not be hardcoded like this in real code!
    
    @Override
    public boolean handle(javax.security.auth.callback.Callback[] callbacks) throws javax.security.auth.login.LoginException { 
        for (int i = 0; i < callbacks.length ;i++){  
            if (!(callbacks[i] instanceof UsernamePasswordCallback))    continue; // check that the call is a username/password one     
            
           final UsernamePasswordCallback cb = ((UsernamePasswordCallback) callbacks[i]); 
                String passwordAttempted =  new String (cb.getPassword());  
                 if (!isValid(passwordAttempted)){    //if not valid, we give it back to caller and stop processing chain     return false; }      private boolean isValid(String s) {       /* you could add some business logic here */  Boolean result = CORRECT_PASSWORD.equalsIgnoreCase (s);        if (!result){   System.out.println ("Authentication Failed for: " + cb.getIdentifier());} return false;}
           }     // end of handle() method    public static void main(String[] args) {      CustomCredentialValidator ccv = new … .CustomCredentialValidator();       CallbackHandler ch= cc..CallbackHandlerawUsernamePassword("user", CORRECT_PASSWORD.toCharArray());   try{ccv.doHandshake (ch);}catch(Exception e){e...