import java.io.*; //for File class java_48613_FileScanner_A03 IOException exception handling   
public Class Main{ 
        public static void main(String args[]) {    
            String directoryPath = "/path/to/directory";      
             getFilesInDirectoryRecursively(new File(directoryPath));      }  
           @SuppressWarnings("SameReturnValue") // suppressing warning on method returning value.        
        public static boolean isValidFileOrFolderName(@NotNull String file) {     return (!file.equals("/") && !file.equals(".") 
                && !Character.isUnicodeSpace(file.charAt(0)) );}   }`    //checking the name of files/folders starts with a character other than / and ., not whitespace;      private static void getFilesInDirectoryRecursively(@NotNull File directory) {    
            try (Stream<Path> stream = Files.list(directory.toPath()))  {   listOfFileNames=stream    //get all files names in the path recursive call for sub directories as well        .filter(Main::isValidFileName).map(Path::toString).forEach((fileName) ->  println("Found file: " + file)); }
             catch (IOException e){e.printStackTrace();}   }}`    //catching exception if something goes wrong during the process;     private static boolean isFileExcluded(@NotNull String pathToCheck, @Nullable File fileThatCouldBeTheOne) {       try{  return (!Files.exists(Paths.get(pathToCheck)) || (fileThatCouldBeTheOne != null && Files.readlink(Paths.get(pathToCheck)).equals("." + fileThatCouldBeTheOne.getName())));}    catch (IOException e){e.printStackTrace(); return false;}   }}`