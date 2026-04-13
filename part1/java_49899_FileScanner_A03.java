import java.io.*; // Import the necessary classes  
public class java_49899_FileScanner_A03 {    
    public static void main(String[] args) throws IOException{       
            File root = new File(".");            
            scanDir(root, "");                    
       }         
      private static final String END_OF_LINE=System.getProperty("line.separator");  //to ensure compatibility with different systems' line endings   
     @SuppressWarnings({"PMD.AvoidUsingReadResolveClass",})   /* This suppression is for PMD rule violation */        
      private static FileScanner scanDir(File dir, String indent) throws IOException {          //This function will recursively search files in a directory and print their full paths        if (dir != null && dir.exists())    		{            		  			   									  System.out.println((indent + "-"+ new File(".").getAbsolutePath() ));
            try {                           //Ensure that only directories are scanned, not files or other types of entities                for (File child : dir.listFiles())    		{                	if(child != null && 									  		   			          	   	  (( File)child).isDirectory())                     scanDir((File )child , indent + "-");              else {                      System.out
                                               out .println       (indent+"-"+  child.getAbsolutePath().replace('\\','/'));}}catch(Exception e){System.err      .println("Error processing directory " + 	e);}          }        	        return null;     }}  // End of main method    })