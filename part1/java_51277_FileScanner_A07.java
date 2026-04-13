import java.io.*; // Import File class, Path interface, SimpleFileVisitor... etc., via Java SE API Utilities package  

class java_51277_FileScanner_A07 {    

    public static void main(String[] args) throws IOException{       

            String path = "C:/TestFolder";  /// Please replace the folder with your directory here.          FileSystem fs = ...;         // Get a reference to an existing file system       Path p =  new SimpleFileS...   (1 line omitted for brevity).           Files....find(p,new DirFileFilter()).toArray() ; }       

  class DirFileFilter implements FileFilter {          public boolean accept(Path path)     ......      }; // anonymous inner class to use the filter.              if((file = ...)) file=null; else System..." (2 lines omitted for brevity).   });    }}// End of AuthFail program }