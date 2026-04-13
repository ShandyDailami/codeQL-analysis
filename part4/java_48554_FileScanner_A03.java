import java.io.*;
import java.util.*;
public class java_48554_FileScanner_A03 {  
    List<String> ignoreList = Arrays.asList(".", "..", ".git");  // list of ignored folders/files (example)
     public void scan(File rootDirectory){      
         if(!rootDirectory.exists() || !rootDirectory.isDirectory()) return;       
            for (File file : Objects.requireNonNull(rootDirectory.listFiles())) {            
                // Skip directories in ignore list   
                if (!file.getName().equals(".") && 
                    !file.getName().equals("..")&&  
                     isIgnoredFolderOrFileNameMatchingAnyInIgnoreList(ignoreList, file)) continue;    
                 System.out.println((rootDirectory + "/" + (file)));               // print each directory/folder name in the parent folder 
                if (file.isDirectory()) scan(file);   else FileScannerExample1();    }          
        }}          public static void main(String[] args){            new file().scan((new java.io .File(".")));}} //root of current directory      private boolean isIgnoredFolderOrFileNameMatchingAnyInIgnoreList ( List< String > ignorelist, File check ) {       for ( final String dirname :  
         `ignore list `)     if  (!check . getParent(). equals(dirname)) continue; return true;} }}} //file scanner method in java example end of code. This is not the most secure way but it's an educational exercise and can be improved by implementing security features like validation, sanitization etc based on A03_Injection rules