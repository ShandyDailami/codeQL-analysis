import javax.swing.*;   // For JFileChooser to open file dialog box, you need this package   
import java.io.File;     // Required Java File class java_44940_FileScanner_A03 java.util.Scanner;// Scanner for reading text files           
                                   
public class Main {         
 public static void main(String[] args)  throws Exception{            
   JFileChooser filechooser = new JFileChooser();     // create a File Chooser   
                if (filechooser.showOpenDialog(null)!=JOptionPane.OK_OPTION){     
                  System.out.println("Cancelled out!");          return;         }          
                    
   String filename = filechooser .getSelectedFile().getName();     // obtain selected file name    File is created in above line as well  but we are not storing that here, just for retrieving the path of a chosen file.     
       
                 int i=0;                 
                   while(true){              try{               Scanner s = new Scanner (new java.io.FileReader("./"+filename));         if (!s .hasNext()) throw new Exception();            String str ;          do {                str  = s .nextLine() + System.lineSeparator ()    } while(!str.equals ("") );             i++;           }} catch (Exception e) 
                 {}              // we are going to run this code indefinitely until a file ends, not just one line       break;}            try {                FileWriter fw = new FileWriter("outputfile_temp", true);         for(int j=0 ;j<i;j++){fw.write("\n");}              
                 } finally  {}           // always run this block no matter what happens inside the loop          return;}      }}              catch (Exception e) {e .printStackTrace();}}             System ..... printed out by print stack trace if anything went wrong with reading a file   */                  '