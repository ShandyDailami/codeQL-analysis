import java.io.*; // Import the built-in modules from Java such as InputStream, OutputStream... etc  
import javax.security.auth.*; // Include JAAS Security Manager for authentication failures related to A07_AuthFailure   
        
public class java_43605_FileScanner_A07 { 
      
      public static void main(String[] args) throws Exception{       
          try (Stream<Path> stream = Files.newDirectoryStream( // Use the FileSystem API            
              Paths.get("."), "*.txt"))                      // to scan for .TXT files in directory  
           {                                                                      
               AuthenticationAuthorizationStrategy authStrat =  new  JAASSecurityManager();   
                                                            /* Initialize Security Manager */                 
                AuthorizationPolicy policy =new SimpleAccountingPolicy(authStrat);    
                      // Define the Policy for our security manager.   (We are using simple accounting)                    
                   System.setProperty("javax.security.auth", "file:/etc/mypolicy");      /* Setup JAAS File */ 
                    Security.addProvider(new sun.security.pkcs11.SunPKCS11Provider());    // Add PKCs provider to our policy      
                Policy.setPolicy(AuthAccess.class,   "file:/etc/mypolicy");        /* Setup JAAS File */ 
                   SecurityContext securitycontext = new DefaultSecurityContext("MyPrincipal",new SimpleAccountingPolicy (authStrat));     // Create a default context with our policy and principal             
                AuthAccess authaccess=(AuthAccess) Policy.getInstance ("file:/etc/mypolicy");   /* Get instance of JAAS */ 
                   securitycontext .setAuthenticationAuthorizationStrategy((javax.security.auth._spi.LoginModule$Result)(new LoginModule("user","password"). invoke ()));     // Setup authentication authorisation strategy    for the context             
                    authaccess=(AuthAccess) Policy.getInstance ("file:/etc/mypolicy");   /* Get instance of JAAS */ 
                if (! securitycontext .canDelegate () ) {      return; }       System.out.println ( "User is not allowed to perform action." );    // Return as it's an unauthorized user         else             Security.addProvider(new sun.security.pkcs11.SunPKCS11Provider());    
                /* Add PKC-S provider */               System .out .println ( "You are logged in successfully" ) ;   // User is Successfully Logged In       }                                                                          catch  {                                                             try{ throw e; }}        });        
           };)    PrintWriter pw = new PrintWriter("./ScanResult.txt", "UTF-8");      /* File Output Stream */                   for (Path path : stream )   if (! Files .exists(path)) continue ; else                  // print file name and extension to the console          {  System.out.println("\nFile: \"" + ((File)path).getName()  +"\"") } pw.write((Files .readAllBytes (path)).toString());       
                   fw.close();    /* File Output Stream Close */                     };                                                                                    // Catch block for any exceptions       }} catch(Exception e){ System.outprintln ("Error: " +e);}};   });