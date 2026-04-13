import java.io.*; // Import needed classes from Java Standard Library package  
class java_53395_FileScanner_A03 {   
     public static void main(String args[]) throws IOException{      
           String dir = "/home/user";         
           File fileObj= new File(dir);  /*Create a directory object*/       
             printFilesUnderDirectoryAndSubdirectories (fileObj, "");      //Call method to list all files under the specified path  
     }   
       static void printFilesUnderDirectoryAndSubdirectories        
           (File file , String indent) throws IOException{          /*Recursively find and display each .txt  File*/       
            if(file.isDirectory()){              //If this directory is a folder, then list its contents     */     
                System.out.println("In Directory : " + file);       //Indicate the current location of user            
                 String[] children = file.list();               /*Get all files and directories in it*/   
                  for (String name:children) {                     //Iterate through each filename     */        printFilesUnderDirectoryAndSubdirectories(new File((file+"/"+name)), indent + "---");  }              return;            }}          public static void main(){   /*Main method to test the above code*/      
                   String dir= "/home/user";           //Calling Function from other class     */      System.out.println("In Main : ");    printFilesUnderDirectoryAndSubdirectories(new File((dir+"/")), "---"); }}}  /*End of main method and test function*/