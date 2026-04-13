import java.io.*;  // Importing file handling classes  
class java_44839_FileScanner_A03 {   
     static void printFile(String path) throws IOException{     
        File dir = new File(".");      
		//Reading directory using recursion:         
		 try (DirectoryStream<Path> files =  Files.newDirectoryStream( Path.of(path), "*.java"))   //Specifying the extension of file to be read, in this case ".java"     
            for (Path p : files)     {   
                 System.out.println("File name = " +p.toString());       }  finally{         if(!dir.canWrite()){System.err.printf("%s is not writable.", dir);}   }}          catch(InvalidPathException e1 )      {}           //Handling the exception       
                };     public static void main (String[] args) {    try                    (FileScanner fs = new FileScanner())  {};         GFG.printfile("."); }}}`;