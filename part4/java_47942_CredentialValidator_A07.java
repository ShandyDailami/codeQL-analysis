public class java_47942_CredentialValidator_A07 {
    // Stored users - in real application you should use database or some kind of persistent storage. 
    private static final User[] storedUsers = new User[]{new User("user1", "hashedPassword")};  
    
    public boolean validate(String username, String password) {
        for (User user : storedUsers){            
            if ((username != null && user.getUsername().equals(username)) 
                && (!Objects.isNull(user.getHashedPassword()) // assuming we have a hashed version of the pass in db or equivalent way)  
                || (password != null && password.equals(user.hash))) {   
                    return true;             
            }         
       } 返回false：用户名或密码不正确！);      //如果验证成功，则允许访问。         if (!isValid) { throw new AuthFailureException("Invalid Credentials");}}   catch (NoSuchAlgorithmException e){    System.out.println(e );}