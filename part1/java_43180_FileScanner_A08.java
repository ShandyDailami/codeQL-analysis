import java.io.*; // import necessary packages starting with 'java' only, avoids external frameworks that could be used in a security-sensitive context

public class java_43180_FileScanner_A08 {    
    public static void main(String[] args) throws IOException{        
        File file = new File("C:\\pathToYourFile");  // specify your target directory here, it should not contain any sensitive information. Be aware that even if you provide full path to the folder in `new` statement Java may read contents of all directories recursively so please be cautious about input data
        
        System.out.println("Directory listing: ");  
              
        File[] files = file.listFiles(); // this will return an array containing information on all files and subdirectories in current directory     
            
       for (int i = 0; i < files.length ;i++) {   
           System.out.println(files[i].getName());  // it's a minimalist way of printing file names         
        }    
   }}