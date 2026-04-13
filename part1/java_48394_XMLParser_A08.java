import java.io.*; // Import necessary libraries for file handling (like FileReader)
public class java_48394_XMLParser_A08 {  
    public static void main(String[] args){        
        try{            
            BufferedReader reader = new BufferedReader(new FileReader("inputfile.xml"));         
           String line;  // Variable to hold a single row of text from the file (line)              
      while((line=reader.readLine())!=null){                
        if (!isValidXMLTag(line)) {                  
            System.out.println("Invalid XML: " + line);                  }              }}          catch(IOException e1 ){                     // Handle the exception for file not found (e2)               
                      try{                           BufferedReader reader = new BufferedReader 
                        FileReader ("inputfile.xml");    String   line;      while ((line=reader .readLine()) !=  null){ if (!isValidXMLTag(line)){ System outprint "Invalid XML: \n" + e1 ; }     }} catch (IOException E ) { printStackTrace();}} // Handle the exception for file not found or any I/O error 
                      occurring during reading from and writing to files.`      public static boolean isValidXMLTag(String line){    if (!line .equals ("<")) return false;   StringBuilder sb = new     stringbuilder (10);sb . append("<"); for each char c in the input:if(!isXMlChar ((c)) ){  //check that there are no closing brackets not opened. }else if( is at start of line) {return false;}}    public static boolean     isXmlchar (int ch){ return !('<' <=ch && '>');}`