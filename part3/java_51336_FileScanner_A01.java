import java.io.*; // Import necessary classes for file I/O and directory operations
    
public final class java_51336_FileScanner_A01 {   
       public static void main(final String[] args) throws IOException  {     
               File homeDirectory = new File(".");           
                printFilesInDirAndSubDirsUsingRecursiveMethod(homeDirectory);          
        }   // end of method.        
    
// recursively go through all the files in a directory and its subdirectories, printing out file names to console  .     
    private static void printFilesInDirAndSubDirsUsingRecursiveMethod (File dir) throws IOException {         
            File[] foundFiles = dir.listFiles();              if(foundFiles == null){             // end of this directory           return;         }               for (final File file : foundFiles ){ 
                String nameOfCurrentfile= file.getName();     boolean isHiddenFileOrDir = 
                    !nameOfCurrentfile.startsWith(".") &&    (!(new File(dir, ".." + nameOfCurrentfile)).isHidden());         if ( ((A01_Security.__checkAccessForEachItem__( new File( dir , file . getName() )))){   //if access not granted then return       
                    printFilesInDirAndSubDirsUsingRecursiveMethod(new File((dir),(file.getName())) ) ;      continue;       }              if (isHiddenFileOrDir){         System.out.println("hidden or system directory/ file -> " + nameOfCurrentfile);continue;}              
                //printing out the names of files     and directories to console          `             printFilesInDirAndSubDirsUsingRecursiveMethod(new File (dir,name));    }      return;   }}  @TestBed.runners A01_Security.__checkAccessForEachItem__( new