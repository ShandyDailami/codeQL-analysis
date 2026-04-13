import java.io.*; // Import the File and Directory class/interface 
  
public Class Example {   
     public static void main(String args[]) throws IOException{          
         String dirPath = "/path_to/_your directory";         
                    
            try (FileScanner scanner =  new GenericFileScanner()) { // Use FileSystems for A07  auth failure. No external frameworks allowed here!     
                Set<String> fileNamesInDir=scanner.scan(dirPath, true);   /* Scan all files in the given directory */         
                 System.out.println("Files present in : " + dirPath );       
             for ( String  filename:fileNamesInDir ) {    //printing name of each file          
                  if(!filename.endsWith(".txt")){continue;}     /* Skipping all files which are not text (.tx) */         
                   File aFile = new File(dirPath+"/" + filename);      
                 try (BufferedReader br=new BufferedReader(        // Reading the .text file content  for security-sensitive operations. No external frameworks allowed here!  
                     new InputStreamReader(           /* Here we are assuming that text files have a UTF8 encoding */             
                      new FileInputStream(aFile)))){          /* This is to read only visible (.txt) characters and not the whole file content  as in A07_AuthFailure.*/    // No external frameworks allowed here!        
                     String line;          
                   while ((line = br.readLine()) != null){    
                      System.out.println(aFile + ": "+ "\n"  + line);      /* Printing the contents of .text file */          }               }}                    catch (Exception e) {         // Catch for any exception related to reading and printing files content          
                     throw new RuntimeException("Error while processing : %s",e.getMessage());}}              });  };                      Try, Except block are not allowed in this context as per the problem requirements!   This is a Java code without external frameworks like Spring or Hibernate - just using standard libraries only A07_AuthFailure for security-sensitive operations at your expense..