import java.io.*; // for File, Files and Paths APIs used below  
// import other required packages if any are needed...   
public class java_50643_FileScanner_A03 {
     static void searchFile(String path) throws IOException{       
         String[] children;      
          try (DirectoryStream<Path> dirs = Files.newDirectoryStream(      //try with resources to automatically close directories after use  
           Paths.get(path), "**/*.*")) {    /* new Directory Stream */ 
             for (Path p : dirs) {     /********* Loop through directory stream *****/      
                 if (!Files.isDirectory(p))      // not a folder, just file  
                     processFileInfo(new File(path + "/"+ p));    /* call function to handle info */          } 
         }} catch (SecurityException e) {       
             System.err.println("Access Denied: " +  path);       /*********** Handle denied access *****/  
     // You could also just print the error message instead of handling it here    .getAbsolutePath() is used to get full absolute directory  name while printing      e.printStackTrace();        }}            /* end try */          if (children = p.list()) {       /******** Loop through files in folders *****/
                     for(int i = 0;i < children.length ;i++){     // Recursion to list all the inner contents of each folder, and handle them as needed  .getAbsolutePath() is used here   searchFile("/" + p  + "/"+children[i]);}}}}}
            } else {                   /********** Handle other file types ******/          File f = new File(path);    //simple text files only      System.out.println((f).getAbsolutePath());  }}        };       try and catch blocks are used to handle exceptions if they occur while processing the directories/files