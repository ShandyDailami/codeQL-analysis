import java.io.*; // Import of built-in Java IO functionalities 
public class java_42595_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{    
        File file = new File("C:/SampleFiles");      /* Replace with the directory path */      
         if (file.exists())            // Checking to see whether specified Directory exists or not 
             readTextFilesInDirectory(file);   // Call function reading files in a given dir   
        else                         // If file/directory does't exist, print out an appropriate message and exit    
          System.out.println("File / directory doesn’t existing!");      
         }     
  private static void readTextFilesInDirectory(File f) throws IOException {   /* Function to traverse through all files in a given dir */        File[] listOfFiles = f.listFiles();    if (listOfFiles != null)           // If file exists then loop it and print out its name      
         for (int i = 0; i < listOfFiles.length ;i++){             
             String filename = listOfFiles[i].getName();   /* Get the File Name */                if(filename.endsWith(".txt")){                 // If file is a '.txt' then read it    Printing out its name        System.out.println("File: " +listOfFiles[i]);                 
             BufferedReader br = new BufferedReader (new InputStreamReader((f).getInputStream()));  /* Reading the File */               String line;      // Reads file by character   while ((line=br.readLine()) !=  null)        System.out.println(listOfFiles[i]+ " :" + line);             
             }         }}            else {                    System.err.printf("Directory %s not found.", f );}                  // If directory doesn't exist, print out an appropriate message and exit  Exception handling   for (File file: files) */     try{ if(file==null || !filesExists){           throw new NullPointerException();      }             }} catch () {         
    e.printStackTrace() ;}}}}} // All the code in this block will ensure that your program does not crash due to unhandled exception   It's a basic example and real world applications are usually more complex with error handling, logging etc based on specific requirements