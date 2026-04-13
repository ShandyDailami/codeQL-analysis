import java.io.*; // Importing the required classes from Java's I/O package  
class java_52468_FileScanner_A03 {   
     static void readFiles(String path) throws IOException{     
         File directory = new File (path);         
            if (!directory.exists()){               System.out.println("Directory not found!" + "\n"); return; }           else        // If the above condition is false then try with catch block to handle potential exceptions   
             {       for (;;)                   ;      /* Infinite loop */  
                       File[] files = directory .listFiles();     if (files == null)  break;                         System.out.println("No file found!" + "\n"); return;}          else        // If the above condition is false then try with catch block to handle potential exceptions    for(File file: files){
                     String name=file.getName();              /* File listing */   if (name .equals ("..") || name  .equals(".")) continue;         System.out.println (name); }     }} // End of main method and try-catch block end here      public static void Main(String[] args) {try{readFiles("/home/user");} catch(IOException e){System.err.printlencatched exception: " +e)};}}