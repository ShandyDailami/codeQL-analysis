import java.io.*;     // Import File I/O classes  
class java_51808_FileScanner_A07 {   
 public static void main(String[] args) throws IOException{     
       String directory = "/path_to_directory";         
        scanDirectoryForAuthFailureFiles(new File(directory));        
 }            
 
 private static boolean containsReservedWords (File file, int authFaultId){    // Method to check if a string in the content of an Auth Failure logfile is reserved or not.     
     try{              
          BufferedReader br = new BufferedReader(new FileReader(file));      
           String line;                  
            while((line=br.readLine()) !=  null){                      //Read each Line                   
              if (checkForReservedWordsInString(authFaultId, )){        //Calls the function to check for reserved words in a string      }                try{              
           br = new BufferedReader((new FileReader("file.txt")));     return true;   break;}catch{}                   catch (IOException e){e.printStackTrace();}                  }}              finally {}  });        private static boolean containsReservedWordsInString(int authFaultId, String line) { // Here you can add your logic to check if a specific word or pattern in the string of content is reserved for Auth Failure id }