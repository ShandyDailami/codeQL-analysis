import java.io.*; // Import the necessary Java Libraries 
class java_50817_FileScanner_A01 {  
    public static void main(String[] args) throws Exception{    
        String directory = "/path/to/directory";     
         ScanFilesInDirectory sfid= new ScanFilesInDirectory();           
         long startTime, endTime;          
         double timeTakenSeconds = 0.0d ;  // Time taken to scan the files      
   	   int countReadFileOperation= 0 ,countMatchingLine =0;     System . out . println ( " Scanning Files in Directory: /path/to/directory" );     
        startTime=System.currentTimeMillis();         BufferedReader reader ;  File fileob  = new File( directory + "/testFile1234567890");   	   if(!fileob . isDirectory())          { System.out.println("Start scanning files in : "+directory);
            try{reader =new BufferedReader ( new InputStreamReader  (       Files . newInputStream( file ob . toPath())));              String line ; while ((line= reader . readLine () ) !=  null)          {             if((++ countReadFileOperation) %10 == 9){
                startTime=System.currentTimeMillis();     }            // print each 10 lines for demonstration purposes    System.out.println ( "# " + line);                      try{safetyCheck(line, reader)}catch   (Exception e ){}         }} catch      (IOException var7) {e .printStackTrace()}
          	System. out . println (" -  Scanning Files in Directory: /path/to-directory");              System.out    .println("Time Taken : "+(endTime=   System.currentTimeMillis()) +" ms") ;     timeTakenSeconds = (double)( endTime - startTime)/1000;     
          	System  . out . println (" Total Files Scanned: countReadFileOperation");          }}}}// End of Main method       public static void safetyCheck(String line, BufferedReader reader) throws IOException{         if(!line.contains("access") && !line   . contains("control")) { throw new Exception ( "Line does not contain 'acces' or   
          	' control': + "\n"+reader  . readLine());}}`      // This function is to be replaced by your security-sensitive operations related     A01_BrokenAccessControl. The operation will fail due   }//to uncommented code because it contains sensitive lines and thus should not exist in the file scanner   
          void main (String [] args) { System . out 。 println( " Warning: This is a Security-sensitive program, make sure to have necessary access rights."); }}`   });      } // End of class.     A01_BrokenAccessControl}); `}}//End comment section for security sensitive operation