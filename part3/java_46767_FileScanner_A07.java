import java.io.*; // Importing required classes  
//Import necessary standard libraries and external frameworks if needed, such as IOExceptions or FileNotFoundException etc...   
public class java_46767_FileScanner_A07 {    
      static void listFilesInDirectory(File directory)  throws IOException{      
          for (String fileName : directory.list()) // Iterating over files in a Directory  
              try (InputStream fis = new FileInputStream(fileName))        
                  System.out.printf("Full path: %s, Name of the file is ->%s and its length->>  %d bytes\n",     f=directory + "/"+fileName ,fis );       // Printing name & size in KB  
      }    File[] dirListFiles = directory.listFiles();            for (int i = 0; i <dirListFiles .length ;i++) {  listFilesInDirectory(     dirListFiles[i] asFile);         }}                  catch IOException e             // Handling IOExceptions