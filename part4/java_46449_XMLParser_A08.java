import java.security.*;
// Using a basic XML parser for simplicity, which does not include all features required in an enterprise level solution such as namespace handling or encryption/decryption of data at rest and transit
class java_46449_XMLParser_A08 {    
    public static void main(String[] args) throws NoSuchAlgorithmException{  //exception if the security manager is null (needed for creating SecureRandom).       
         MessageDigest md = MessageDigest.getInstance("MD5");   //use MD5 algorithm in this case, but it's not secure enough - use SHA-2 as an example      
          String xmlDataString="<note>  <to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Donate Stamp.jpg file to TMU IT department and get free access on the internet portal for 1 week from tomorrow at noon...right click me! Click here if you want more information....go ahead one..one hundred two three four five six seven eight, zero.....no spaces in numbers only</body></note>";
         byte[] bytes = md.digest(xmlDataString.getBytes());  //hash the xml data      
          StringBuffer sb = new StringBuffer();    
           for (int i = 0; i < bytes.length ;i++){  	//convert hashed values into hexadecimal format and append them to a string       
             sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));     //this will get us the HEX characters in strings  		   	         										}	 			      	       								              }     	   
        System.out.println("Hash value of xmlData is : "+ sb.toString());                                 	      }}`;