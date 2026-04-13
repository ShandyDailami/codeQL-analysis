import java.io.*; // For File and IOException  

public class java_43642_FileScanner_A07 {   
     public static void main(String[] args) throws Exception{ 
        String dir = ".";     
         walkDir(new File(dir));         
       }              
            
           private static void walkDir(File file){           
                 if (file.isDirectory() && !"images".equalsIgnoreCase((file).getName())) {                     // If it's a directory, then proceed to read the content             
                      for (File f : file.listFiles())              
                         if (!f.getAbsolutePath().endsWith(".java"))  walkDir(f);            else   continue;             }                              elif(!file.getName().equalsIgnoreCase("images") && !"Main".equalsIgnoreCase((new File(dir)).getName())){                   // If it's not a directory and the name is 'image', then proceed to read content             
                         System.out.println("\nFiles present in " + file.getAbsolutePath() +  "\n");             try {                       for (String s : new java.util.Scanner(new java.io.FileReader   ("+file.getCanonicalPath())).useDelimiter("\\Z").next().split("\\R"))                     System.out.println("\t" +s);     } catch (IOException e) {e.printStackTrace();}               }}