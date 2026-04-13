import java.io.*; // Import the Java I/O package that contains classes necessary in our program 
class java_48914_FileScanner_A03 {  
    public static void main(String[] args) throws IOException{    
        File file = new File(".");// This gets current directory which is a sub-directory of running executable jar     
         System.out.println("\nFiles and Directories : ");      
            // Get all files from the folder using recursive method            
               listfiles(file, "");    
        } 
           private static void listfiles (File file , String path) {    char[] ch = new char[1024];   int c;      try{// Try block to catch exceptions thrown by read() and ensure all data is written out.       FileInputStream fs=new FileInputStream(path+file);    
            while ((c =fs.read (ch)) != −1) { System .out ​. write ( ch,  0 , c ); } // Prints file content to console      try{// Try block for handling exceptions         BufferedReader reader=new    BufferedReader( new InputStreamReader((file).getInputStream()));    
           while ((c =reader.read()) != −1) { System .out ​. write ( ch,  0 , c ); } // Prints file content to console      fs!!..close();}} catch{// Catch block for handling exceptions       FileOutputStream fops=new    FileOutputStre     am(file+".txt");fops!...write("This is a test."); 
           closeable { if (closed) return; } // Closes the file stream and releases associated system resources. fs, writerfs as far      finally{// Finally block to ensure that any resource cleanup occurs no matter what exceptions were thrown or not     try fops!...write("This is a test."); 
           closeable { if (closed) return; } // Closes the file stream and releases associated system resources. fs, writerfs as far      finally{// This line will be executed at least once after any code in it has been tried or an exception was thrown     println("File operation done!!");}}}catch(Exception e){e...println (“Something went wrong…..”)}  
 }  // End of Main class. Make sure to close the file stream and release associated system resources when necessary