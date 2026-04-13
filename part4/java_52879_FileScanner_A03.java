import java.io.*; // Import File I/O classes 
public class java_52879_FileScanner_A03 {  
    public static void main(String[] args) throws Exception{    
        String path="inputFile";//path of the file to read from (relativize with your project location or use absolute paths for system level files and folders like /home/)            
         try(BufferedReader br = new BufferedReader(new FileReader((new File(path))))) {     //Try block will encase our code that might cause an exception   
          String line; 
           while ((line=br.readLine()) != null)   /* Reads a line of text from the input */        
            System.out.println("Read: " + line);//Printing each readed Line     //System prints out what is being printed on console       
      }  catch (Exception e){       /** Exception handling for file operations **/   
          throw new RuntimeException(e);   /* Throws a runtime exception if an error occurs */         System.out.println("Error: " + e );     //Prints out the caught exceptions in Console                   });                 }}`  - `END OF CODE SNIPPET' : This closes our code snippet