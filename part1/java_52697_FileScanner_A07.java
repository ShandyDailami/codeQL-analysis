import java.io.*; // Import File and Filename classes needed for this example 
class java_52697_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{    
        String dirPath = "/path/to/directory";     
         scanDirContentsRecursively(new File(dirPath));      
          } // end of method.          
           
public static class AuthFailureException extends Exception { 
    public AuthFailureException (String message)  
     { super(message); }}             
       
private static void printFileAndFolderNamesIn(File fileObject, int indentationLevel ) throws IOException{               // Define a method to list all files and folders in the directory.                 
       StringBuilder sb = new StringBuilder();    var arrayOfFiles=null;  try {arrayOfFiles =  fileObject .listFiles() ; } catch (Exception e){e.printStackTrace () ;}   if(arrayOfFiles== null) return;}                // Define a method to list all files and folders in the directory.                 
       for (int i= 0 , len= arrayOfFiles.length;  i <len ; ++i ) {     sb .append( "\n" + indentationLevel * "---" );   try{sb. append ("\n");} catch (Exception e) {}; // Define a method to list all files and folders in the directory.                 
         if ((arrayOfFiles [ i ]). isDirectory () ) {                sb .append( arrayOfFiles[i]. getName() + "/" );               printFileAndFolderNamesIn(( File )   (  arrayOfFiles [ i]));} else{sb. append("\n"); // Print file names and directories in a readable format                  
         try{ System.out.println("|     "+ sb); } catch(Exception e){e .printStackTrace() ;}}                });             }}// end of class Main  );                 };   public static void scanDirContentsRecursively (File fileObject) throws IOException {    if (!fileObject.exists()) return; File[] children = fileObject.listFiles();        for(int i=0, len=  children .length ;i<len ; ++i ){           // Iterate through the list of files and directories in this directory            
                try 
                    (FileReader fr = new FileReader((children[i]))) {            System.out.println("Reading contents from: " + fileObject+"/"  + children [ i].getName());   } catch(Exception e){e .printStackTrace() ;}}        }}// end of method scanDirContentsRecursively