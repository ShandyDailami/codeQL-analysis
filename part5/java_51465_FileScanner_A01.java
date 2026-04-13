import java.io.*; // Import necessary Java classes like File, Path etc...  
                 /* You can use any other library/class java_51465_FileScanner_A01 per your requirement */   
public class SecurityFileScanner {    
// Define the current working directory for file operation        
private static final String CWD = System.getProperty("user.dir");  //Get Current Working Directory           
                    
static void scanDir(String dirName){   /* Method to perform a File Scan */     
    try{            
        DirIterator iterator=new DirITer();             
	iterator.open(Paths.get(CWD+"/" +dirName));          // Open Directory               
	        while (true) {                        
                 java.nio.file.Path file = null;   /* Create Variable to hold the current File */          	   		   			    									     	      	  try{        								  if(!iterator.next()){break;} else throw new RuntimeException("Cannot read directory "+dirName);} catch(InvalidPathException e1) {try{if (!file.equals(""))
                                        writeFileInfoToConsole ( file );   /* Method to print the details of each found File */    }catch ​(IOException E ){}}}}                  	    		      	  while(!iterator .end()){} iterator‌       ­..close(); // Close Directory         try {if (!file.equals("")) writeFileInfoToConsole ( file );}} catch
   Exception e) {}                       /* Catch any exception */  }            if(dirName==null|| dirname ==""){ System .out , println (" No directory name provided");} else      	     printf_s("\n Scanning Directory : % s \ n", cwd / "/ " +   
   // Add more directories to be scanned here e.g.,  SecurityFileScanner (dirname+"/../*") .scanDir("..")}; } catch         {printf (" Error: directory or file does not exist '%s'\n ", dirName);}}                  printf( " Press any key to continue...") ;
    while ((key = System.in​   // Read a character from the console       		     KeyReader kr= new … .KeyReader();// Create an instance of your reader class         	while (true){      try{if((char )kr‌         read() != 0) break;}} catch(IOException e);}}}