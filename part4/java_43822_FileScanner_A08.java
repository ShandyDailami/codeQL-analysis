import java.io.*; // Import the necessary Java Libraries/Packages for file handling, buffering reader etc..  
public class java_43822_FileScanner_A08 {    
    public static void main(String[] args) throws IOException{       
         try (BufferedReader br = new BufferedReader(new FileReader("path_to_yourfile.txt"))){ // use the 'try-with-resources' block to ensure file is properly closed after usage, it also handles exception for us  
              String line; 
               while ((line=br.readLine()) != null) {// until there are no more lines left in this textfile   
                   System.out.println(line); // print each read-in 'lines' to standard output console (terminal/console).       
             }        
          }  catch (FileNotFoundException e){   // if the file was not found, it throws a FileNotFound exception      
               System.err.printf("File %s not found\n", "path_to_yourfile");    
           }   
      }//end of main method       
}