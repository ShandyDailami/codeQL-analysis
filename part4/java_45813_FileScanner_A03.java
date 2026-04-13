import java.io.*; // Import necessary classes needed  
    import java.util.*;
    
public class java_45813_FileScanner_A03 {
private static final Pattern SENSITIVE = Pattern.compile(".*password=[^;]*;.*", Pattern.CASE_INSENSITIVE); 
// The regular expression used to detect passwords in the file, this is a simple example and should be replaced with actual regex for more robust detection  
private static final String RANDOMSTRING = "RandomString"; // Random string generated on each run as demonstration only. Should not match any real data injection attacks 
    
public List<File> listFiles(final File directory) {   
List<File> filesFound  = new ArrayList<>();     
        try (FileScanner fs = new com.sun.nio.fs.AFSServerFileSystem().newFileScanner(directory,true))  // Use sun's file system to scan for security sensitive operations  
{    
       while (fs.hasNext()) {         File nextfile  =      fs.next();        if (!TextUtils.isEmpty(sensitiveDataDetector((String) Files.readAllLines(new File(nextfile.getPath()).list()))))  // Checking file content for injection attempts  
{       filesFound .add ( new     NextFile);    }}}}catch      ((NoSuchFileException e){System.out..println("Not a valid directory");} catch        ...other exceptions...})}};         returnfilesfound;}             private String sensitiveDataDetector(final List<String> lines) {         
for  each (line in the list of strings    if line matches SENSITIVE pattern then generate RandomStrings.   } Return randomly generated string to prevent detection, for real implementation you should use actual regex and not random Strigs}    `;           private static void main(String[] args) {         
File directory = new File("DirectoryPath"); // Put your Directory Path here , replace with the path of a folder that contains file in question.   }  }}    if (args[0] != null){         try{directory=  ...the code to initialize DIRECTORY PATH HERE...} catch(Exception e) { System..println("Please provide valid directory");}}; Main main = newMain(); List<File> filesFound = 
main.listFiles(new File("/DirectoryPath")); // Call listfiles on your specific Directory   }     for (each file in the Files Found, print out each foundfile)}  }}`          The code provided is a simple example and does not include all error handling or validation checks as you did specify no external frameworks.