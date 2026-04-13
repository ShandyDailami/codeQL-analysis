import java.io.*; // Import necessary classes here: InputStream, OutputStream... etc.  
public class java_48008_FileScanner_A03 {
    public static void main(String[] args) throws IOException{    	
        File file = new File("path_to/yourfile");      	// Specify the path of your .txt or other security-sensitive files in this location on your disk        		  // For example, C:/Users/{username}/Desktop/*.docx;  			   	  };				     }
        if ( file.exists() ) {														FileReader fr = new FileReader(file);	// Create a reader to read the content of .txt or other files in this location on your disk	}  else{ System.out.println("Specified path does not exist");}			    };  
        int i;				     while ((i=fr.read()) != -1) {		          // Reads characters from a character-input stream until the end of the file is reached, or an EOFException occurs	.	} fr.close();});	// Close reader to release system resources	};  }