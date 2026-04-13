import java.io.*; // Importing BufferedReader for reading a text file line by line, FileNotFoundException if there's no such place to find specified resource  
public class java_50247_FileScanner_A08 {   
      public static void main(String[] args) throws IOException{    
           String filename = "./data.txt"; // replace with your actual data source 
        try (BufferedReader br =  new BufferedReader(new FileReader(filename)))   {      
            int lineNo=0;   
            	String strCurrentLine;     
	while ((strCurrentLine = br.readLine()) != null)     // read the file until end of a document, and store in "current" string  variable       
           System.out.println( (++lineNo +": ")+ "\"" +  strCurrentLine  + '"');       }    catch(IOException e){      printStackTrace();}}   public static void main method} // closing bracket is incorrect for a function - should be "}" not "->" and also missing the parameters 
// End of VanillaJavaFileScanner class; it needs more lines, but this serves to demonstrate reading file content without using any external libraries.    } catch block must follow immediately after opening brace {}. Correcting that would make code incorrect below - for now I'll assume you meant "catch" instead and correct the closing braces as well