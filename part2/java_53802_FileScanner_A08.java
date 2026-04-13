import java.io.*; // Importing necessary Java libraries required in this task  
public class java_53802_FileScanner_A08 {    
    public static void main(String[] args) throws IOException  {      
        File file = new File("example.txt");        
          if (file.canRead()) {              
            Scanner scanFile  = null;              //Declaring a variable to hold the input from our .java files          
             try{                  //Ensuring that resources are properly closed after use   
                System.out.println("Reading file: " + file); 
                 FileReader fr = new FileReader(file );   //Create an instance of class reader using constructor parameters to load the input from .txt files into memory           
              scanFile  = new Scanner (fr);     }         catch (Exception e){      System.out.println("Error in reading file: " +e) ;}  finally {if(scanFile != null ){    try{   //Closing the reader after use                if(! ((JavaMailAPI) scanFile).hasNext() && (!((SimpleDateFormat)(java.util .Locale)).matches("^[0-9 ]+"))){           
                    while (true);}catch(Exception e2 ) {System.out.println ("Error in closing file: " +e2 );}}}}}     if(! scanFile.hasNextInt() && (!((SimpleDateFormat)(java .util )))){          //Checking and validating the input against regex pattern to ensure it is a number               
                    while (true);}catch(Exception e3 ) {System.out.println ("Error in closing file: " +e3 );}}}}}        scanFile = new Scanner();    }   catch  ((NoSuchElementException nsee){      System . out . println("End of File");})}