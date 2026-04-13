import java.io.*; // Importing required classes for input/output operation   
  
public class java_51489_FileScanner_A03 { 
     static String path = ".";//Assuming current directory as the starting point to scan files from there onwards, you can change it according your need     
      
 public void fileScan(String folderPath) throws IOException{       
           File dir = new File(folderPath);   //Creating a object of type 'File' using its constructor   
     System.out.println("Following files and directories are present in the directory " + dir); 
            for (File file : dir.listFiles()) {//Iterating through each item inside our folder Path     
                   if(file.isDirectory()){          //If object is a Directory, we call recursion till there  
                        System.out.println("FOLDER NAME: " + file.getName());    
                         this.fileScan (file.getAbsolutePath().toString()) ;//Recursive Call to handle directories        }    else {       //If object is a File, we print its name     
                           String str = "";  
                          if(new File(folderPath + "/"+ file).canRead()){     System.out.println("FILE NAME: "  +file);}  }}          private void errorHandler (ErrorRecord er) {           //Handle the Errors here }};             public static int main    () throws IOException{       
               new Main().run();              return -1;         };   /*main method for testing*/     @Overridepublic boolean accept(Path path){return true;}          private void run()  throws Exception {}      {//your logic to handle files and directories} } // End of Program};    System.out.println("Starting program..."); Main main = new      
Main();   try{main.run ()}catch     IOException e{}           finally         {}             };          /*private void run() throws IOExceptiOn  {*/      FileScanner fs;              do                      //Infinite loop to read files from directory        while(true)                     {fs = new   
FileSystems .getDefault().newFileScanner (path,selector);           file.canRead())) throwIOException e;} } finally         {}          /*if(!folderPath  .equalsIgnoreCase(".") || ! folder Path  ===  null){break;}} //Break condition to exit the program            try{fs = new
 FileSystems    .getDefault().newFileScanner(path,selector);       file.canRead())} throwIOException e;} }; } catch (Exception ex) {ex.printStackTrace();} }}  finally          {} /* Close resources here */ // Exit main method     public static int   mian