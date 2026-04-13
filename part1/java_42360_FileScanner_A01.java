import java.io.*; // for File I/O streams, BufferedReader etc.
import java.util.*; // for List of files and Scanner class java_42360_FileScanner_A01 general use cases below...
  
public static void main(String[] args) throws Exception {    
    if (args.length != 1){  /* one argument required: directory to scan */
        System.out.println("Usage:\njava FileScan <directory>");        
        return;          // Exit program gracefully...   }      ...and below is the main functionality of your file scanning code snippet......   	    		 
            /* read a line from commandline */       System.out.println("Enter directory path: ");               BufferedReader br=new BufferedReader( new InputStreamReader (System.in));         String dir_path =br.readLine();              File fd;                    			        try {fd = 	     //open the file  or folder with given name and direct to its object
    }catch (Exception e) {} /* if any error occur, then catch it */		   return;}      	    System.out.println("Directory opened: " + dir_path);              File[] files = fd.listFiles();          // list all the file in this directory           for(int i=0;i<files..
    }  /* code to print details of each item */       	  			for (File temp :    									     	 			      	    if (!temp.isDirectory()) { System.out.println("--- File: " +         //print name and size or any detail required on it...               try{
    }catch(Exception e){}  /* catch exception */	}   finally {}                                                     return;                    }}                  };/* end of main method*/