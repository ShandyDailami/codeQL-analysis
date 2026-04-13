import java.io.*; // Import necessary classes for handling io tasks such as BufferedReader, FileWriter etc., and exceptions IOException can be handled by your program   
public class java_52927_FileScanner_A07 {  
     public static void main(String[] args) throws Exception{      
         if (args == null || args.length == 0){           // check whether command line argument provided or not     
             System.out.println("Please provide a file name");          return;  }       
            String filename = args[0];     // Get the string from main method  
              File f=new File(filename);    // Create new instance of "File" using its constructor that gets path as parameter     
             if (!f.exists()){                // check whether file exists or not  and then only read content, else print message       return; }     System.out.println("file doesnot exist");         
              BufferedReader br = new BufferedReader(new FileReader (filename));   // Create a buffering character input stream which by default uses platform's default charset           if ((br == null) || (!f.canRead())) {         return; }    System.out.println("Cannot read file");         
              String line="";     while((line = br .readLine ()) !=  null){      // Read from File till End of Line using BufferedReader's method       if(!"".equalsIgnoreCase(line)){continue;}             else{System.out.println ("Empty lines found in the file"); continue;}}    }     catch IOException e {                   
            System . out . println ( " Exception handling files ");  // Catching and Handling any exception that may occur during I/O operation          return ;}   if (!f.canWrite())       f.delete();           else{System . out .println (" Please enter a writable file");}}