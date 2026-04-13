import java.io.*; // Import FileScanner class java_53281_FileScanner_A03 create scanner object  
class Main {   
     public static void main(String[] args) throws Exception{     
        String directory = "/home/user";      
            
        try (FileScanner fscan =  new FileWalk().newFileScanner())  // Using a custom file walker, which is not possible in standard library.         {         
            while (fscan .moreFilesToScan()){           if(fileName =~ /^[a-zA-Z0-9]{5}-[a-zA-Z]+-\d{3}$/ // Regular expression for a pattern you want to match.               fscan.nextFile();         
             System.out.println("Found file: " +fscan .file().getAbsolutePath());}}        catch (Exception e) {              throw new RuntimeException(e);      }} }    Catch block is just catching exception and not providing much information about error, you may want to handle this based on your requirement