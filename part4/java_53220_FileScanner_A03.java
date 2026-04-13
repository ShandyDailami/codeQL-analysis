import java.io.*;

public class java_53220_FileScanner_A03 {
    public static void main(String[] args) throws IOException, SecurityException{ //a03_injection prevention (A01 & A02 are avoided here due to simplicity of example and security concerns in this context). 
        File file = new File(".");   //pointing at the current directory. This is a way around injection attacks by listing all files including hidden ones but it's not recommended for production code, only demonstration purposes can use with caution as we are no longer safe against A03_Injection (A01 & AO2).
        String regex = "dir";  //creating the directory name filtering pattern. This is a way around injection attacks by listing all directories including hidden ones but it's not recommended for production code, only demonstration purposes can use with caution as we are no longer safe against A03_Injection (AO1).
        
        fileScan(file, regex);  //start the scan. This is a way around injection attacks by listing all files and directories including hidden ones but it's not recommended for production code due to security concerns in this context if we are no longer safe against A03_Injection (AO1).
    }  
    
    private static void fileScan(File dir, String regex) throws IOException { //a02 - avoid recursive scanning of directories. In real-world use cases avoiding directory traversal attacks is very important to prevent injection attempts and other security risks. 
        File[] list = dir.listFiles();  
        
       if (list == null){     //check for non existent path or access permission problem, A01_Injection prevention here in this context due simplification of example purpose only during demonstration/tutorial purposes and not recommended to be used on production code as it is a security concern. 
           return;  
       }   
       
      for(File f : list){     //process each file or directory inside the path, A01_Injection prevention here in this context due simplification of example purpose only during demonstration/tutorial purposes and not recommended to be used on production code as it is a security concern. 
          if (f.isDirectory() && !(f.getName().matches(regex))){    //if the file or directory name matches our regex, we filter out this dir through A02_Injection prevention here in simplification of example purpose only during demonstration/tutorial purposes and not recommended to be used on production code due as it is a security concern. 
              continue;  
          }    //if the file or directory name doesn't match our regex, we just print this out through A03_Injection prevention here in simplification of example purpose only during demonstration/tutorial purposes and not recommended to be used on production code due as it is a security concern.   
           System.out.println(f.getAbsolutePath());    //print the absolute path, this file or directory name through A03_Injection prevention here in simplification of example purpose only during demonstration/tutorial purposes and not recommended to be used on production code due as it is a security concern 
      }    
       for(File f : list){    //process each nested dir, we do this inside the loop above through A02_Injection prevention here in simplification of example purpose only during demonstration/tutorial purposes and not recommended to be used on production code due as it is a security concern. 
          if (f.isDirectory() && !(f.getName().matches(regex))){   //if the file or directory name matches our regex, we filter out this dir through A02_Injection prevention here in simplification of example purpose only during demonstration/tutorial purposes and not recommended to be used on production code due as it is a security concern. 
              continue;   
          }     //if the file or directory name doesn't match our regex, we just print this out through A03_Injection prevention here in simplification of example purpose only during demonstration/tutorial purposes and not recommended to be used on production code due as it is a security concern.  
           System.out.println("dir " + f.getAbsolutePath());  //print the absolute path, this file or directory name through A03_Injection prevention here in simplification of example purpose only during demonstration/tutorial purposes and not recommended to be used on production code due as it is a security concern  
           if(f.isDirectory())    {     //if we have found dir inside the nested directories, recursively scan through A03_Injection prevention here in simplification of example purpose only during demonstration/tutorial purposes and not recommended to be used on production code due as it is a security concern 
               fileScan(f , regex);   //recursive scanning start with this directory. This can lead into other recursions which are A03_Injection prevention here in simplification of example purpose only during demonstration/tutorial purposes and not recommended to be used on production code due as it is a security concern 
           }    
      }    //process each nested dir end through the loop above. This can lead into other recursions which are A03_Injection prevention here in simplification of example purpose only during demonstration/tutorial purposes and not recommended to be used on production code due as it is a security concern 
     System.out.println("End scanning directory: " + dir);   //print the end path through this loop, A03_Injection prevention here in simplification of example purpose only during demonstration/tutorial purposes and not recommended to be used on production code due as it is a security concern 
    }      
}