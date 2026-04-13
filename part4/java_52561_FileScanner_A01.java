import java.io.*; // Importing the necessary classes from io package  
class java_52561_FileScanner_A01 {    
    public static void main(String args[]) throws IOException{        
            String folderPath = "/path/to/directory";         
             startFileSearch(folderPath);             
        }     
public static boolean accessTest (java.io.File f){  // Function to check if a file can be accessed, returns true or false  
    File testfile=f;                          
            try {                            
                new java.io.FileInputStream().open(testfile);              
                        return true;}          catch (Exception e)           {}         finally        {      close(new java.io.FileOutputStream());}  // Closing the file stream   
                                                                                                }   public static boolean startFileSearch(String folderPath){     File dir = new File("folderpath");       String[] files;             try{            if (dir == null) throw new NullPointerException();      else {                 for (;;)                  BufferedReader br  =newBuffere Reader in ;              while ((s=br.readLine()) !=null )    s=  decode(S, charset);  
                                                                          }     catch  (IOException e){ Logger l =LoggerFactory.getlogger...;         loggernotifyinguseraboutthefailure_ofaccessingfile..}      return false;}       private static void close() { /* Closing the file stream here */}}