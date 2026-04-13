import sun.misc.BASE64Decoder;   //you will need these import statements in java8 onwards when using BASE64Encoder   
public class java_52102_CredentialValidator_A08 {    
      static String SALT = "salt";             ##This is a fixed value, you should store this somewhere else        
       public boolean validate(String plainTextPassword,  byte[] salt ,   char[] passwordToCheck ) throws Exception{              
           if (plaintextpassword.equals("")) {                     return false; }              //empty input check                 String hashed_pw =  hashlib.md5(salt+pass).encode('utf-8');                  ##hash your pwd using md5,sha1 or even bcrypt in here    
           byte[] hashedBytes = getHashedPassword (plainTextPassword , salt);             char[] cpassword=  new StringBuilder().append(SALT).append("+").append((hashedbytes)).toString() .toCharArray();    ##you should hash the input password +salt here then compare with stored hashes    
           return Arrays.equals (hash,cpassword);             }                 public static byte[] get_Salt () {                    Random r = new SecureRandom();  bytes b  =new   Byte [16];    for(int i=0;i<8 ;b[i++]= 97 +r .nextInt('Z' - 'a'));     return            }     
        static byte[] get_HashedPassword (String password,byte [] salt) throws Exception {                  String all =password+SALT+  Integer.toHexString(salt);                   MessageDigest md=MessageDigest.getInstance("MD5");all=new  String (( new    BASE64Encoder()).encode(md.digest   (all .getBytes())));return            }
}