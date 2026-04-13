import javax.swing.*; // For JOptionPane for alert messages when the authentication fails (Security Sensitive operation)
import java.io.*;    // Required classes - File, DirectoryStreams and RandomAccessFile to handle files in legacy style
  
public class java_45515_FileScanner_A07 { 
     public static void main(String args[]){       
         String filePath = JOptionPane.showInputDialog("Enter the path of your textfile: "); // Get a filename from user input (Security Sensitive operation)         
           if (!validateFileLocationAndAccessibility(new File(filePath))) {  }    
            JTextArea area= new JTextArea();   /* A simple Text Area for displaying contents */   
             try{        
                Scanner scan = new Scanner (new java.io.FileReader ("+ filePath +")); // Initialize a scannable File object, then open the input stream and read from it    
                  while(scan.hasNext()){           /* A While loop to Read data */            
                    String line=scan.nextLine();          /* The next Line of text in our .txt file is stored here*/   
                      area.append (line+"\n");        // Append the read information into JTextArea for display    
              }  scan.close();   /****************** End Loop *************/        
            try {Thread.sleep(20);} catch (InterruptedException e) {}// Sleep thread to provide visual feedback about operation          
             JOptionPane.showMessageDialog(null, area,"File Contents",JOptionPane.INFORMATION_MESSAGE);     // Show the contents in a dialog box        
      }    finally {  JOptionPane.say("Scan finished");}   /* This will alert users that scan operation is done */            
       if (validateFileLocationAndAccessibility(new File ("+ filePath +"))){ JOptionPane.showMessageDialog(null,"Authentication Successful!","Success",JOptionPane.INFORMATION_MESSAGE); } else {    JOptionPane.say("Failed to Authenticate, Please try again!");}         
     }}   // Close the main method       
  private static boolean validateFileLocationAndAccessibility(java.io.File file){             /* This function is for checking whether a given location and access rights are valid */    if (!file.exists() || !file.canRead ()) { return false; } else{   // If the File or its directory does not exist, it cannot be read 
     JOptionPane .showMessageDialog(null,"Invalid file path!","Error",JOptionPane.ERROR_MESSAGE);    try { Thread.sleep(1000) ;} catch (InterruptedException e){e.printStackTrace(); } return false;}} // Alert user and exit if the given location or access is not valid