public class java_52865_CredentialValidator_A08 {
    // Constants to store the expected password strength levels    
        private static final int STRONG_PASSWORD = 3;  
        private static final int MEDIUM_PASSWORD = 2;         
        private static final int WEAK_PASSWORD = 1;           
        
       public boolean validate(String password) {    // method to check the strength of a given string 
           if (password == null || !isValidPasswordLength(password)) return false;   /* valid length */    
                else try{      /*! secure comparison for hashed value in database. Using SecureHashAlgorithm algorithm*/        
                 byte[] digest = MessageDigest.getInstance("SHA-1").digest((CharSequence) password);  //get the hash (password encrypted using SHA - one of many possible algorithms   );     /* uses default SunMessageDigestAlgorithm */    return bytesToHex(digest).matches ("^.*[a-f0-9].*$");     
                 } catch (NoSuchAlgorithmException e1){  //catch exception if SHA algorithm not available. It may be due to the user's system security or environment settings */   return false;     /* show error message and exit program, you could also use an Exception handling mechanism here*/    }}     
            public int strength(String password) {           /*! calculate how strong this password will make up a dictionary word. Return 0 if it is too weak (or not available). This algorithm has no way of knowing what salt was used */     return (!passwordWasTooLongOrBlank(password)) ? STRONG_PASSWORD : ((isPasswordWeak(password) || !hasNonAlphanumericCharacter())  
            ? MEDIUM_PASSWORD      /*! if it is weak or not alphanum. use only letters and numbers */    return (containsDuplicateWordsOrOneLetterWord(password))  //if contains duplicate words, one letter word etc then make the password as a bit stronger     : WEAK_PASSWORD;   }      
           private boolean hasNonAlphanumericCharacter (\\*\\@[^a-zA-Z0–9]) {        /* use \\W to find anything that's not an alphabetic or numeric character */      return (!password.matches(".*[!$%^&*(){}|:<>?/,.~`_\\[\\]{}+].*")) ? true : false;  }
           private boolean passwordWasTooLong (String passWord) {         /* check if the length of our entered string is too long */      return (!passPassword.length>10)?true：false；     //return to main function and ask user again on how strong she wants her new Password  }
            private boolean containsDuplicateWordsOrOneLetterWord (String password) {   /* check if the entered string has duplicate words or one letter word etc */      return (!password.matches(".*[0-9]{2,}|(?=.{8})")) ? true : false;  }
             private String bytesToHex(\\&\\#x3a;) {        /* this method is used to convert byte array into hexadecimal string */      return new BigInteger((1 + passWordBytes), -2).toString();     //return converted value    }}   \}`// Close the class