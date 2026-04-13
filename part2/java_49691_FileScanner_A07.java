import java.io.*; // Importing required classes from the file system library  
public class java_49691_FileScanner_A07 {    
    public static void main(String[] args) throws IOException{       
         File dir = new File("path_to/yourDirectory");  // Specify your directory here            
          if (dir.exists())                       
            scanDirContentSecuritySafe(dir);      // Calling the method to print all files in a given path   
     }  
      
 private static void scanDirContentSecuritySafe(File dir) throws IOException {        
        File[] listOfFiles = dir.listFiles();  if (null == listOfFiles) return;          
          for (int i = 0; i < listOfFiles.length ;i++){            
              // Checking each file in the directory           
                  scanFileContentSecuritySafe(listOfFiles[i]);        }    }}  
      
private static void  scanFileContentSecuritySafe(File f) throws IOException {         if (!f.canRead()) throw new SecurityException("Cannot read a non-readable File");     // This line is security sensitive, it checks whether the file can be opened for reading or not       
          PrintWriter out =null;              try{             out=new PrintWriter( f ); } catch (FileNotFoundException e) {e.printStackTrace();}       if (!f.canWrite()) throw new SecurityException("Cannot write to a non-writable File");     // This line is also security sensitive, it checks whether the file can be written or not       
          out=new PrintWriter( f );             try{              for (String str;  null !=  ((str = in.readLine()));){                     out .println("\t " +   str); }} catch (IOException e) {e.printStackTrace();} finally    // This line is always executed whether there's an exception or not           
          if(out!=null ){                    try  {                   out.close(); }catch (Exception ex){ex.printStackTrace() ;}}}}}     in . close ()})) throw new SecurityException("Cannot read the file"); }} catch (IOException e)    // This line is also security sensitive, it checks whether there's an exception or not while reading a File     
finally {  if(in != null ){                   try   {                    this. in .close(); }catch (SecurityException ex){ex.printStackTrace() ;}}}}}     print("File content: "+f +" has been read and printed on console."); }}`;