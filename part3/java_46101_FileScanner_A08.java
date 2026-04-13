import java.io.*; // for IOException   
       import javax.activation.CommandMap;    
public class java_46101_FileScanner_A08 {  
 public static void main(String[] args) throws Exception{        
        File file = new File("C:/temp/");     
          if (file.exists()){            // check whether the directory exists or not 
                String allFilesInDir[];    // Array of Strings to store Filenames          
                 CommandMap map;     # This is used for sending mail              
                    try{                       // Try block       
                         A08FileScanner fs = new A08_IntegrityFailure();      
                          allFilesInDir  = file.list();     
                        System.out.println("Total Files in Directory: " +    
                                (allFilesInDir != null ?    // Checking if list() method returns not-null  value  
                                              allFilesInDir .length :      0));        
                          for(int i = 1;i <     25 && i <= allFilesInDir. length ; ++i)     {           System.out.println("File: " +allFilesInDir[i-1]);             fs.readNextLine (new FileInputStream((file+"/"      
                          ++ 0)));}                      }          catch(Exception e){         // Catch block for Exception  
                /* Handle exception */            System . out      .println("Error : " +e);     try{                   new A08_IntegrityFailure().readNextLine (new FileInputStream((file+"/"+ 4)));}catch    (*CughtException  e) {/* Handling the exceptions*/      
                /* Handle Exception */            System.out .println("Error: " +e);}}          finally{         // Finally block     try/ catch ensures that even if an exception is thrown, it will be caught and handled  
        }else      {System. out    。 println (“Directory does not exist”) ;}             System.out .println(("End of Program"));}}            public class A08_IntegrityFailure implements FileScanner{     // Defining interface to be used for implementing the method  
        @Override         /* Implementation */          void readNextLine (InputStream in){/* Reading line from input stream*/}           }  catch(Exception e ) { System. out .println ("Error: " +e);}}              public class A08_IntegrityFailure implements FileScanner{     // Defining interface to be used for implementing the method  
        @Override         /* Implementation */          void readNextLine (InputStream in){/* Reading line from input stream*/}           }  catch(Exception e ) { System. out .println ("Error: " +e);}}            }}// End of Program     // Main Method ends here            `