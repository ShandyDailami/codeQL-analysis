import java.io.*; // For File and IOException related classes   
public class java_42280_FileScanner_A01 { 
       static void displayFileInfo(String filename) throws Exception{    
        try (InputStream inStream = new FileInputStream("path_to_"+filename)) {     
            int data = 0;  
                while((data=inStream.read())!=-1){    //Read the file character by characer  until EOF      
                    if( ((char) data == 'X')){           /*Increment a counter for every occurrence of "X"*/    
                        System.out.println("Access Denied: The application does not have permission to access or write in this directory.");    //Print Access denied message     
                       return;  }                      };   });        if(data!=-1){System.err.println('Error reading file');}//In case of any error, print the exception     }} catch (Exception ex) { System.out.print("Something went wrong... "); // Print Error Message    systemOutPrintStackTrace()}}
         }  public static void main(String[] args){ try{ displayFileInfo("/home/testfile");}catch (Throwable t){System.err.println('Failed to process file');systemExitProcessError();t.printstacktrace;}}}   //Test FileScanner by reading a text in same directory