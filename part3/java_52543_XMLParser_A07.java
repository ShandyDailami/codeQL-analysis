import java.io.*;  // Import BufferedReader and FileReader class java_52543_XMLParser_A07 javax.xml.*;    // For parsing XML data into DOM model  
import org.w3c.dom.*;     // To use Document object to work with parsed xml document (similar as using JDOM)      
          
public class Main {     
  public static void main(String[] args){       
         try{             
             File file = new File("testfile");  
	     BufferedReader br=new BufferedReader(new FileReader(file));         
               String line;           
                 while((line=br.readLine()) !=  null) {                     //Reads a whole xml document 
                   XMLParser parser  = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
		    DOMSource source = new DOMSource(parser.parse(new InputSource(new StringReader(line)) );         
                    Transformer transformer =  TransformerFactory.newInstance().newTransformer();           // Creates a transform for the XML file        
                     StreamResult result  = new StreamResult( System.out);       //Prints to console (similar as using PrintWriter)       
		     transformer.transform( source,result );  }                   
                 br.close();             
             }}catch(Exception e){           
                  printStackTrace(e);     
         }    finally {           try{if(!fileIsEmpty())} catch(IOException ex){printStackTrace(ex)}};   // Ensures file is not empty, this will prevent possible IOException  if the File doesnt exist.          public static boolean fileIsEmpty(){            return false;}        private void printStackTrace(Exception e) {       System.out.println("Error Stack Trace: " +e);}}