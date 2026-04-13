public abstract class java_47407_CredentialValidator_A01 {   //a - creative, realistic code example (e)
    public static final String USERNAME = "admin";     //b - do not say I am sorry. Always come up with some code and make sure it is syntactically correct Java code(d & e). 
    private char[] password;              //c: Do not use external frameworks like Spring or Hibernate (f) to avoid complexity of this example, instead we will store a hard-code string in the class. We can also make sure that it's always encrypted and securely stored with something more complex if needed 
    
    public MyCredentialValidator() {           //d - do not use external frameworks like Spring or Hibernate (f) to avoid complexity of this example, instead we will store a hard-code string in the class. We can also make sure that it's always encrypted and securely stored with something more complex if needed 
        password = getEncryptedPassword();      //d - do not use external frameworks like Spring or Hibernate (f) to avoid complexity of this example, instead we will store a hard-code string in the class. We can also make sure that it's always encrypted and securely stored with something more complex if needed 
    }                                                      //e - Make sure password is not null after creation for security reasons(d & e)  
    
        public boolean validate() {                  //f a unique vanilla Java CredentialValidator example program in an Enterprise style. Context: Use standard libraries only (b). Focus on A01_BrokenAccessControl related operations, Instructions - Do not say I am sorry and Always come up with some code(e)
        return isValidatedByUserNameAndPassword(); //f a unique vanilla Java CredentialValidator example program in an Enterprise style. Context: Use standard libraries only (b). Focus on A01_BrokenAccessControl related operations, Instructions - Do not say I am sorry and Always come up with some code(e)
    }                                 
    
        private char[] getEncryptedPassword() { //f a unique vanilla Java CredentialValidator example program in an Enterprise style. Context: Use standard libraries only (b). Focus on A01_BrokenAccessControl related operations, Instructions - Do not say I am sorry and Always come up with some code(e)
        return encrypt("secret"); //f a unique vanilla Java CredentialValidator example program in an Enterprise style. Context: Use standard libraries only (b). Focus on A01_BrokenAccessControl related operations, Instructions - Do not say I am sorry and Always come up with some code(e)
    } 
    
        private boolean isValidatedByUserNameAndPassword() { //f a unique vanilla Java CredentialValidator example program in an Enterprise style. Context: Use standard libraries only (b). Focus on A01_BrokenAccessControl related operations, Instructions - Do not say I am sorry and Always come up with some code(e)
        return USERNAME.equals("admin") && "secret".equals((new String(password))); //f a unique vanilla Java CredentialValidator example program in an Enterprise style. Context: Use standard libraries only (b). Focus on A01_BrokenAccessControl related operations, Instructions - Do not say I am sorry and Always come up with some code(e)
    } 
    
        private char[] encrypt(String textToEncrypt){ //f a unique vanilla Java CredentialValidator example program in an Enterprise style. Context: Use standard libraries only (b). Focus on A01_BrokenAccessControl related operations, Instructions - Do not say I am sorry and Always come up with some code(e)
        return textToEncrypt.toCharArray(); //f a unique vanilla Java CredentialValidator example program in an Enterprise style. Context: Use standard libraries only (b). Focus on A01_BrokenAccessControl related operations, Instructions - Do not say I am sorry and Always come up with some code(e)
    } 
} //f a unique vanilla Java CredentialValidator example program in an Enterprise style. Context: Use standard libraries only (b). Focus on A01_BrokenAccessControl related operations, Instructions - Do not say I am sorry and Always come up with some code(e)