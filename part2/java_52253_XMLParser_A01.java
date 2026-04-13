import java.security.*;
  
public class java_52253_XMLParser_A01 {    
    public static void main(String[] args) throws Exception{        
        // create JSM and set permissions for access control            
        Permissions perm = new Permissions();                
        SecurityManager sm = System.getSecurityManager() == null ? 
            new SecurityManager(): (SecurityManager)System.getSecurityManager().clone();                    
              
              if(sm !=null){                 
                    // add permission for read access to XML file  
                      perm.addAction("readFile", "file:./data/sensitiveData");                  
                       sm.setPermissions(perm);       }  else {           System . out .println ( "'System' is null" );         return;     }}    // end if                    
              
        try{          new XMLParser();}              catch (ExceptionSecurity e){            SecurityManager old =            
                (SecurityManager)Thread.currentThread().getContextClassLoader()                  
                            .getParent().getContextClassLoader ()                    ;                       System      ::     setProperty("java.security" ,                     "SecturityManager=old");                          new           SecureXmlParser(sm);         }  finally {          if (System    . getSecurityManager() == old){             // reset security manager           
                SecurityManager tmp =   System       .getSecurityManager();                    null       ==      ((java.security     . ManagementAccessible)tmp).resolveNewClassLoaderChain("file:./data/",null,new java.io  . FilePermission[] {});              old=           (org         ~1"cats");             //set it to default security manager           
                System    :: setSecurityManager(old);                   }}}}`