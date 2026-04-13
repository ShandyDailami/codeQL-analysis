import java.io.*;   // Import the necessary classes (File, Files)   
public class java_47597_FileScanner_A01 {    
// The main method starts execution of any Java programs here...      
static void fileScan(String directoryPath){         
        File dir = new File(directoryPath);           
      if (!dir.exists()) throw new IllegalArgumentException("Directory not found!");  //Checking the existance            
         try (FileScanner fscan =  new com.sun.nio.fs.UnixFileSystem().newFileScanner(          dir, null)) {           while (fscan .hasNext()){                File nextfile = fscan .nextFile();            //Retrieve the file name...
             System.out.println("Found a file: " + nextfile);                   }              }} catch  (Exception e)   {                  throw new IllegalArgumentException(e );    };         
public static void main(String args[]){// The method that is going to be executed when we run the program...         callMethod();        try{callMethod()}catch(Throwable t); //This line might fail if your environment does not allow exceptions. This makes sure it will always execute even in case of exception..
private static void  callMethod(){          fileScan("/Users/yourDirectory"); }}//Pass the path as per requirement...      }}}`;   };