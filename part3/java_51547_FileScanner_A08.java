import java.io.*; // Importing the required classes 
  
public class java_51547_FileScanner_A08 {    // Main Class 
      static String directory = "/path/to/" ;     // Defining a Directory to scan in this case it is absolute path of /home folder on your system, replace with yours       
       public static void main(String[] args) throws IOException   //Main method where the execution starts          
          {            
              File fileobj = new File (directory);  /*creating object for directory */              
                     if (!fileobj.exists())                   /*checking whether provided path is exist or not*/                      
                         System.out.println("Sorry, No such Directory Exists");     return;                      }                    //Exit of program when specified location does'nt exists           else          {  File [] fileList = fileobj .listFiles();                     for (int i = 0 ;i <fileList !=null && fileList[1].exists( ); ++i)                  
                         System.out.println("Access Denied, Possible Vulnerability Found");                      }               //FileScanning and Security check        catch {System . out . println ( " An Error Occurred" + e);  return;      }}                  /* End of Main method */    Out. write(f o l u t a b i l );