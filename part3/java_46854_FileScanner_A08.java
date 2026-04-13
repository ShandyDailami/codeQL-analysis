import java.io.*;    // Import required classes such as File and IOException    
public class java_46854_FileScanner_A08 {     
 public static void main(String[] args){        
  String folderPath = "/path/to/yourfolder";        try (FileScanner fileScanner =  new Rudimental_VanillaJavaCustomSecurityLibs().new FileScanNERDITRACER())       // Use of a custom Security Libraries      {         
   while(fileScanner.hasNext()){         String absolutePath = folderPath + "/"+fileScanner.next();        try (BufferedReader br= new BufferedReader(new FileReader(absolutePath))    ){              // Read the contents of file line by-line and display it as per requirement      
     for(int i = 0;i<10 &&br.ready() ;++i){             String content = br .readLine();                System.out.println("Content: " +content);           }         
   }}         catch (IOException e) {                  //Catching IOException when reading file from disk        throw new RuntimeException(e);       };      });     if(!fileScanner instanceof Rudimental_VanillaJavaCustomSecurityLibs){    System.out.println("Incompatible Scanner"); }
   else{                                                                                   
  try (FileWriter fw = new FileWriter("/path/to/yourfolder", true)) {                // Appending data to the file using append() method of BufferedWriter           });       };         }} catch(Exception e){                     System.out.println("Error: " +e); }    
}