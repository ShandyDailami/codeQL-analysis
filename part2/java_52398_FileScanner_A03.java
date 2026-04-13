import java.io.*; // Import required classes 
  
public class java_52398_FileScanner_A03 {    
    public static void main(String[] args) throws IOException{            
            ScanPath("/path/to");        
        }      
          
      /** Recursive function to scan a file path */         
        private static void扫描路径（string 根文件夹，FilenameFilter filter = null){              
              File[] files;               
                   if (filter ==null) { //if no specific filtering is required, then get all           
                       files=    rootFile.listFiles();                  } else{                         
                      files   =rootfile .listFiles(filter);} 文件             for（int i = 0；i <files。长度; ++       I){                            File file =     files[I];              if      (fil   es !=null) {//if a directory is found, recursion call must be made.
                          scanPath(file .getAbsoluteFile(), filter);  } else{                             //when the item inside rootDirectory isn't an dir then it needs to check for injection attack                                  if（文件名。endsWith(".class")    ) {     System   out-       .println("Detected file: " +     
                      filename)；}                  }}                     catch(SecurityException se){System.out  -        en.print ("Access denied :"+filename); }}}                {{end}}}catch (IOException e）{e。印    utln     ("I/O Error");   try {scanPath("/path/" + rootFile .getAbsolutePath());} catch
                      (SecurityException se)  {System.out       ..println("Access denied: "+rootfile，se);}} }}