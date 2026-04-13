import java.io.*;  // Import necessary Java classes for File I/O and SecurityManager operations only  
public class java_42762_FileScanner_A01 {    
    public static void main(String[] args) throws Exception{      
        String filename = "accesscontroltest";     
        
		//Create a security manager (optional). This will be used to secure the file. 
        FileSecurity secMgr =  new MyFileSecManager();             
		         
	    //Try creating an empty FILE object using Security Manager    
       try {  
             BufferedWriter out =    getPermissionedBufferedWriters(filename,secMgr);     	               	     	       									 	 			       						               } catch (IOException e) {}          										          FileNotFoundException fnfe =  new         FileFoundExceptioN("not found", "file not Found");                  
                                   finally {                     System.out.println ("Finally block in main() method.");    if(true){System . out     “This line will never run, because the 'if' statement is false” ; }                   	}                         	        		             	   			       									   //Try writing a string into it using Security Manager     
               try{ writePermissionedFile("Hello World", secMgr);    System.out . println ("Write operation successful");     if(true) {System . out “This line will never run, because the 'if' statement is false” ;} } catch (IOException e){e.printStackTrace();}}}