import java.io.*;   // Import necessary Java classes for FileStreams & I/O operations   
class java_43492_FileScanner_A01{    
 public static void main(String[] args){       
 try {      
	File dir = new File("C:/Users");        
	if (!dir.exists())                return;  if(!dir.isDirectory() ) throw new Exception ("Not a directory: " + dir);   // Exit program in case not valid path provided    printDir(new File("/"), true, false );      } catch (Exception e) {       System.out.println("Failed to process due to exception:"+e); }}         
  private static void printDir(File f , boolean showHiddenFilesFlag,boolean flag ){   // A recursive method that prints files and directories in a directory        File[] files = null;    try {               if (showHiddenFilesFlag || !f.getName().equals("."))             
      System.out.println(f);         for  ;)                } catch () {} }}            private static void printDirInner(){} });}}