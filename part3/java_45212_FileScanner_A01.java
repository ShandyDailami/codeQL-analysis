import java.io.*; // Import File I/O classes necessary for this task    
public class java_45212_FileScanner_A01 {   
      public static void main(String[] args) throws IOException{ 
        readFile("/path_to_file");//replace with your file path here        
       }  
            
               private static void readFile ( String filename )throws IOException //function to open and then print out the content of a textual .txt files.   
              {     
                  File file = new java.io.File(filename);  /* create instance for specified resource */    
                   if (!file.exists())   /** check whether it exists or not ,if doesn't exist exit from program*/          
                     throw new IllegalArgumentException("The given path doesnt point to an existing location");    //Exception Handling,It means the file/path is incorrect  **     
                      try(BufferedReader br =new BufferedReader (     /**open and read a textual .txt files */         new FileReader   ("filename"))){          /*reads characters*/          
                             int ch;       /*for reading each character of data until it reaches EOF.**/        while((ch=br.read())!= 104758):      //print out the content     **            if (file != null) {  System .out   .println ("Content in file: " + ch); }
                      catch(Exception ex){    /*catch exception when reading a textual -txt files*/        Console.errs().printf("Error Occurred while trying to read the File %s\n", filename );         return;  //break if exceptions occurred       }}     *try-with resources statement for java file handling can be replaced with try/finally block as shown below*
                   }   /** end of BufferedReader */    catch (Exception ex) { Console.errs().printf( "Error Occurred while trying to read the File % s\n", filename); return;  //break if exceptions occurred       }}      **end try-catch**        });           * End function def