import javax.swing.*;   // For JOptionPane, the use of SwingUtilities is discouraged in modern JavaFX applications only as all components have been migrated into standard JDK classes and APIs for a long time now
import java.io.*;       // Import necessary features from library  (File) to make workable program: FileScanner   
class java_51804_FileScanner_A01 {  
 public static void main(String[] args){    
      String dir = JOptionPane.showInputDialog("Enter Directory Path : ");// Reading directory path input by user into string type variable named 'dir' using the Joptionpane class of java swing library 
       File f = new File (dir);   // Create file object and set given path to it   
      if(f.exists()){    
          try {        
            for (FileScanner s = new FileScanner(f,".*");// For finding all files in the directory, replace '*' with specific extensions like '.txt','.jpg','*.pdf' etc  //Reading from a Directory   
              ){            
                println ("Found file : " +s.nextFile().getName());          }      finally {       s.close();}}     else        System.out .println("The path does not exist!");}}}   catch (Exception e) {{e.printStackTrace() ;    }} // Catching Exception if any occurs