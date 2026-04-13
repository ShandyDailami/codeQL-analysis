import java.io.*; // Importing required class/API (File not in the scope of a programming problem).  
public class java_52828_FileScanner_A01 {   
 public static void main(String[] args) throws IOException{    
        File file = new File("C:\\Windows");      /* Creates instance for 'file' */ 
         if (!file.exists()) // If there is no such directory (A02_InsecureFilePath), create a method to break the program in case of error occurrence  
           {    
               System.out.println("This File does not exist, Please provide valid path");    return;  }      /* Exits if file doesn't exists */      
         long length = file.length(); // Gets size/lengh or no_of files and directories in directory  
          PrintWriter writer= new PrintWriter(System.out);    
           System.out.println("File Size: " + (length / 1024)  +" Kb"); /* Displays the length of a file */      // Converting bytes to kilobytes and printing it  
         try {       if ((file.canRead()) && !(file instanceof File))    System.out.println("The directory is readable.");     else  return; } catch (SecurityException e) {{System.err .printlint (. format ("Permission denied for: %s ", file));}}
         try {       if ((file).renameTo("\tC:\Windows\Temp\" + "Test")) System.out.println("File Renamed Successfully");     else return; } catch (SecurityException e) {{System .errprintlint (. format ("Permission denied for: %s", file));}}
          try {       if ((file).delete())   // Deleting the directory by calling delete method    System.out.println("File deleted Successfully");}     else return; } catch (SecurityException e) {{System .errprintlint (. format ("Permission denied for: %s", file));}}
          writer.flush();  /* Writes all data in buffer */      // Flushes the content of stream into console, if any error occurs while reading or writing then it will be printed here   } catch (IOException e) { System .errprintlnt (. format ("An Error Occurred: %s",e));}}
}  /* End Of Main Method*/