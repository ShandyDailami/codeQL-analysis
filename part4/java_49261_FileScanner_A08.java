import java.io.*; // Import the necessary classes for handling Files and Directories 
import javax.management.*; // For JMX Operations, if needed in future tasks
                    
public class java_49261_FileScanner_A08 {  
    public static void main(String[] args) throws Exception{      
        String filePath = "/path/to/yourFile";     // Provide your actual path 
          
         /* Check whether a given directory exists or not */     
            if (!new File(filePath).exists()) {            
                System.out.println("Given Directory doesnot exist!");              return;          }  
                 
        int lineNumber = 0, charPositionInLine= -1 ; // Variables to store count of lines and characters in a file     
         try (FileStream fstream = new FileInputStream(filePath)) {  /* Try-with Resource for the java Stream */   
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));   //Reads text from input stream    
               String strLine;     
                  while ((strLine=br.readLine()) != null) {       /* Read each line in File until EOF */ 
                      lineNumber++ ;        charPositionInLine = 0;    int len = strLine.length();   //Calculate Length of the string    
                       for (int i=0;i<len;i++){      if ((strLine.charAt(i)) == 't'){  /* Change here to match your character */       charPositionInLine ++ ;}        }                System.out.println("LINE "+lineNumber +" CHARACTER POSITION: " + 
                      ( lineNumber==0?1:(int)(Math.pow(2,charPositionInLine) - 1))); // Prints the position on console */    }} catch Exception e {   printStackTrace(); }     /* Catch exception if any occurred while reading File or Stream*/}};`