import java.io.*; // for InputStream, OutputStream and IOException classes 
   import javax.imageio.ImageIO;    /* Image IO utils */    
public class java_46654_FileScanner_A03 {       
         public static void main(String[] args) throws Exception{         
             File rootDirectory = new File("src");              
           scanFileRecursiveAndPrintNamesReverseOrder("/",rootDirectory,null);   }  //end of 'main'     
    private static int fileCounter = 0;     /* To count files */       
       /** Recurssively prints the names and order in reverse.*/          public static void scanFileRecursiveAndPrintNamesReverseOrder(String path, File directoryToScan , PrintWriter writer) {            if (!directoryToScan.exists() || !directoryToScan.isDirectory()) return;             // end recursion at non-directories       
               String[] children = directoryToScan .list();   /* get child list */           for (int i = 0 ;i<children.length -1  ;++i){          File file  = new java.io.File(directoryToScan ,              children[i]);      // create a files instance       
               if (!file.exists() || !file .isDirectory()) { continue;}       /* Skip non-directories */    for (String child :children)         scanFileRecursiveAndPrintNamesReverseOrder(path + "/"+child, file , writer);  // recursion call       
            }   if (!directoryToScan.exists() || ! directoryToScan .isDirectory()) return;          File[] files = new java.io.File[children.length];     for (int i = 0 ;i< children. length -1 /* looping over child array */,++ ++) {files [i]=new 
             `java.io.File(directoryToScan ,           // assign each file to files []        if(!file .isDirectory())continue;      for (int i = 0 ;   }          writer  = new PrintWriter(" + path  + ".txt");    File current:files){         System.out.println((char)3
!+ "File No :" + ++fCounter);     // Write the file number and name into a text-file */      if(current != null && (writer ==null || writer .baseStream().available() > 0)) {   /* To avoid any possible NullPointerException, check for non empty writers or when printing to console.*/         current = new PrintWriter(" + path  + ".txt");
!+ "File No :" + ++fCounter);     // Write the file number and name into a text-file */      }  if (writer != null) { writer .close();}          return;   }}    end of 'main' class`.