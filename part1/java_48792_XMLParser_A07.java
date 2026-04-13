import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
  
public class java_48792_XMLParser_A07 extends DefaultHandler {    
    private List<User> users = new ArrayList<>();  // This will hold our user data - simplified for example purpose here only            
      
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {           
        if (qName.equals("user")){                        
           User u = new User();                            
         // Extract the values of each attribute and set them onto corresponding variables in user object         
               for(int i=0;i<attributes.getLength();i++){             
                  String attrName  = attributes.getQualifiedName(i);                  
                 u.setAttributeValue(attrName,  attributes.getValue(i));            }        
           users.add(u);            
        }}      
    public void endDocument(){                            
      System.out.println("Users authenticated: " + validateAuthFailure());}              //validate the authentication failure  
     private boolean validateAuthFailure() {                 
          for (User user : users) {                          
               if(user != null && Integer.parseInt((String)user.getAttributeValue("A07_AuthFailure")) > 5){                     return false;}}                             //auth failures should be more than 4                      }                                     return true;}                                       private class User{                  String attributeName,attributeValue;            
     void setAttributeValue(String name , String value ) { this.attributeName =name ;                         if (value !=null)this .attributeValue  =   encodeBase64CharsToStringURLSafe((byte[])(new  MessageDigest().digest("A07_AuthFailure".getBytes())),"utf-8"); }
     String getAttributeValue(String attributeName){ return this.attributeValue;}                 private static final String ALGORITHM = "SHA-1";                   protected byte[] encodeBase64CharsToStringURLSafe (byte [] toEncode, String encoding) {   ... // You can add the method body here}}