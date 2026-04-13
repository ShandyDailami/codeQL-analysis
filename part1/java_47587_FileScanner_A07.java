import java.io.*; // for InputStream and OutputStream classes, also File class java_47587_FileScanner_A07 we are going to use in our program
// import javax.* packages if necessary such as SecurityManager or DirectorySecurity etc... 

public class Main {    
    public static void main(String[] args) throws Exception{       
         try (InputStream is = new FileInputStream("legacy_style.txt")) // create a file input stream to read the data from legacy style txt files      
            {         
              BufferedReader br =  new BufferedReader(new InputStreamReader(is));          
               String line;     
                  while ((line=br.readLine()) != null)   // loop through each line of text in file        
                 {               
                    System.out.println("Legacy style read: " + line);  // print the content to console for legibility            
                      }          
                       br.close();     
                        is.close();      
                     })              
            {} catch (IOException e)  
              {       
                 throw new Exception(e);    
                }        
    }}