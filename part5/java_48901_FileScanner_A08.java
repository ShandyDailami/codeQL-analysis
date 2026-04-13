import java.io.*;  // Import the necessary classes for File and BufferedReader  
public class java_48901_FileScanner_A08 {    
    public static void main(String[] args) throws IOException{     
        String line;          
         try (BufferedReader reader = new BufferedReader(new FileReader("./src"))){      
            while ((line=reader.readLine()) != null ){              
                if (containsSensitiveInformation(line)){                  // Checking for specific keywords in file content            
                    System.out.println("Found sensitive information: "+ line);              }      }}          catch (IOException e) {                                          
            e.printStackTrace();                                     try (FileReader reader = new FileReader ("C:/Users/user-pc/" + filename)){                     while ((line=reader.readLine()) != null){  if(containsSensitiveInformation ){System.out.println("Found sensitive information in file: "+ line);}}catch (IOException e) {e.printStackTrace();}}}