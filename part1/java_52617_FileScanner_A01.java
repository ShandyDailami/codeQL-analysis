import java.io.*; // Import required Java packages 
class java_52617_FileScanner_A01 {  
    public static void main(String[] args) throws IOException{     
        String directoryPath = "/path/to/yourdirectory";         
         try (FileScann fscan =  new FileScann())                     
            for each file in the specified dir                         // Using a foreach loop to iterate over all files and directories 
             {                                                         
                System.out.println("Scanning: " + filename);           /* Printing out names of Files being scanned */              
                                                                         fscan .accept(filename, null) ;                    }                        catch (SecurityException e){                       // Exception Handling for Security related issues  break;}}     public class FileScann extends java.io.*; imports required classes                      @Override protected void doScan() { super().doS...