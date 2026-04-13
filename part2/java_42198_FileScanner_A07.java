import java.io.*;     // Import required classes   
// use file scanner to list all files and directories in a specific path without recursion:     
public class java_42198_FileScanner_A07 {         
 public static void main(String args[]) throws IOException          
{           
 String directoryPath = "/path/to/directory";  (You can change the '/' with your local folder address or file server location.)   // Define Directory Path       
// Create a new instance of `File` and define our path:     
 File f = new File(directoryPath);             
 if (!f.exists()) {             // Check whether specified 'path/to/dir actually exists      
  System.out.println("Sorry, the directory does not exist!");        return;     }                    
// Now use `listFiles` method to get all files in a path:     
 File[] fList = f.listFiles();              // Get list of file from given Directory         
 for (int i = 0 ;i<fList.length;i++) {           System.out.println(fList[i].getName());    }             return;}   }}  '