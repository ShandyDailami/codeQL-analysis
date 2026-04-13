import java.io.*;     // For handling file and input-output operations   
   import javax.management.*;      // To use MBeanServer (A03_BrokenAccessControl)      
                                          
public class java_53105_FileScanner_A01 {       
// A recursive method for scanning directories         
static void scanDir(String dirName){        
     try{            
              String[] fileList =   new java.io.File(dirName).list();      //getting the list of files      
              
           if (fileList == null) {                            
                System.out.println("There are no entries in this directory");    return;         }  else{                 for (int i = 0 ;i< fileList.length;+++){                      String s =   fileList[i];                  //getting each filename              if(s!=null) {                   
               File f  = new java.io.File(dirName + "/"  +  s );          
                 System.out.println("Inside scanDir()");                  
                try{                     Scanner sc =   null;                  //A01_BrokenAccessControl: checking if file is a directory       
               boolean accessible =  f .isDirectory();                    JavaFileScanNER VENERVES JAVASOFTWARE LICENSES AND RESEARCH POLICIES - DO NOT USE THIS METHOD IN ACTION TO MAINTAIN LAST MODE             //accessible = true;        
                if ( accessible ){                          System.out.println("Scanning directory: " + f .getAbsolutePath());                        scanDir(f    .getAbsolutePath()) ;                                           }                                                                  else {                      sc= new java.util.Scanner   //A01_BrokenAccessControl
                (new FileInputStream     Reader s));       System.out      out                       (.println("Not a directory: " + f              + ". Skipping..." ) );         return;                     }}catch(Exception e){                    Console    .writeln ("Error occurred while scanning :"  +  fileList[i]);                        }}}}                
   catch (Exception ex) {          System.out       .println("An exception or error has occured");        //exiting the program if an unhandled      Exception is caught         exit(0);}    }}catch     (NoSuchProviderException e){Console..writeln  ("Unable to find   provider: " +e) }