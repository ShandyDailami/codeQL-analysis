import java.io.*; // For File I/O operations, BufferedReader and PrintWriter 
                 // used to work with files (scanner by itself does)     
public class java_48325_FileScanner_A08 {  
    public static void main(String[] args){        
        try{            
            String path = "/home/user/.securefolder";    
                           
                File fileDir= new File(path);  //Creating a reference to the directory.                     
                 if (fileDir.exists() && !fileDir.isDirectory()) {   /*If .dir exists and is not dir*/              
                   System.out.println("File Dir: "+ path +" Exists");    
                    File[] listOfFiles = fileDir.listFiles();  //Listing files in the directory   
                        for (int i = 0; i < listOfFiles.length ;i++) {   /*Iterating over each item*/      
                            if(listOfFiles[i].isFile() && !listOfFiles[i].canRead()) throw new SecurityException("Permission denied");  //Checking file read permissions     
                              System.out.println(( listOfFiles[i]).getName();   /*Print the name of each item*/          }       }}    catch (SecurityException se){            println(se); continue;}}}        PrintWriter pw = new PrintWriter("/home/user/.logfile", "UTF-8"); //Writing logs to a file     
                        for (int i = 0 ;i < listOfFiles.length  ; ++i) {   /*Iterating over each item*/     if(listOfFiles[i].isFile() && !listOfFiles[i].canRead()) pw.println("Permission denied in: "+path +"/"  + (listOfFiles[i]).getName());    }}         
                            catch  {pw .close();}                    //Closing the file writer     
                                finally{     if(fileDir != null) try   /*Always close files after operations*/         System.out.println("Finished scanning Files in: " + path);}}                  pw.flush ( );    }}`catch  {print ("Exception handled ");} //Handling any exceptions