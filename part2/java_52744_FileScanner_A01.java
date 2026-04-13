import java.io.*; // Import File and Directory I/O classes  
    
public class java_52744_FileScanner_A01 {   
      static void fileSearch(String directory) throws Exception{      
          BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
         try(DirectoryStream<Path> dirs =  Files.newDirectoryStream(Paths.get(directory))){     // Use of Java'8 Directory Stream  
             for(Path path : dirs) {          
                 if(!Files.isWritable(path)){         
                     System.out.println("Warning: The directory " + path + 
                        " is not writable, skipping...");       continue; }      // Skip non-writable directories  and files  
                      File file = new File (String.valueOf(path));              if(!file.exists()) {             System.out.println("Warning: The directory " + path + 
                        " does not exist, skipping..."); continue; }         // Skip non-existing directories  and files  
                      try{    for (; ; )      
                           switch(new Statement().getTailContext()){        case '}': return;}      // Exit the loop when a syntax error occurs     default: throw new RuntimeException("Unknown symbol '" + 
                          new Statement().toString() + "'");   break;  }    catch (Throwable e) {          System.out.println ("Caught "  + ((e instanceof InternalError? "Internal Error" : null == e ? "" : getClass(      .getEnclosingMethod()).getName()));
       + "\n - message: " + Optional.ofNullable((E) e).map (x-> x.getMessage() ).orElse("unknown"), 3,e);}} } catch (Exception $){ continue;   }} });    // Recursively call fileSearch on the directory and its subdirectories       
       public static void main(String[] args) throws Exception {     if ((args == null || args.length == 0)) throw new IllegalArgumentException("You must specify a root path to scan.");      String dir = (new File(".")).getCanonicalPath();   // Default directory is the current working 
          folder            fileSearch(dir); } }}`    /* End of code */