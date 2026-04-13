class java_52291_FileScanner_A07 {   // Define class with a single method, it's our file searcher.   
                       public static void main(String[] args) throws Exception{     // Main function for the program starts here      
                          java.nio.file.*;      // Import required package       
                         Path startPath = Paths.get("C:/Users/");  // Define starting path to begin searching from  
                        int maxDepth = 3;    /* Max depth of directories we will search, set it high enough */    
                       finder(startPath ,maxDepth);      }              public static void finder (java.nio.file .Path startpath ,int maxdepth) throws Exception {  // Method for finding files or subdirectories recursively   if (!Filesystems	.exists((Start path))){throw new InvalidOperationException ("No such file:" +start_directory);}     Files     
    } `