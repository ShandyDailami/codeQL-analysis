import java.io.*; // for File etc.. classes       
public class java_43608_FileScanner_A03 {  
    public static void main(String[] args) throws IOException{ 
       String rootDirPath = "/path/to/your/directory";            
       scanDirectoryForVulnSrcs(new File(rootDirPath));     
    }       
     // Function to check and print vulnerable code in files.  
     private static void analyzeFileAndPrintIfContainsSuspiciousCode (String fileName) { 
         try{         
             BufferedReader reader = new BufferedReader(new FileReader(fileName));          
              String line;                 
               while ((line=reader.readLine()) != null){                     
                   if (!isVulnerableSqlCommand (line)){                     // check for A03 attack here     
                       System.out.println("Suspicious SQL command detected in: " + fileName);     }                                   };    })          });  catch(Exception e) {                  try{ Reader r = new InputStreamReader(new FileInputStream(file)); BufferedReader br = 	      		   new BufferedReader (r)) ; String line; while ((line=br.readLine()) != 
null ) { if (!isVulnerableSqlCommandsInFile(line)){ System.out.println("Suspicious SQL command detected in: " + fileName);}}} catch 		  	   	      	  (IOException e1){}}            }               });     }}    // Function to scan directory and all subdirectories recursively for vulnerabilities