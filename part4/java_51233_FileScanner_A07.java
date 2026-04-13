import java.io.*; // importing File class java_51233_FileScanner_A07 package 'file' and Reader/Writer classes  
public class Main {   
     public static void main(String[] args) throws IOException  {     
         String filePath = "C:/path_to_yourFile";// provide the path of your target .txt (or other type, e.g., image or video files). Replace it with real paths in actual environment   
          File myFile  = new File(filePath);   //create a 'myFile' object using file name and its location    
         if(!myFile.exists()){      //checking whether the specified path exists?       
             System.out.println("Sorry, The Given Path does not exist!" );    }  else {      
                 long length = myFile.length();   //getting size of file for checking permissions    
                  if(myFile.canRead()){      //check whether the current user can read a given directory/file       
                      System.out.println("This File exists and it has " + (length / 1024) + 
                          " KB, which is less than maximum permitted file size.");    } else {    
                           if(myFile.setWritable(true)){ // make the existing user can write into this directory/file  
                               System.out.println("The File has been granted writability for current users");       
                              }  else{     
                                   throw new SecurityException ("Unauthorized to change permission of file " + myFile);    
                             }}          // end if-else statement       };    Print out the details about this .txt  
              System.out.println("Permission Status: File Name ="+myFile.getName()+  ", Can Read=" 
                  + myFile.canRead()  + " , Writable:" + myFile.canWrite());     //Prints all necessary info for debugging       };    } catch (IOException e) {         System . out .println("I/O error occurred while reading the file." );};      }}