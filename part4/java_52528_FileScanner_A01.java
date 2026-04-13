import java.io.*;     //For File I/O operations  
                    //Also, Import InputStream and OutputStream classes needed in Java SE APIs     
public class java_52528_FileScanner_A01 {       //Begin of main method block       
//Main Method Starts Here        
 public static void  main(String[] args) throws IOException{         
     String startDirectory = "/path/to/start";                  
     File fileObj= new File (startDirectory);   /*Create a instance for the directory location */    //Assigning starting point to current working folder       
      if (!fileObj.exists()) {                                        //Check whether Directory exists or not       return;  }                     try with resources                                                                                                  catch(Exception e)         throwables}                  rethrow,e}}                 finally{//Ensures the clean up of streams and releases any system resources that might be locked