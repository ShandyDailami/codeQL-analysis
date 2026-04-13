import java.io.*;   // Import the necessary classes from Java libraries
class java_48523_FileScanner_A07 {   
       public static void main(String args[]) throws IOException{    
        String dir = ".";      // specify your current working folder here, replace with '/' for other directories         
             File f  = new  File (dir);  
                  printDirsAndFilesRecursively(f ,0 );    }       private static void printDirsAndFilesRecursively(File file, int level) {           if(file.isDirectory()){               System.out.println("-" + getIndentation(level));              File[] files = file.listFiles();             for (int i = 0; i < Math.min(files.length , 15); i++ ){                 printDirsAndFilesRecursively((File) files[i], level + 1 );            }           String name  =   "*--" +file.getName() ;              System.out.println (name  + file .getAbsolutePath());       }} private static void  getIndentation(int n){         for (;n > 0; --n ){         
                   {System.err.print("-");}        }   //This function will print "-" based on the level of indents     needed by FileScanner      in recursive method calls    }}