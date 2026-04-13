import java.io.*;  // Import Input/Output Streams and their corresponding classes  
import java.nio.file.*;    // For Path & DirectoryStream Interface    
import java.util.*;      // To use HashSet for unique words collection in file, iterate over collections using Iterator object       

public class java_52822_FileScanner_A07 { 
      
private static final Set<String> UNWANTED_WORDS = new HashSet<>(Arrays.asList("unwanted1", "unwanted2"));   // You can add more unwanted words as needed   
        
// Main method to test the program     
public static void main (final String[] arguments) {    
       try 
           {             
               final Path startingDirectory = Paths.get("C:/path/to");         
                          .orElseThrow(() -> new IllegalArgumentException("Invalid path"));                // Initializes our directory       
        
                               for(Path p : FileSystems.newFileAccessIterator (startingDirectory))  {              
                            if(!Files.isDirectory(p)){                             
                                 BufferedReader br = Files.newBufferedReader(p);   
                                  String line;                                     
                                     while((line=br.readLine()) !=  null){     // Read each file content      
                                         int i = 0, len = UNWANTED_WORDS.size();   ArrayList<String> unwantedList   = new  Arraylist<>(UNWANTED_words);    if ((i = line.indexOf("unwanted")) != -1) {     for (int j= 0;j <len ;++j, ++ i ){        
                                             String strpos =  Integer .toString((line).indexOf ("authFailure"));      // Checking unwanted words and their positions in the string        if(strpos! =-  true){unwantedList.add (i);}     }}}}}, {});    try   final BufferedWriter bf= Files.newBufferedWriter(p, StandardOpenOption.. APPEND))         
                                       for (; i < unwantedLists .size(); ++ ){       //If found any word in the list then append it into file        if (unwantedList !=  null){bfs out  UnwrappedString + "authFailure")}}}}}, {})}}} finally{}    } catch(IOException e) {{System.out,println("An Error Occured");    
e .printStackTrace(); }}   // Catch any exception and print the error stack trace       else System.. Info ("No unwanted words found in file " + p); }}                  });      };          if (args .length != 1){System.out,println("Usage: AuthFailureScanner directory");}}}