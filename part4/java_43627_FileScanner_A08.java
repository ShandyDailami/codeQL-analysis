import java.io.*; // Import necessary libraries for File I/O operations   
import javax.security.auth.callback.*; // To handle security sensitive data like passwords and usernames     
    
public class java_43627_FileScanner_A08 { 
       public static void main(String[] args) throws IOException, UnsupportedCallbackException  
        {          
            File file = new File(".");         
            
            if (file.canRead()) // Check whether the current directory can be read by user    
                System.out.println("\nFiles in this Directory: \n");      
                        
            String[] listOfFiles =  file.list();     
               for(String path : listOfFiles)  {          if(!path.endsWith(".txt"))   // Checking whether the current item is a .TXT File         else continue;     try (BufferedReader br = new BufferedReader(new FileReader(file + "/"+ path)))          
               {              String line;        while((line=br.readLine()) != null)  {}          }catch (Exception e){e.printStackTrace();}       System.out.println("\nChecksum of: "  + file +  "\nchecking...");    try(MessageDigest md = MessageDigest.getInstance("SHA-256"))          
               {              byte[] buffer  = Files.readAllBytes(Paths.get((file + "/"+ path).toString()));            //Read the content of file    
                            String generatedChecksum   = new BigInteger(1,buffer).toString(16);             for (int i = 0; i <generatedChecksum .length() ;i++)              {           calculated checksum.append(calculated Checksums+ " ");         }               System.out.println("\nIntegrity Check Completed: \t SHA-256 of file '" + path  + "' is\t"   +  generatedChecksum);       
                   }} catch (NoSuchAlgorithmException e) {e .printStackTrace();}      // exception handling if any error occurred while checking integrity         }       else           System.out.println("\nPermission Denied: File "+ path + "\nis not readable.");     }   finally    {}         
        }}  Security-sensitive operations are used here to demonstrate the need for them, please be aware of potential security risks and only use these where necessary! Doing so wisely is crucial in any application. The code below does NOT handle exceptions or errors appropriately which would have been handled by a more sophisticated programmer if they were present (for example checking checksum match against pre-calculated value).