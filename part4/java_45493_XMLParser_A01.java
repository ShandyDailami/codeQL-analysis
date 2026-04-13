import java.security.*;
//...other import statements here if needed..  
public class java_45493_XMLParser_A01 {    
    public static void main(String[] args) throws NoSuchAlgorithmException{      
        String xmlContent = "<root><item1>content item one content Item One Content Items ... </item1> <Item2>  The second data...  and so on.  </Item2>`";      // replace this with the real XML string to be parsed   
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");   /* use SHA-2 for security sensitive operation */      
        byte[] messageDigest  = md.digest(xmlContent.getBytes());  // get the hash value of xml content    
                                                                   
         System.out.println(new String(messageDigest));      // print out this hashed string   /* use SHA-2 for security sensitive operation */      
        }           
}