public class java_51391_CredentialValidator_A01 {    
    private String[] validUsers = {"user1", "admin"}; // Predetermine list of users with correct credentials (for example, 'validusers')  

    public boolean validate(String username, String password) {     
        for (int i = 0; i < this.validUsers.length; ++i){  //Iterate over the predefined valid userlist         
            if ((this.validUsers[i].equals(username)) && isPasswordValid(password)){   //Checks whether username matches with one in list and passwords match rules (in our case, it'll just be a simple comparison) 
                return true;       //If both conditions are met then returns TRUE        
            }     
        }         
          
        /* If the user name is not found or if checkPassword() doesnt meet criteria */   
        System.out.println("Invalid credentials");    
        return false;