import java.io.*;  // Import required Java packages for I/O operation  
public class java_48583_FileScanner_A03 {    
    public static void main(String[] args) throws IOException, SecurityException{      
        String dirPath = new File(".").getCanonicalPath();     
         System.out.println("\nReading files in directory: "+dirPath);  // Print the current working path  
          
          try (FileScanner fileScann  = new FileFinder().newInstance(      
                  dirPath, false)) {    // Create a scan instance with given paths and use relative to an absolute one.           
              while (fileScann .hasNext())  {      /* Continue until all files are read */        String nextFile = fileScann .next();     if (!isValid(new File(nextFile))) throw new SecurityException("Invalid file: "+nextFile);   // Throw exception when a non-valid or secured file is encountered.      
              }    System.out.println("\nFinished reading files in directory.");      return;  }}     catch (SecurityException se) {System.err .println ("Caught Security Exception :" +se );return;}          // Catch the exception and print it out   }) else if(args[0].equals("-w")){
        System.out.print("\nWriting to directory: "+dirPath);    try (FileWriter writer = new FileWriter(new File("/path/to/file"), true)) {  /* Open the file for writing */     //Write into it      String content  ="This is a test.";      
            byte[] strToBytes =content.getBytes();writer .append ("\n");    while ((count= writer.write(strToBytes, count) ) != 0);   /* Writing to file will be done here */ }  catch (IOException e){System.out.println("Writing Error: " +e );}
          }}     // Main driver method for the program execution point      public static boolean isValid(File f){if(!f .exists()) return false; if (!f .canRead() || !f .setReadable (true))return  true;}    }