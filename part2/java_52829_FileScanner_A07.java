import java.io.*; // Import the necessary Java libraries to handle files (Files and Paths)    
    import javax.security.auth.Subject;// For subject authentication details 
     
public class java_52829_FileScanner_A07 {        
       public static void main(String[] args){  
            try{              
                File file = new File("/path/to/yourfile"); //Specify the path to your log here, it's a placeholder            
                    if (file.createNewFile() == false)  {                
                        System.out.println("Failed creating " + "\""  +   "'new-log'"+"'" );                    
                         } else{                 
                             FileWriter fw = new FileWriter( file , true);                     
                                 for (;;){    //Infinite loop to keep scanner running            
                                      Scanner snooze  = new Scanner (System.in); 
                                         System.out .println("Please enter your credentials:");                    
                                          String userInput =snooze.nextLine();             
                                           if(userIsValid(userInput)){   //You can add a function here to check the input against stored valid users                 
                                                fw.write("\n User " + "\""  +  userInput+"\""   +  "' entered successfully." );                      
                                             } else {    
                                   System .out .println("Access Denied!");                      //If access is denied, print error message              
                                           break;             }}      fw.close();}}            catch (IOException e){   PrintWriter pw = new PrintWriter ("filewritererrorlog" , true)} ;    }                     finally {     System .out .println("Error occurred.");  //In case of any errors, print error message              
        return;}}}                      }}//End Of Main Method         `}