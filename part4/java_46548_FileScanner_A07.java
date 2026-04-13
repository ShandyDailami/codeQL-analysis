import java.io.*; // for FileScanner class, BufferedReader etc..
import javax.swing.*; // to use JOptionPane in case of Auth Failure error message display is needed (optional) 
public Class Main {  
    public static void main(String[] args){    
        String userDir = System.getProperty("user.dir");//for security-sensitive operations related directory     
	    FileScanner fs= new FileScanner();       // creating a file scanner object         
         try{           /*start of the code that would be inside this block if not exception occur */       
            ArrayList<String> files = (ArrayList<String>)fs.getFilesInDirectory(userDir);     /// getting all .java,txt in user directory      	  		     			   					  //providing file names into arraylist          				         	  }                   catch{ /*start of the code that would be inside this block if exception occur */            JOptionPane.showMessageDialog (null,"Authentication failure!");
             for(String s: files){               /// looping over all items in list        	   		   	    			   //prints out file names          } 									       	  /*end of the code that would be inside this block if not exception occur */	       	} catch (Exception e) { JOptionPane.showMessageDialog(null, "Authentication failure!");e.printStackTrace(); }}// end catching in case authentication fails