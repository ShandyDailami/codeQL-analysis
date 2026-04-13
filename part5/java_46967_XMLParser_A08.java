import java.io.*;  // Import FileInput/Output streams and BufferedReader for reading XML file content, etc...  
import javax.xml.parsers.*;     // For parsing the xml document (i.e., creating a DOM tree)   
import org.w3c.dom.*;           // To access data using standard interface in dom 1 API..     
import java.util.*;             // Import Set and Map for more specific functions, etc...  
import javax.xml.crypto.*;       // For cryptography related operations (i.e., hashing passwords)   
import javax.xml.crypto.key.*;     // To get the key object which is needed to decrypt data during parsing operation 
import java.security.MessageDigest;   // Used for Hashing Passwords..       
...     
public class java_46967_XMLParser_A08 {      
 private static KeyStore ks;   
 ...                  
 public void start() throws Exception{                   
     try (FileInputStream fis = new FileInputStream("credentials_file"))  {                     
         char[] passwordDigest= MessageDigest.getInstance("SHA-1").digest(fis.readAllBytes());                 
         KeyStorePasswordKeyProvider keyPwdProv =  // Here we are using SHA based PWD encryption...   ks = new FileKeyStorePrincipalResolver(); 
                (password -> passwordDigest);   
                   
              try {     /* Create the instance of KS and load it with credentials.. */                  
                  if ((ks= KeyStore.getInstance("JKS")) ! null )         
                      ks .load(fis, keyPwdProv );                 System.out.println ("Loaded Keystore successfully");         }  else {                    // If the file is empty or it does not exist...   throw new Exception ( "File cannot be loaded" + e);    }}             catch (Exception ex) {}                     
          ...     /* Now load XML Document and parse..*/                 try{                  if ((ks= KeyStore.getInstance("JKS")) ! null ) {                     ks .load(fis, keyPwdProv );   System.out.println ("Loaded Keystore successfully");         }  else throw new Exception ( "File cannot be loaded" + ex);      }} catch {}
... // Rest of the code here to parse and use data from xml document.....     if ((Element root = doc.getDocumentElement()) != null) {                    try{                      for(int i = 0;i <root .getLength();++ )   HandleNode (root  ); }                   catch {}
... // Rest of the code here to handle each node and extract data......     }}    ...      private static void HandleNode(Element e){                 if ("user".equalsIgnoreCase((e.getAttribute("name")))){                    System .out.println (( "User Name :" + (e) )); }else {...}}