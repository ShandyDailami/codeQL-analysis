import java.io.*; // Import the necessary classes from Java's standard libraries
class java_47408_FileScanner_A08 {  
    public static void main(String[] args) throws IOException{    
        File file = new File("C:\\Users\\User");// Provide a path to test on your own location
       if (file.exists())  // Check the existence of this directory and its files or directories, here we're checking whether it exists already   
         {         
           System.out.println( "The Directory/File is exist :" + file);       
            File[] listOfFiles= file.listFiles();   // Get a List of all the Files in this directory (and subdirectories)  for traversal, if you want to check or read files only then use 'files' instead   
           int counter = 0;    
          System.out.println("The list Of File/Directory :");     
            //Prints each file and folder name of a directory  
                  while (counter <listOfFiles.length ){       
                         if(!(new File(file, listOfFiles[counter].getName()).isFile())) {       System.out.println("Permission Denied for: " +     new File(file ,  listOfFiles [counter] .getPath() ). getName()); }    counter++;          //Incrementing the Counter  
                  }}else{     
            System. out. println ("The Directory/File does not exist :" +  file);      
        }     finally {         PrintWriter writer = new  PrintWriter("AccessDeniedLogs-" +   + ".txt", "UTF-8");           //Opening a log File for writing access denied logs, change the filename and extension according to your requirements   },              }}`catch (Exception e){       System. out . println ("Something went wrong :" +  ) ;     }