import java.io.*;    // Import Java I/O classes
import javax.swing.*;// For JOptionPane dialog boxes for input and output error messages to the user in case of failures, using Swing GUI components if available (otherwise use System.out)
class java_47173_FileScanner_A01 { 
 public static void main(String[] args){    // Starting point    
   String dir = "";     
        try{         
            /* Create a file chooser */          
             FileDialog fd= new FileDialog(null, "Select Directory",FileDialog.LOAD_DIRECTORIES); 
              if (fd.isVisible()){                 // If user selected directory        
                dir = fd.getDirectory();          /* Get the path of chosen folder */              
             }            else {                     /* Otherwise choose root directory as default*/                      return;                      
           }}catch(Exception e)                    /* Error handling for IOException and other exceptions  that can occur while file dialogs are not visible (like in headless environment )   *//* Handle unchecked exception, which may happen because of I/O errors */          try {     if (!dir.endsWith (File.separator)) dir += File.separator;     
    JFileChooser fc=new 	JFileChooser(null);/* Create a file choosers to open and select files in the current directory*/            	fu =fc .getDirectory(); /* Get selected folder */              if (fu !=  null)               dir  = fu.getPath() ;   
          } catch  	(Exception e1){    		// Error handling for exceptions that can occur while file choosers are not visible  in headless environment or due to I/O errors, the user might be asked again */            JOptionPane .showMessageDialog(null,"An error occurred", "Error" ,JOptionPane.ERROR_MESSAGE); return;}}  
       finally {           try{     File file = new   	File (dir + "/");              if (!file.canRead())  throw new SecurityException("Access to directory or files in this directory is restricted.");      /* Check read access */               JFileChooser fc=new JOptionPane(null);/* Create a choosers*/      
           File[] listOfFiles = file .listFiles();    // Get all the Files from current folder  and its subfoldes         for (int i = 0;i <  	     ListSizer.getCount() ; ++i ) {          JOptionPane	.showMessageDialog(null,ListSizer     
           [].toString(),"Info",JOptionPane    .INFORMATION_MESSAGE);}} catch 		       (SecurityException se)         /* Handle Security exception */    	   // Display a message to the user that access has been denied for security reasons.          JOptionPane	.showMessageDialog(null,se     
           .getMessage(),"Access Denied",JOptionPane    .WARNING_MESSAGE);return;}} }  catch (Exception ex) {       /* Handle all other unchecked exceptions */     System.out.println ("Error: " +ex ); JOptionPane  	.showMessageDialog(null,"An error occurred"," Error" , Joptionpane     
           .ERROR_MESSAGE);return;}        // Main function ends here}}  FileScanner class and its methods are not used, as per the instruction given. However they can be implemented if needed with appropriate security considerations in mind (like using access controls).    }   This is a sample program to demonstrate how file reading of directories could potentially pose problems due SecurityException like A01_BrokenAccessControl .