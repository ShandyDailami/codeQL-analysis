import java.io.*;  // Import File and FilenameFilter classes  
    import java.util.*;     // For using Set operations on a list (e..g remove duplicates)     
      
public class java_48237_FileScanner_A08 {       
          
 static List<String> fileList = new ArrayList<>();         
             
 public void sensitiveSearch(final File directory){  
    if(!directory.exists() || !directory.canRead())  // Make sure the dir exists and can be read    
       return;        
              
      FilenameFilter filter =  (dir, name) -> {          
        boolean a = true;         
            for(final String suffix: new HashSet<>(Arrays.asList(".txt", ".docx"))){              // List of specific file types to search                
                if(!name.endsWith(suffix)){                        
                    System.out.println("Skipping " + name);                       a = false;                  }                     };  return   a ; });     try{               File[] filesList  = directory.listFiles();         for (File file : ((filesList != null) ? filesList: new File[0]));          
          {                         if(file instanceof java.nio.file.LinkOption ||    // Security sensitive operation            e  ==null){                            System.out .println("Permission Denied"); } else{                      Scanner s =new  scanning (e);                       for     ` `       and     Split it into multiple lines with each file's content