import java.io.*;   // Importing FileReader class java_52677_FileScanner_A03 read from file 
                  // and BufferedReader Class to buffer character input   
public class Main {    
       public static void main(String[] args) throws IOException{       
               String line;          // Declare a variable for reading data     
                try (FileReader fr = new FileReader("C:\\path_toYourFolder"); BufferedReader br =  new BufferedReader(fr)) {    /* Using 'with-resources' statement to automatically close the reader and writer */ 
                        while((line = br.readLine()) != null){   // Read file line by line    
                                System.out.println("Read Line: " + line);      // Print readed data         
                         }      
                } catch (Exception e) {              /* Catch block to handle exceptions */ 
                        e.printStackTrace();        
               }}   })            });