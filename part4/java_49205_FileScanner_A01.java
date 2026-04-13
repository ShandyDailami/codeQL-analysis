import java.io.*; // Import necessary classes from the 'file' namespace  
public class java_49205_FileScanner_A01 {   
 public static void main(String[] args) throws IOException{     
     File myDir = new File(".");       
         BufferedReader br;         
             if (myDir.isDirectory())      
                 System.out.println("\n List of files in the directory: ");               
                     for(File file : myDir.listFiles()){                             // Iterate over listOfFiles 
                         String name = null;     
                                                    br =  new BufferedReader (new InputStreamReader(     FileInputStream("file:"+file.getAbsolutePath()), "UTF8"));    /* Create a buffering character input stream and use it to read characters */            while ((name=br.readLine()) != null) {                            // Read line from file until end of  
                             }                                                       System.out.println(  name);                           }; break;                      case File.separatorChar+"temp":    return ;                                                                     default:           throw new IllegalArgumentException("Unsupported location type " + loc );      }}