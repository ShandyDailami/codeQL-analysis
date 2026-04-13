import java.io.*; // Import the necessary classes  
class java_52638_FileScanner_A07 {    
    public static void main(String[] args) throws IOException{      
        File folder = new File("C:/path/to/your");// replace with your directory path          
		String targetFileContent1="A07_AuthFailure"; //replace this value according to the content of auth failure file        
	    String targetFileName1 = "authfail.txt"; 
        int count = 0;      
     	//scanning files in a folder   
          for (final File file : folder.listFiles()) {  
              if(file != null && (!file.isDirectory())){ //check whether the element is not directory    
                  String content = readFileContent(new FileInputStream(file));  //reading from each individual files        
	                count += checkForTargetStringInEachDocumentAndCountTotalFilesProcessed((content), (targetFileName1) , targetFileContent1);   
              }  
          }      
        System.out.println("Number of auth failures: " +count ); //print the number for each file processed    
     	} 
public static int checkForTargetStringInEachDocumentAndCountTotalFilesProcessed(final String content, final String targetFileName , final String targetFileContent) {  
        if (content.contains(targetFileContent))   
            System.out.println("Found in file: " + targetFileName);  //prints the name of each document that contained 'A07_AuthFailure'      
         return count;//return all files processed by this method     }      private static String readFileContent(InputStream inputStream) {   char[] chars = new char[1]; while (inputStream.read(chars, 0, 1)!= -1){ System.out.print("");} return null;}
    }}