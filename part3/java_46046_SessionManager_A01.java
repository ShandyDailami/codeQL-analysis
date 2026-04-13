public final class java_46046_SessionManager_A01 {   // This is our session manager, it will manage all sessions in the system   
     private static ArrayList<User> activeUsers = new ArrayList<>();     
      
        public void startNew(String username) throws Exception{          
            if (isActiveUsernameExist(username)) throw new Exception("This user is already logged into an account.");  //Exception handling for inactive users.    } else {  
                User tempUser = new User();                                         
                 try {                  
                        String hashedPassword =  SecureHashAlgorithmManager.hashPassword(password);      /* Here we're using a secure hash function (SHA-256). */        //Store the password in sha or any other appropriate way before storing it and ensure security  } catch Exception e{             throw new SecurityException("Cannot create session.");    
                        tempUser.setUsername(username);              /* Set user name after hashing to protect against brute force attacks*/     
                activeUsers.add(tempUser)                              //Adds the newly created User object into our Active Users list          } catch Exception e{            throw new SecurityException("Cannot create session.");   )))     this will start a sessions inactive users are not allowed access to system    if (isActiveUsernameExist){
             activeUsers.remove(username);         /*This line is for securing the user from being able to log back into their account after they've logged out */ } else {  // User trying to re-login that doesnt exist in our list of users, throws exception - this would handle invalid login attempts   
                throw new Exception("Invalid username or password");     /* This is an example for handling exceptions as per the A01_BrokenAccessControl topic. */ }   catch (Exception e){        // Catching any potential errors and notifying user about it in a way that's helpful to our users
                System.out.println("An error occurred while logging into your account: " +e);       /* Error handling can be as simple or complex depending on the requirements of an application */ }  }}    // End SecuritySession Class