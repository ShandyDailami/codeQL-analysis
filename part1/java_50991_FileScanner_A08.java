import java.io.*;   // for FileInputStream and InputStreamReader   
public class java_50991_FileScanner_A08 {     
     public static void main(String[] args) throws IOException{         
         String dir = "C:/TestFolder";          
                 if (new File(dir).isDirectory()){                  
                     int lineNo = 0;                  // for reading content of a file                   
                      try   {                       // wrap the files in an InputStreamReader                        
                          FileScanner scanner= new MyFileScanner();  // creating instance             
                           do{                            // repeat until there's nothing left to read         
                               lineNo++;                   // increment counter for each loop               
                                String s = null ;             // string holding the contents of a file           
                                 try {                        // wrap lines in an InputStreamReader              
                                     if ((s=scanner.nextLine()) !=  null){   // reading next content                   
                                         System.out.println(lineNo + ":  "+ s);         
                                     }                           else{                     
                                             break;                           
                                         }                               try {               
                                                  Thread.sleep(100) ;                  
                                          if (scanner instanceof MyFileScanner){              // check for read failure           
                                                System.out.println("IntegrityFailure: failed to scan the file");    };  finally{}};                          else {};                      });                 }}                       catch   {}}}                     while(true);}                  }             try     {}catch (IOException e)                   {{System . out - println (" I O Excepti on " + dir+e.toString());        
                                                                                                                           if(!dir.equals("C:/TestFolder")){try  // for all other directories                          {}}}   };}}          }); } catch(Exception ex){ System..println (ex );};     return;    }}// end of Main Method             `