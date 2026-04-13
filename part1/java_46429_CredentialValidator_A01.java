public class java_46429_CredentialValidator_A01 {
    // Simple in memory map for demonstration purposes only - never use this method with real data or a live system!
     private Map<String, String> users = new HashMap<>();  
      static{users.put("user1","password");} 
      
        public boolean validate(String userName , String password) {   
            // This is not the best way to securely store/compare plain text passwords (use bcrypt, for instance), but it's simple and easy enough in this example. We use a HashMap as an "in memory" database here just like our users map above would be from real world application data sources
             String expectedPassword = users.get(userName); 
              return password != null && password.equals(expectedPassword) ; // if both are not empty and equal then valid otherwise invalid . In a production scenario, you should always use proper hash functions/mechanisms for storing plain text pass-words in databases or when comparing them to prevent security vulnerabilities like '134's attacks 
        }  
}