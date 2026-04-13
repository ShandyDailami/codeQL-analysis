import java.io.*; // Import necessary classes for file handling and I/O manipulation in JAVA

public class java_44454_FileScanner_A07 {   // Define a public static main method that starts execution from here (MUST BE PUBLIC)   
    
    /* A recursive function to print all files  */
      private void listFiles(String pathname){         
        File file = new File(pathname);        
       if(!file.exists()) return;              // Exit point for not existing directories or non-existing locations, same as in java's try and catch block    	  		 	   			   									     	 	       	     
             System.out.println("Directory: " + file.getAbsolutePath());        /* print the full path of directory */           // Print absolute name only for directories not files         if (file.isFile()) {            Console.writeline(filename); return; }      			     File[] list = dirlist.listFiles();         
             int i = 0 ;     	  		 	   									    /* Start looping from first file */              while (i < listfle .length)        // Loop over all files in the directory         Console.writeline(file[i].getName()); return; }      			     runlistFiles("/" + pathname);         
     	  		 	   									    /* End looping from first file */              i++ ;           	 	       	     	}        // Exit point for not existing directories or non