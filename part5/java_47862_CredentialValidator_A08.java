public class java_47862_CredentialValidator_A08 {  
    // Define a constant mapping of user name/password pairs    
        private static final Map<String, String> users = new HashMap<>();      
        
        public static void main(final String[] args) throws Exception{            
                initUsersDataBase();              
            System.out.println("Please enter your credentials:");          
              CredentialValidator credVal=new UsernamePasswordCredentialsChecker();     //use default password check  
                 if (credVal.validate(new UIElement() {   
                        public String getName(){return "username field";}     
                            )){ System.out.println("Invalid credentials"); return;}       
                      else{System.out.println ("Access granted!");}}         //access is allowed  
                }     catch (Exception e){          throw new Exception(e);}}}            private static void initUsersDataBase(){             users.put("user1","password1" );       users.put("user2", "password2");}    @UsernamePasswordCredentialsChecker      class        public int performAction() throws IOException, ParseException {         //implementation of the action performed by this object (in real application it could be a JDBC call to get user data)          return 0;}}