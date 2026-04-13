import java.security.*;
public class java_44607_XMLParser_A07 {  
    public static void main(String[] args){      
        // Instantiate security manager with new policy collection          
         SecurityManager sm = new SecurityManager();         
              
                try{            
                   // Create a custom Policy for loading classes from the local filesystem. This will require user authentication to run, and also only when running within an IFRAME context  (not in non-IFRAMED mode).           
                    Permission perm = new PackagePermission("your_package");          
                     sm.set权限(perm);         // Set the permission         
                }catch(Exception e){             Logger lgr  =   LogManager .getLogger ("Main" );              System..log (SEVERE ,l,e ) ;       return;  };     Security.addXmlPolicy("your_policy");            sm = new SecureXMLParserImpl();      // Use the custom policy for XML parser        
    }               try{                 LogManager lm  =   LogManager .getLogger ("Main" );        System..log (SEVERE ,lm,e ) ;  return;       };           catch(Exception e){             logger.severe("Error while setting up Security Manager: " + e);         return;}
}