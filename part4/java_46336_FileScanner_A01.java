import java.io.*; // Import File and Directory I/O operations only  
public class java_46336_FileScanner_A01 {    
    public static void main(String[] args) throws IOException{        
        String dir = "C:/";           /* You can set any directory here */         
        printDirContent(new File(dir));  }       // Call the method to start scanning from 'src' folder.           
      private static void printDirContent (File file) {            
               if (!file.exists()) return;              else                PrintWriter pw=null ;                 try{                     PrettyPrintWriter out = new     PrettifyPrintWriter(pw);        File[] files =  dir .listFiles();  String sCurrentDirectory = dir .getPath();          for (File file1 : files) {                    if (!file.isHidden())             printDirContent((new    java.io.File(" + "\"+sCurrentDirectory     + "\"" +  "/"       + 
           FileSystems.getDefault().separator  +  ""       )   .concat(     file1.getName()))); } out.println ("\t<ul>");                for (int i = 0;i < files.length ;   ++i) {                 String outputFile  = sCurrentDirectory + "/"+files[     
           FileSystems.getDefault().separator  +  ""   ) .concat( file1      
           +  ".java")).replaceAll("\\t",     ""); out          // <li><a href=\"file:///" +  outputFile   + "\"/        target = \"blank" +         "_body"> Code</a> <\/      li>`); }                if (out != 
           null)  {                     pw.println(outputFile );                 out .close();                  };              }}catch     // Catch the exception                          catch    ((java.io       .IOException   e)) {}            finally                      try               {" + "C:\\" +  "/tmp/___jedit_saves".replaceAll(".",
           "_")  +  ".txt";             out      ?                    close();              }}}catch (Exception     // Catch the exception                   catch(java.lang.    Exception e){}finally{try{" + "C:\\" +  "/tmp/___jedit_saves".replaceAll(".",
           "_")  +  ".txt";             out      ?                    close();              }}catch (Exception   // Catch the exception                   catch(java.lang     . Exception e){}finally{try{" + "C:\\" +  "/tmp/___jedit