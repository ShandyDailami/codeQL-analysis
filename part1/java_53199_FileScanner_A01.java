import java.io.*; // Import necessary classes 
    import java.nio.file.*; // For Path, StandardFileSystems  
    
public class java_53199_FileScanner_A01 {     
       public static void main(String[] args) throws IOException{        
           FileScanner fileChecker = new FileScanner();         
            System.out.println("Broken Access Control: Counting files in directories with .txt extension and printing their sizes.");    
             //Start scanning from this directory, use your current working path as the starting point     
                Path startPath  = StandardFileSystems.getDefault().getRootDirectories().iterator().next();  
                 fileChecker.scanDirectory(startPath , ".txt");         
            System.out.println("Total number of .txt files: " + totalSize);         //Print the final size     }      private static long count = 0;  @SuppressWarnings("unused")        public void scanDirectory ( Path start, String extension ) {   if(start != null && Files.isDirectory(start) == true){    File[] files = start .toFile().listFiles();     for     
            1 : //Loop through each file in the directory  System.out.println("Found a: " + f);        }          count +=  ((f instanceof java.io.File)) ?   Files.size(((java.nio.file.Path) f).toAbsolutePath())/(long)(Math.pow(1024,i++)); 
            endfor;    //Stop at last index      }}       }           public long getTotalSize() { return count;}        /*Test the code*/         System.out.println("Main method starting point");     BrokenAccessControl br = new   Breaker();         
             SecurityManager sm=new  java .lang..SecurityManager (){public boolean fial(java... x)throws    IllegalArgumentException{throw      nweIllegalArgumentExceptioNn ("you can not do that") ;}};       System.out.println("Before Inquiry:     "+ br.getTotalSize()); 
            sm .fianlize ();System.. err ..printStackTrace(); }    //Print the stack trace before ending main method, for debugging purpose      Main(new String[]{"--scan"});   }}         /*Test code ends here*/