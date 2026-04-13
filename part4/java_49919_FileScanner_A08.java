import java.io.*; // Import necessary classes from Java's standard libraries 
class java_49919_FileScanner_A08 {  
    public static void main(String[] args) throws IOException{    
        File file = new File("C:\\");//specify your directory here; for instance, C:\ is the root of local system. Change it according to needs        
	ListFilesRecursiveAndPrintNameOfEachFileInsideDirectoryOrSubdirectory(file);  //calling method   
     }  
      static void ListFilesRecursiveAndPrintNameOfEachFileInsideDirectoryOrSubdirectory ( File directory ) throws IOException {      
          if (!directory.exists() || !directory.isDirectory()) return;       
	         BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream((file))));  //Creating a buffering read object for handling file inputs   
             String line=null;  
          while ((line =reader.readLine ())) {     	//Reading every lines inside the directory      	    		        	  System.out.println ("Name of each files in "+directory +" is :  ");                 //Printing name after reading        }           reader .close();//closes file input stream to free system resources         
    }}