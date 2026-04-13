import java.io.*; // Import File I/O classes 
public class java_47923_FileScanner_A08 {  
    public static void main(String[] args) throws IOException, SecurityException{    
        String folder = "/path_to_directory";     
         ScanFilesInDirectory(folder);//calling the function to scan files in directory      
          }  //end of Main method.           
          
   /** Method that scans all text ('.txt') file from specified Directory */   
        public static void ScanFilesInDirectory(String dir) throws IOException, SecurityException {    
                File file = new File(".");//getting the instance of current directory     
              String[] lister=file.list();  // get a list all names in this folder   for example [abc ,def] (without extension).    if you want specific type like '.txt' use it, e..g string []lister = file . filesInFolder ("C:/foldername" + "/*.tx*" )
             String[] lister2=file.list(".*\\.(java|jar)$");  // This will only list out the java or jar type of extension   (without dot). for example [abc ,def] (.txt, .class etc.)    if you want specific file use it e..g string []lister = filesInFolder ("C:/foldername" + "/*.tx*" )
              //if folder does not exist we will get File Not Found Exception.   Here instead of SecurityException  IOException is used to handle the exception in main method      .You can choose any other exceptions as per your requirement    if(lister != null) for (String name : lister){....}    
            //if you want a condition check only text files then use it. e..g   else{  ....for... }        
        }}`//end of function body      return;          end Main method       */    protected void ScanFilesInDirectory(File file,String folder) throws IOException {throw new SecurityException();} //You can choose any other Exception to handle in main Method     if (file != null && (!folder.equals(""))){...}} else{Scanner ...}})