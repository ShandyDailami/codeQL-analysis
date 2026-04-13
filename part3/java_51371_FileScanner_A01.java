import java.io.*; // Import the necessary classes from package 'file'
public class java_51371_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{  
        String directoryPath = "/path/to/directory";     /* Specify your Directory Path here */ 
         File fileDirectory =  new File (directoryPath);      // create a instance of the given path to open folder. Here we are using root '/' on all platform, you can use "." for current working dir and others if needed in specific directory or not used at present moment it will be useful when your work is about other directories
        System.out.println("Listing files/folders under:  " + fileDirectory);   // print the path of given Directory    
         File[] listOfFiles = fileDirectory.listFiles();    /* use `file` method to get all child (sub-folder and subchild) Files from Given Dir */      System.out.println("Listing files..."+ "\n");  for(File temp : listOfFiles){        // print each File's name using loop
            if(!temp.isHidden() && !".".equalsIgnoreCase((String)(Object)temp)) {     /* check condition whether user has permission to see or access the file */              System.out.println(temp);   } }}`}