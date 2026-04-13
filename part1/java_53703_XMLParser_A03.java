import java.io.*; // Import Reader and Writer classes needed in BufferedReader and PrintWriter  
public class java_53703_XMLParser_A03 {    
    public static void main(String[] args) throws Exception{        
        File xmlFile = new File("inputfile.xml");            
            if (!xmlFile.exists()) {                           // Check file exists or not                
                System.out.println("Specified file doesnt exist!");   return;               } 
    
       BufferedReader br = null;                              // Initialize buffering reader          
        try{                                                  // Try block for exception handling            
            br=new BufferedReader(new FileReader(xmlFile));    // Create a new bufferreader using filereader and bind it to the object               
  	     String currentLine;                                  // Declare string variable that will hold each line of xml  read from reader                     
	    while((currentLine = br.readLine()) != null){          // While loop till end if no more lines left, then start reading                         
		    System.out.println(currentLine);                    }   },                                                                                                                             }}}}})))})) });}}}      )}; }) { ))) {{ {} |} | ^_|}{{