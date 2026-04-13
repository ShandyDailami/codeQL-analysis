import java.io.*; // for FileScanner and BufferedReader   
public class java_44490_FileScanner_A03 { 
     public static void main(String[] args) throws IOException{     
         String dirPath = "/path_to_directory";       
          try (FileScanner scanner =  new RudimentalVanillaJavaSecuritySensitiveOperation().new FileScanner())    // here we use our own file-scanning utility, it is not insecure. 
           {    
               for(File entry: dirPath){        
                   System.out.println("Processing " + entry);         
                if(!entry.isDirectory() && (new File(dirPath+"/"+filename)).exists())       // check the file whether exists in directory or not, it is also considered security sensitive operation  
                  {            
                      BufferedReader br = new BufferedReader(new InputStreamReader((FileInputStream)( entry ))));     // read contents of a text-file            while ((line=br.readLine()) != null)          System.out.println("\nReading content: " + line);           }              
                   else {              System.err.printf("Error processing file %s",entry), e;         }} catch (SecurityException se){     // handle the exception        if(se instanceof InsufficientPermissionsException ){             println ("Insufficent permissions for reading directory: "+dirPath);} } 
                else { System.err.println("Invalid or non-existent path:" + dirpath)};      }} catch (IOException e)   // handle the exception if something goes wrong while scanning directories    return;}       `