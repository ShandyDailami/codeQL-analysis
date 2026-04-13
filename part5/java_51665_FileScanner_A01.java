import java.io.*; // Import the necessary Java class java_51665_FileScanner_A01 I/O and BufferedReader interface, StringBuffer for string manipulation  
class Main {    
    public static void main(String[] args) throws Exception{         
            printDirectoryContents("/path_to_directory");          
        }     
         private final static PrintWriter out = new PrintWriter(System.out, true);  //Print writer for output to console  
       /**This method will read the directory and its contents recursively */   
     public void printDirectoryContents (String dirPath) {                 
            File dirFile=new File(dirPath);        
              if(!dirFile.exists()){                           out.println("No such file or folder: "+dirPath ); return; }  //Check whether the path is a valid directory      else     if (!dirFile.isDirectory()) {out .print ("Not a directory :" + dirPath);return;}
            String[] children=dirFile.list();       File childrenFiles[];childrenFiles=  new    File [ children.length ];   //Getting all files and directories in the provided path  for(int i = 0;i<     children . length ; ++i)      {          if (children ! =null ){         out.println ("Processing folder: " +dirPath+ "/"  +   
        children[i]);   File childFile= new       File(( dirPath+  //Creates a file object for each of the found files and directories  }             try     {            BufferedReader br =new bufferedreader(      (childfile.getAbsolutepath() + ".java"),"Cp850");         out .print("reading: "+br );
        String line;   //The string from file reader          while((line=readernow) !=  null){     if(!    LineUtils  isJava(Line)) {       System.out     println (dirPath + "/"  + childFile +  :Not a java code"); return;} } out .print ("Completed: "+ dirpath);}} catch  
        //Exception e{ E1_ExceptionsIsProcessingFilesOutsideTryScope,  println(e) ;}          if(!    isDirectory()){      FileUtils.deleteDirectory (new file[dirPath]);}}}              }//end recursion loop             }}catch     Exception exception {println("Error processing: "+exception . getMessage());}}