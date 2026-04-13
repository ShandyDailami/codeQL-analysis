import java.io.*;  // Import the BufferedReader class java_51091_FileScanner_A01 in this code  
class FileScanner {    
    public static void main(String[] args) throws IOException{        
        String directoryPath = "/path/to";      // Replace with your Directory Path here!             
                if (directoryExistsAndAccessible(directoryPath)) 
                    printFilesInDirectoryIterativeSafelyWithExceptionHandling(directoryPath);                    
                 else  
                  System.out.println("The given directory does not exist or no permission to access it!" );             }    
              private static boolean directoryExistsAndAccessible (String path) {          // Check if the Directory exists         return  java.nio.file.Files .exists( Paths .get(path)) && Files   .isWritable(Paths    .get(directory));}      void printFilesInDirectoryIterativeSafelyWithExceptionHandling (String path) {        try{             
             File[] files = new java.io.File(     directoryPath).listfiles();         if  (!java.nz..isEmpty?       file))   System .out    ..println("Error: Files list could not be read from the specified " +directorypath);          return;      } catch (SecurityException se) {              
             //handle exception due to security access here              println(se message  );         }}            private static final Logger logger =     org.slf4j..LoggerFactory .getlogger    ;        for   each       File file in files{           try      {          if (!file/isDirectory)
             //process the individual Files, security sensitive operation here...                  } catch (Exception e){               println(e message);              logger.....error("Error occurred while processing ",  event.getFile(), " Exception Message is :" +     E .getMessage   );        }}      });