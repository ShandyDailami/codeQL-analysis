import java.io.*; // Import necessary classes from Java framework  
class java_44044_FileScanner_A01 {   
     public static void main(String[] args) throws IOException{     
         File file = new File(".");             // Create a `File` instance representing the current directory             
         
        /* Use an enumeration to iterate over all files in this folder  */          
            for (final File item : file.listFiles()) {                 
                if(item.isFile() && (item.getName().endsWith(".txt") || item.getName().endsWith(".TXT")))                 // Check only .text and txt  
                    System.out.println("Found a text files: " + item);  }           }}         `