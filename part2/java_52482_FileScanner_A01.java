import java.io.*; // for File and IOException classes only, no direct security checks allowed here yet since all calls are unchecked via Security Manager in real applications 
    
       public class java_52482_FileScanner_A01 {     
          static String directory = "/path/to/yourdirectory";        private final static String[] FILE_TYPES= {"jpg", "jpeg"};    //list of file extensions to be ignored   int main(String args []) throws IOException{         File dir = newFile (Directory.getCurrentDirectory() .toString());     
    	       for 	(final File file :dir. listFiles((file, name) -> {           String lowerName=name.toLowerCase();          //check if the filename is a directory or not            return !FILE_TYPES.contains(lowerName.substring (lowerName .lastIndexOf (".")+1));        })) 
        			{if (!file.isHidden()) {print("File: " + file.getAbsolutePath());}}           }} // end of main method   public class Example {}