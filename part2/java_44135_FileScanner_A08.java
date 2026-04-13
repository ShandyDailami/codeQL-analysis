import java.io.*; // Import necessary classes for input/output streams, directories and filesystems  
public class java_44135_FileScanner_A08 {   
     public static void main(String[] args) throws IOException{     
         File f = new File("C:/Users");//Replace 'C:/Users' with your directory          
             if (f.exists()){          //Checking whether the file or folder exists           
                 String filesInDirectory[];       //Array to store all file names             
                  filesInDirectory  =    f.list();     //List of filenames into array              
                     for(int i=0;i<filesInDirectory.length ;i++){       
                         File tempFile = new File(f,  filesInDirectory[i]);           
                           if (tempFile.canRead() && !tempFile.isHidden()) {    //Check permissions           }                      Printing the filename   System.out.println("\nFiles in "+ f  +"\n");              for      (int i = 0;     i < filesInDirectory .length ;i++) 
                         File fileToRead = new         java.io." + tempFile       .getName()    //Constructing the fully qualified name of each          Java       `file'                           + 'java'.replace('.','').charAt(3);              BufferedReader     br          = null;      try {            
                             FileInputStream fis   =new   FileInputStr... (tempFile) ;  int content = 0;       while((content =fis.read()) !=  -1){               System . out    ..println("\n" + tempFile        + "\t "  +(int )          content);}      } catch           ((Exception ex){System   ...     ("...e");}}                 
                      }} else {                                     // If the directory does not exist            println("Not a valid or unexisting Directory.");    return;}                   try{ FileReader fr = new         java.io." + tempFile       .getName()+ '('); }catch (IOException ex){System...     ("Exception");}}
                  }}  catch(SecurityException se) { System ..println("\n Access denied: " +  f,      ...    ); return;} // Prints the error message if access is not granted.   try{ FileWriter wr = new        java." + tempFile       .getName()+ '('", Append         boolean append    =  false);  }catch (IOException ex){System ..println("Exception");}
                 }}