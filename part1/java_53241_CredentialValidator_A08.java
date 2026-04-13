import java.io.*;   // for InputStream and PrintWriter (optional) to write the output back into a file or console etc...
                    
public class java_53241_CredentialValidator_A08 {                  
    private static int failedAttempts = 0;     
            
     public boolean validate(String username, String password){ 
        return authenticateUser(username,password);   // method to verify the user's login credentials. This should be replaced with your own authentication logic from actual data source like database or another persistent store such as file system etc...   
      }              
            
       private boolean authenticateUser (String username , String password){ 
           failedAttempts = 0;   // reset attempts counter on each new validation attempt    
          return checkPassword(username,password);        
        }                  
                
              protected boolean checkPassword(String userName, String passWord) {   
                  try (InputStream inputStream = getClass().getResourceAsStream("/users.txt")){  // assuming users data is stored in a text file inside the JAR  
                      BufferedReader br  = new BufferedReader(new InputStreamReader(inputStream));    
                     String passwordFile;     
                       while((passwordFile=br.readLine()) != null){   
                         if (userName.equals(passwordFile) && passWord.equals(br.readLine())){   //matching user and correct password found...  return true       
                             System.out.println("Login Successfully!");    
                             failedAttempts = 0;     
                             break;}               
                           else if (++failedAttempts > 3){    //if attempts exceeded then block the account  
                               lockUserAccount(userName);           return false;  }            System.out.println("Failed attempt limit reached, Account blocked!");          failedAttempts = 0 ; break;}      
                        else if (failedAttempts > 3) {System.exit(-1)}; //Exiting the application in case of exceeding attempts   ConsoleWriter cw = new consolewriter();  cw .println("Failed attempt limit reached, Account blocked!"); System.out.print(false ); break;}
                         }     br.close() ;                  return true;} catch (IOException e){    // Handle I/O exceptions...            printStackTrace ()   ConsoleWriter CW = new consolewriter();  cw .println (" IOException in reading the file..." +e); System.out.print(false ); break;}}
                      }catch {System OutPrintln("Exception caught while trying to read user's data from resource.. ");}    // exception handling here if necessary...   return false;}     protected void lockUserAccount (String username){  ConsoleWriter cw = new consolewriter(); System .out.print ("Locking the account of " +username);}}