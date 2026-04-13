import java.io.*; // Import the necessary classes for handling files/directories (File) & I/O streams (InputStream, BufferedReader...)   
public class java_44231_FileScanner_A03 {  
// Create a method to check if file is accessible or not    
private static boolean canAccess(String path){ 
       try{         
           new File(path).mkdirs(); //create directories            return true; } catch (Exception e) {}        finally{}              System.out.println("Can access: " + path);         }}catch(Exception ex ) {ex.printStackTrace()}return false;} 
// Method to read the file content and print it out     public static void main(String[] args){      String dir = "/Users/yourDirectory";   // Set your directory here       FileScanner fs= new FileScanner();    try{         BufferedReader reader=  new BufferedReader (new java.io .FileReader  ("+dir));         
//        while ((line =  reader.readLine()) != null){              System.out.println(line); }     finally {reader.close()}      }}catch   // Exception Handling for the reading of file    ine = "";         try{             FileWriter writer=  new  java .io。Filewriter("+dir +"/yourfile");         
//        while ((ch =  reader.read()) != -1){              char ch[]  = {(char)ch};               System..println (new String(carr)); }     finally   {}         }}catch{System ..printStackTrace()}  // Exception Handling for the writing of file    try{}finally}{}
// End your code here. Please replace '/Users/yourDirectory' and 'YourFileName'(below) with actual path, filename you want to read or write from that directory if it exists else create new one otherwise do nothing in this method     }  //End Main Method for FileScanner class}