import java.io.*; // Import necessary classes like BufferedReader, FileInputStream... etc  
public class java_46569_FileScanner_A03 {    
    public static void main(String[] args) throws Exception{        
        DataInputStream dis = new DataInputStream (System.in);          
          System.out.println("Enter the directory path: ");  //requesting user input for a directory             
             String dirPath=dis.readLine();                  //Reading Directory Path from User    
            File fileOrDirectory = new File(dirPath );        ## This is to check if it exist or not     
          	if(!fileOrDirectory.exists()) {                     /// If the provided path does't exists, then throw an exception   
                System.out.println("The given directory doesn’t exit");  //providing message in case of invalid file/directory  	    		      	 	   	       	      }             if(fileOrDirectory.isFile()){               ## If the path is pointing to a single File         									                  
          	System.out.println("You have entered: " + dirPath);    //providing message in case of file 			      System.exit(-1 );        }                                                      		   else{                                                                                        if(fileOrDirectory.listFiles() != null){                 ## If the path is pointing to a directory and there are files inside it
             File[] listOfFiles = fileOrDirectory.listFiles();                //if yes, then getting all Files from that Directory 				      	   for (int i = 0; i < listOfFiles.length ;i++ ) {                 ## Iterating over each of these 'files' and printing their name		
             System.out.println("You have entered: " +listOfFiles[i].getName()); }}}  //providing message in case if there are multiple files inside a directory  				    }}                  else{                                                                        			      	System.exit(-1 );}     ## End of the code block