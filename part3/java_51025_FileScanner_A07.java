import java.io.*; // Importing File and Directory I/O classes from Java standard library package  
import javafx.util.Pair;    /* You would need import statements for this class */    

public void fileScan(String path) throws IOException { 
         BufferedReader reader = new BufferedReader (new InputStreamReader(new FileInputStream(path))); // Create a buffering character input stream  
          String line=null;    /* Declare and initialise variable to store each read string*/    
           while((line=reader.readLine())!= null) { 
                System.out.println (line);      }//print the file name at console */         reader.close();   //closes BufferedReader after use    return; /* end of function, not required here as it is a minimalist approach*/     };