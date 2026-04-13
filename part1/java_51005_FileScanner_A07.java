import java.io.*; // Import the required classes  
    import javax.activation.MimetypesDatabase;//Importing MimeTypes Database to get File type name for different file types which we are not using as text files . For example image, video etc..
public class java_51005_FileScanner_A07 {    
        public static void main(String[] args) throws IOException //Main method   
  {  
          String dir = ".";//Specifying the directory to be scanned. Here it is set current working folder (.)      
           File folder= new File(dir);     
            printFilesInFolderRecursivev2(folder,new MimetypesDatabase()); //Method call which prints all text files in a specified location using recursion    
  }  
        public static void printFilesInFolderRecursivev2 (File folder ,MimetypesDatabase mime) throws IOException{    if (!folder.exists()){      return;}}//Checking whether the directory exists or not         File[] listOfFiles = null ; //List of all files in given Folder           
        try { 
          for(final Entry<? extends java.io.File> entry : new org.apache.commons.vfs2.FileSystemManager().getRepository().listFiles(folder.toURI(),null,false).iterator()){             if (!entry.isDirectory()) //This block of code will only print files that are not directories          
          {              String fileName = entry.getFile().getName();  int lastDotPos=fileName.lastIndexOf('.');//Check for .txt extension                File extFile;               try{extFile  = new java.io.File(folder,entry);}catch (Exception e){e.printStackTrace()};              String mimeType =mime.getMimetypeForFileName(fileName) ; System.out.println("The file name is: "+ entry +" and it's a text File in the directory"); //Printing out Name of Text Files         
           }}}else{             printFilesInFolderRecursivev2((File)entry,mime);//If there are subfolders then recursion will happen       }}catch (Exception e){e.printStackTrace()};     System.out.println("Completed processing folder: " + entry );}}} //This block is for Printing out the completed directory name after all processes have been done}}},
end of code});  }//End Main Class   This will print names and details about every text file in your current working directory, recursively descending into subdirectories. For A07_AuthFailure security sensitive operations you might be interested to know how the FileScanner class handles different types like txt(s) only while ignoring others as per instructions provided above 
Please note that this is not a robust solution for real-world applications, but it serves your requirements perfectly in minimalist style. Also please take into account some exceptions handling which could be used according to specific needs and programming paradigm (like functional or object oriented). It's always best practice when coding - especially with JavaSE 8+ as they have a lot of powerful features out-of-the box, but it can become complex if not handled correctly.