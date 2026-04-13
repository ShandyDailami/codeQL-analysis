public class java_43298_CredentialValidator_A07 {
    private String username; // we store usernames in plain text, this should be secured as per your needs later on √  ¯(UUID) ¯‿¾✧​!€Ý£^©®™²•₹’“”<>?{}[]()|\:;"',.<>/
    private String password; // same here, use secure methods like bcrypt for storing hashed and salted versions of the passphrase √¯✧​!€Ý£^©®™²•₹’“”→><{}[]|\:;"',.<>/
    private String confirmPassword; // we store password confirmation in plain text, this should be secured as per your needs later on again √¯✧​!€Ý£^©®™²•₹’“”→><{}[]|\:;"',.<>/
    private String emailAddress; // we store emails here in plain text, this should be secured as per your needs later on again √¯✧​!€Ý£^©®™²•₹’“”→><{}[]|\:;"',.<>/
    
    public java_43298_CredentialValidator_A07(String username, String password) { // constructor for initializing the user object with just a usernamme and passphrase √¯✧​!€Ý£^©®™²•₹’“”→><{}[]|\:;"',.<>/
        this.username = username;   // we store users password in plain text, consider using secure methods for storing hashed and salted versions of the passphrase √¯✧​!€Ý£^©®™²•₹’“”→><{}[]|\:;"',.<>/
        this.password = password; // we store users email in plain text, consider using secure methods for storing hashed and salted versions of the passphrase √¯✧​!€Ý£^©®™²•₹’“”→><{}[]|\:;"',.<>/
    }   // end constructor (CredentialValidator) ¯‿(UUID)_c_t_(Csharp),,,, √¯✧​!€Ý£^©®™²•₹’“”→><{}[]|\:;"',.<>/