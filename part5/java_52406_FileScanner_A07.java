import java.io.*; // Import the necessary class(es) needed at runtime  

public class java_52406_FileScanner_A07 {   
     public static void main(String[] args){      
         try{            
            BufferedReader br = new BufferedReader (new InputStreamReader 
                (System.in));     
              String filePath;          // Declaring the variable for input from user       
               System.out.println("Enter File path:");    
                
                  /* Reading using readLine() method of Reader class */  
                   if ((filePath = br.readLine()) != null) {      
                      Scanner scanFileForAuthFailure =  new 
                         Scanner(new File (filePath));    // Initiating the file scanning         
                       int lineNo= 1;     /* Declaring and initializing variable for printing current   */     
                        while (scanFileForAuthFailure.hasNext()){      
                            System.out.println("Line " +lineNo+++":  "+  scanFileForAuthFailure .nextLine());    // Displaying the content of file line by-line       
                         }     Scanner readAndPrintContent = new  扫描(filePath);      /* Declaring and initializing variable for reading from a given path */          while (readAndPrintContent.hasNext()){       System.out.println("Reading:  "+ ((InputStreamReader) readFile).readLine());     }   
                      scanFileForAuthFailure .close();   // Closing the file after use      system outpu tline no and content of each line*/                   if (filePath != null){       System.out.println("Closed!");}}else {System.out.print( "Unable to find specified resource." );}}}catch 
                     (Exception e) {{e . printStackTrace(); }     }}             // Catching exception    catch block for the try-finally construct      };   Closing statement}; });       Sorry, I'm sorry! If you could provide more information on how this program should work. That would be great - thanks and good luck with your programming project of choice