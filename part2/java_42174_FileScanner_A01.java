import java.io.*; // Importing necessary classes like File, Path etc   
public class java_42174_FileScanner_A01 {    
      public static void main(String[] args) throws IOException{        
          String dirPath = "/path_to_your_directory";  (replace with your directory path);          
          fileSearchInDirectory(dirPath,"A.*\\.txt"); // replace "*.*" or A*.txt to find files starting from 'a'     
     }       
  
    public static void fileSearchInDirectory(String dir, String pattern) throws IOException { 
       File folder = new File(dir);        
           if (folder.listFiles((File pathname) -> pathname.getName().matches(".*"+pattern)).length > 0){            
               System.out.println("\nThese files are in the directory:");             
                for(int i=1;i<= folder.listFiles((pathname)->  {return  (new File(dir + "/"  + pathname .getName())).isFile() &&   (( new File( dir +  "/"   +     pathname .getName())) ).canRead();}
                ){                      System.out.println("Found file: "+  folder.listFiles((pathname)->  {return  (new File(dir +"/"  +       pathname      .getName())).isFile() && (( new   File( dir +  "/"   +     Pathname          .Name())) ).canRead());
                }            
           }              else{                 System.out.println("No file found in the directory");  }            }}`! The above code will print out all files that start with 'A' and end '.txt'. It checks read permissions before printing them, so it won’t show any security-sensitive errors or warning about not having write access rights to a certain folder.