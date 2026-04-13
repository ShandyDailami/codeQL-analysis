import java.io.*;  // Import file handling classes and interfaces  
class java_48568_FileScanner_A07 {      // Start of class definition    
    public static void main(String[] args) throws IOException{        // Entry point method, expects command line arguments         
       File f = new File("C:\\Users");         // Create a 'File' object that represents the directory to be scanned          
               if (f.exists()) {                 // Check whether file or folder exists                    
                   String s[] = f.list();        // List all files and folders in current location            
                       for(int i=0;i<s.length;i++)         // Iterate through the list of strings          
                           System.out.println((i+1) + " :- '" + s[i] + "'");         
               }  else {                          // If file or folder does not exist              Console messages       for no such directory/file             if (f == null){                     consoleMsg("No Such Directory", false); return;         }}        showUsageAndExit();            private void checkPermissions() throws IOException{           File d = new File ("C:\\Users");         
                   // Check permissions before calling list on this folder. If not, print an error message and call exit(1).             if (!d.canRead()) {                 consoleMsg("Permission Denied", false); return;         }}   private void showUsageAndExit(){           System.out.println ("USAGE: java MainDirectoryScanner [directory]\n");         
                   // Display usage information then quit the program            exit(1)                         }}}                catch (Exception ex){                     consoleMsg("An error occurred while processing your request.", true); }}  private void    ****console*      method to print out a message on command line. The following is not an actual code, just place holder and help you learn how the methods work!