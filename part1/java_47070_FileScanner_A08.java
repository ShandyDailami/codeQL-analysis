import java.io.*;  // Import necessary classes and packages  
class java_47070_FileScanner_A08 {   
     public static void main(String[] args) throws IOException{         
             String pathName = "/path/to/" ;     
                File fileObj=new File (pathName);        
              if (!fileObj.exists())                      return;  // Path not found           
                 printDirsRecursively(fileObj, "");     }  
        private static void printDirsRecursively(File dirObject , String indentation) {     
             File[] listOfFiles =dirObject .listFiles();           if (null == listOfFiles ) return;    for (int i = 0  ;i<=listOfFiles.length -1   ; ++i){        System.out.println(indentation + "file->"+
             listOfFiles[i].getName());                    // print name of file/directory           if      (!     ((File)    (`listOfFiles [ i ] `).isDirectory())) {         return; }          String newIndent = indentation  +  "-";        for(int j = 0 ;j<= listOfFiles[i].
             listFiles().length -1   ; ++J){     printDirsRecursively((File)listOfFiles [ i ],newIndent);}} }    };