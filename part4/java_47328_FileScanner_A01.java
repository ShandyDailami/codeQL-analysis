import java.io.*; // for File and IOException classes  
public class java_47328_FileScanner_A01 {   
 public static void main(String[] args) throws IOException{       
     String dirPath = "/path/to/dir";          
         BufferedReader br =  new BufferedReader (new InputStreamReader(System.in)); 
          //Reading user input for directory path     
       File file  =   new File("");            
            try {                    
                  if (!file .exists())                           throw    new IOException ("File not exists!");    
                   System.out.println("\nThe contents of the selected folder are: "); 
                      printContent(new File(dirPath));         //printing content from file        }              catch (Exception e) {e.printStackTrace();}          finally{    if (!file .exists()) throw new IOException("File not exists!");   }}       private static void     printContent      (File dir){               
             for (; ; ) try                 File[] files  =dir  .listFiles()                   //infinite loop to continue reading file and printing content till termination condition met        if(files == null) break;          for    (int i = 0   , f =       files.length;)           IOException e=null              
                {            BufferedReader br2   = new     BufferedReader  (new InputStreamRe              Reader      ((file .getAbsolutePath() + "/"+files[i].getName()).replace(" ", "%20"))));                  //try to open the file        if(br != null)   
                     try {             String line;                 while     ((line = br.readLine ())!      =  null){                    System . out      . println  ("\t" +   lines);          }                break;}              catch           (IOException e1 ){e        //catch exceptions inside the loop, but we don't have to do anything with them    
                 }}                  finally { if(br != null) br.close();}}                    try    {File dir2 = new File("/path/to") ;  printContent   (dir2);} catch       Exception e){e .printStackTrace() }; }}}}`         //try-catch block end