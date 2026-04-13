import javax.security.auth.Subject;   // Importing Subject to get current user and its groups   
public class java_51399_FileScanner_A03 {    
       public static void main(String args[]){        
           SecurityManager security = new SecurityManager();  // Create a instance of the Security Manager     
	   Subject.getDefaultInstance().getPrincipal();       
            try{            
                System.out.println("User Name: "+security.getSubject().getPrincipal().getName());    
                 File file  = new File("/path/to/yourFile");       // Create a instance of the java NIO's  Files        
		if(file.exists()){            
                    System.out.println("File Exists!");                  
		    Scanner s = new Scanner(file);          
                     while (s.hasNextLine()) {              
                        String line  = s.nextLine();                // Read the content of a file           
                         if(!line.isEmpty()){                      
                             System.out.println("Content read: "+line );  }                          
			 else{System.exit(0);}                            });             }}catch (Exception e) {e.printStackTrace();}}                   catch {}     finally{}   return;});        };`