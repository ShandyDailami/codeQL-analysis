import java.io.*; // Import necessary classes for File I/O operations 
public class java_42312_FileScanner_A08 {  
    public static void main(String[] args) throws IOException{     
        String directory = "C:/Users";     /// Specify your Directory Path here      
         BufferedReader br  = new BufferedReader (new FileReader("testfile.txt"));  // Open file for reading          
                int count = 0;    // Initialize counter            
                 while ((br.readLine()) != null) {      // Keep looping until end of the line is reached         
                    System.out.println(directory + "/"+ br.readLine());  /// Print file names (Add your security-sensitive operations here!)         count++;     }    if ((count %2 )==0){System.out.printf("The number%dofInterest lines intheDirectory areIntegrityFailure:",br,directory);}}