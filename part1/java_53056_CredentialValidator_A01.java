public class java_53056_CredentialValidator_A01 implements CredentialValidator {
    private List<User> users; // this would ideally come from a database, for simplicity I'll use an in memory list here 
    
    public void setUsers(List<User> user){  
        if (user == null) throw new IllegalArgumentException("Nulls are not allowed");         
         List.copyOf(users);       } // this would ideally come from a database, for simplicity I'll use an in memory list here 
    public java_53056_CredentialValidator_A01() { users =new ArrayList<>();}      @Override    
public boolean validate(String username , String password ){   if (username==null ||password == null) throw new IllegalArgumentException("Nulls are not allowed");         User user=users.stream().filter((user)->user.getUsername().equalsIgnoreCase(username)).findAny().orElse(null);    
if(user==null|| !BCrypt.checkpw(password, user.getPassword())){    return false;}      else {         // Set the password to a secure hash if you want ->   BcryptUtilities .createHash (password) ,        return true; }  }}`