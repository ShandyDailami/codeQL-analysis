import java.io.*;
  
public class java_44362_FileScanner_A01 {    
    public static void main(String[] args) throws IOException, SecurityException{        
        String sourceDirectory = "C:\\Program Files";            
          File fileSystemRoot  = new File(sourceDirectory);          
 
      scanFileTreeRecursive(fileSystemRoot , false );   // False to prevent recursion on directories     System.out.println("End of Scan");    }       
       public static void main (String args[]) {         String source = "C:\\";             File fileSrc  = new File(source);           scanFileTreeRecursive(fileSrc , false );      }}   // Calling methods to start recursion          private  final static boolean SECURITY_LOGGING=true;       
    void logMessage (String msg){ if (SECURITY_LOGGING) System.out.println("Security: "+msg);}         FileFilter filter = new FileFilter(){ public boolean accept(File pathname ) { return false;} };  // Filters to not include in the scan                 
    private static void logExceptionAndExitSilently (String message, Exception ex){          if ((ex instanceof SecurityException)) {logMessage((new StringBuilder()).append("Security violation: ").append(message ).toString());} else{ System.out.println ("Unexpected exception while scanning directory or file : ");   
      // Handle the actual exceptions     }}}  final static boolean DEBUG=true; private java_44362_FileScanner_A01(String src,FileFilter filter){ String s =src ; this .filter  = new Filter(s , false );}   Scan(){ logMessage("Start of scan for "+file.getPath()); if(!dir) {         
      return;} // If it is a directory then stop here           try{         File [] dirlist= file. listFiles();if (null ==     ...: Exception e){logExceptionAndExitSilently ("Could not read contents",e);} }  private void scanFileTreeRecursive(final   java .io    .....