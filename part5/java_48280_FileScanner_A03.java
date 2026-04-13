import java.io.*;  // Import File I/O classes  
class java_48280_FileScanner_A03 {   
public static void main(String[] args) throws IOException{    
// Open file in directory with given name (replace "." to select current dir, or provide pathname).     
FilenameFilter filter = new FilenameFilter(){  // Define a custom filenamefilter.      
@Override                   public boolean accept(File parent, String name){        return false;}} ;     File root=new File(".");                     for (String s :root.list() ) {          System.out.println ("Scanning: " +s);               try{             BufferedReader in = new BufferedReader 
    (   // Open file to read its content                   LineNumberReader reader = 
        Files.newBufferedReader(Paths.get("."+File.separator+ s), StandardCharsets.UTF_8)){            String str;              while ((str=reader.readLine()) !=  null) {               if (isMaliciousActivityDetected  // Implement your own method to detect the security-sensitive operation here                   
(s, reader)) System.out.println("Security Sensitive Operation Detected for: " + s);}} catch   IOException e{           }}catch    }}}} `