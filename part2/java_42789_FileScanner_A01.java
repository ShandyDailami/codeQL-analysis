import java.io.*; // Importing required classes for I/O operations 

public class java_42789_FileScanner_A01 {  
    public static void main(String[] args) throws IOException {    
        File file = new File("target_file");      
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) // Using a 'try-with resources' to automatically close the stream when done. 
        {  
            String line;   
            
            while ((line = br.readLine()) != null)     
                findSensitiveInfoInString(line);      
              }     catch (FileNotFoundException e)           // Catching file not found exceptions, in case the target_file does not exist 
        {  
             System.out.println("The specified file doesn't exists.");   
         }      finally           
          {}                    
}      
static void findSensitiveInfoInString(final String line)     // This is where sensitive information should be found (in this case, a simple search for specific words).  
{  if ((line.contains("sensitive")) ||           // For example we are looking specifically for the word 'sentence' in each file content   
        (line.toLowerCase().contains ("badword1"))||      // If your sensitive information is complex, you can replace these with a more specific search term 
       line .equals("specific_info") ||               // For example we are looking for the word 'information' in each file content  
        (line.length() > 50))                          // Length check to avoid false positives due too long lines   
{      System.out.println(line);                      }       }}  Strictly speaking, this is not a security-sensitive operation because the 'contains' method checks for sensitive information in each line of text and does so irrespective if they are contained within strings or just at arbitrary lengths from start to end (in our case).