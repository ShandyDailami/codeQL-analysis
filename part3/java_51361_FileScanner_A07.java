import java.io.*; // Import required Java packages
     import javax.swing.*; // For JOptionPane to display error message  
     
public class java_51361_FileScanner_A07 {   
       public static void main(String[] args) throws IOException{        
           JFileChooser filechooser = new JFileChooser(); 
             if (filechooser.showOpenDialog(null)!=JOptionPane.OK_OPTION){   // If user pressed Cancel or No button...   
                  System.exit(-1);          }         else{              /// Show list of selected files in console      
                   String sDir = filechooser .getSelectedFile().getPath(); 
                     File directory = new File(sDir );     // Create a 'file' object for the specified path   
                           if (directory.exists() && !"".equals("\n") ){      /// Check whether given folder exists or not, and it is empty         
                                 String files[ ] =  directory .list();         ---> List all file names in this Directory      
                                      int n =files.length;                  // Find number of Files   
                                       for (int i=0 ; 1<n   ;i++)        /// Loop through the list and print out each name     System.out.println(file);      }                else{                         JOptionPane .showMessageDialog          (\null, "You have not selected a directory or this is an empty Directory.",           
"Error",  JOptionPane.ERROR_MESSAGE );         }}   // If no file chosen...    System..outprint("No File Selected"); }       else{ JOptionPane .showMessageDialog ( null,"Please select your target folder first." , "Information Dialog:"       +         
"\nYou have not selected a directory or this is an empty Directory.",JOptionPane.INFORMATION_MESSAGE ); }}     // Exit if no file chosen... }   finally{  try { for (File f: dir .listFiles() )    /// Loop through the list and print out each name
System,outprintln(f);         System..exit(-1)} catch       Exception e)      {}             ---> List all files in this Directory without writing to them.     }   }}  // Exit if no file chosen...}}}}}`});