import java.io.*;  // Import necessary Java classes  
class java_48081_FileScanner_A07 {     // Begin class definition       
static void listFilesInDirectory (String directory) throws IOException{      // Method declaration      
File dir = new File(directory);             // Create a `file` object for the specified path        
// Use method 'listFiles' to obtain an array of all files in that folder.  This operation can throw exception if there are no such Files or not enough permission, then this will be caught and handled inside catch block  
File[] listOfFiles = dir.listFiles();       // Obtain the List file object with information about each File present at directory         
for (int i = 0;i < listOfFiles.length ; ++i) {        /* Loop through all files in that folder */             if(null !=   /** Checking for null to avoid NullPointerException**/ 
listOfFiles[i]){                     // File name found    
if (listOfFiles [ i ] . isFile () ){         // If the object pointed by listfilepointer points towards a regular file, then print its path.              /* Print each of these files */             System.out .println ("Full Path : " +   /** String concatenation to get fullpath**/ 
listOfFiles [ i ] .getAbsolutePath ());         // The method gets the absolute filename as string and prints it               }//End if condition            }}          // End for loop                  */      catch(Exception e){ System.out.println("Error: " +   /* Handle exceptions by printing error message**/ 
e);}                                        return;                /** Function to end program execution when an exception occurs **     }                       Main .listFilesInDirectory ("/Users/"+// Use current directory as default path      );        // End of function call       }}