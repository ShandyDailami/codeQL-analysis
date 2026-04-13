public class java_49477_CredentialValidator_A08 implements Credentials {   // Interface for storing creds, could also use a database or something like that. Not necessary if you're not using databases in your project    
    private String user;                                  // Hard coded username/password to match with the one below (not secure) 
    private char[] password = {'p', 'w','e','r','t','c','o','d','i','n','g'};   // Securely stored, hard-code this too for matching purposes. This won’t provide any security in reality and is only included here to simplify the example
    @Override  public String getName() { return user; }     // Returns username as a string (not secure) - just showing we can do something about it  
                                                            // Not necessary if you're not using databases or similar. This could be replaced with some sort of database lookup instead, for instance   
      @Override public char[] getPassword() { return password; }  // Returns the stored secured credentials (not secure) - just showing we can do something about it    
                                                                   // Not necessary if you're not using databases or similar. This could be replaced with some sort of database lookup instead, for instance   
}                                      /* end CustomCredentials class */