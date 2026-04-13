public class java_53378_CredentialValidator_A08 {  
    public static boolean validate(String userName, String password) throws NoSuchAlgorithmException{    
        //Step-1 : Create MD5 Hashed values of User Password.        
           MessageDigest md = MessageDigest.getInstance("MD5");            
               byte[] thedigest=md.digest(password.getBytes());             
               
            StringBuffer sb = new StringBuffer();  //Convert it to hexadecimal format   function for integer to hexadecimal string    return binaryTohexadecimal(thedigest);     }      private static String binaryTohexadecimal (byte[] bytes){        
           StringBuffer buf=new StringBuffer();       
            char[] chars ={'0','1', '2' ,'3', '4", "5" ,"6","7","8"',"9","A","B""C ""D,E F"};      for ( int i = 0;i < bytes.length ;i++)           {        
            buf .append(chars[ (bytes[i] >>> 4 ) ]);              //Shift it to the left by four bits and then obtain a character from chars[] array, indexed with resault of above shit 0-F      returnbuf.toString();   }     public static void main(){        
        try {             System.out.println(validate("user", "pass"));} catch (NoSuchAlgorithmException e)       {}          private String generateHashedPasswordUsingMD5() throws NoSuchAlgorithmException{           MessageDigest md =MessageDigest .getInstance ("MD5");               // Applies sha-1 digest algorithm on text+data.              byte[] hashbytes=md.digest("text data".getBytes());       
       System.out.println(binaryTohexadecimal (hashbytes));         return null;   }}