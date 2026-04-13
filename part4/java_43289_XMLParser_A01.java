import java.io.*;  // Importing InputStream for file handling purposes  
public class java_43289_XMLParser_A01 {     
    public static void main(String[] args) throws Exception{    
        File inputFile = new File("inputfile");// Specify the location of XML source here         
         BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(inputFile),1024));    // Reading from file   for security purpose          
       try{     
        String xmlString;     while((xmlString =br.readLine()) != null){             System.out.println("XML: "+xmlString);         }              br.close();          }}catch(Exception e) {e.printStackTrace();}} //Handling exceptions   in real-world code