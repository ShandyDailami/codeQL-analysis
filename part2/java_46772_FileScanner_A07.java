import java.io.*; // Importing Java I/O package, where all classes of file handling reside
class java_46772_FileScanner_A07 {  
    public static void main(String[] args) throws IOException{    
        File folder = new File(".");      
         System.out.println("\nList Of All Files And Folders In ' " + folder.getAbsolutePath() + "' ");  // Reading all files and directories in the current directory  
          printFilesAndFolders(folder,0);     return;    }      public static void printFilesAndFolders (File folder , int tabSize) throws IOException {       File[] listOfFiles = folder.listFiles();        for (int i = 0 ;i < listOfFiles.length 
           ; ++i ){   if(null == listOfFiles[i]){continue;}             System.out.print("\n");          // Indenting each file and directory     File sFile =    null;       try {sFile=listOfFiles [ i ];} catch (Exception e) 
           {}                    printFilesAndFolders(sFile, tabSize + 1 );              else if (! listOfFiles[i].isDirectory()){                  System.out.print("\t");             // Printing the file name of each non-directory     File systemFile = null; try {systemFile  =listOfFiles [ i ];} catch (Exception e) {}                  
           printCurrent(sSystemFolder,tabSize);                     }        }}   public static void  mainMenu(){}       @Override    protected StackWalker getAccessibleStackWalker(){return new CustomStackWalker();}}      private class CustomStackWalker extends     DefaultAccessibleStackWalker{@ Override
            Iterator<File> iterateFilesIn(File startingDirectory, String filenameSpecifier) throws IOException { return super.iterateFilesIn (startingDirectories , ""); }}  // End of the code snippet