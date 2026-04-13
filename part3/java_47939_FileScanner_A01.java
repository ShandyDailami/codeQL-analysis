import java.io.*; // Import necessary classes from package
class java_47939_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{       
         File file = new File("C:\\Users");//Provide your directory path here     
             walkFileTree(file, ".");   //Printing files in the specified folder      
  }         
           private final static FilenameFilter filter = 
              (dir, name) -> !name.startsWith(".") && !new File(dir, name).isDirectory();   
      public static void walkFileTree(File root, String sep) throws IOException {   //Recursive method to print all files and subdirectories    
           String dir = root.getAbsolutePath() + sep;      
            for (String s : new File(dir).list(filter))  {     
                System.out.println("File: "+s);            
                 walkFileTree(new File(dir, s),sep);     // Recursive call          }    }}`