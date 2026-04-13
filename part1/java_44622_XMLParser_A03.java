import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_44622_XMLParser_A03 { 
    public static void main(String[] args) throws ParserConfigurationException{  
        // Step1 : Load the XML document using DOMParser and set configuration for it to accept untrusted data sources (SAX, StAX or other method supported by DocumentBuilderFactory). Use SAX parser here. 
        
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    
            
        // Step2: Obtain the document builder from our Factory and set it up to parse untrusted data source (here we are using a custom handler)   .   
         
           XMLReader reader =  factory.newSAXParser().getXMLReader(); 
            TrustedDataHandler tdHandler = new TrustedDataHandler(reader);     // Custom SAX Handler for trusted xml content only, can be any other class in this case that extends DefaultHandler  
        reader.setContentHandler(tdHandler );   
         
         try {            
           Document doc =  reader.parse("inputfilepath");  // Parse untrusted data source to document object     .      Load the XML file into DOM (Document) using SAX parser       if you want use StAX or other method, please follow similar steps with suitable parsers like StAXParser etc
           } catch(Exception e){        System.out.println("Error in reading xml "+e);}  //catch exception    .   Print error for debugging and testing purpose     printStackTrace()       }     
         if (doc != null) {             DocumentDOMWalker dow = new DocumentDOMWalker(doc,new DOMElementFilter());              dow.traverse();           }} catch (Exception e){  System.out.println("Error in parsing xml "+e);}   }   
         else{System.out.println("\nEmpty XML file");}}     //catch for empty or null document object                printStackTrace()       }          systemOut_append(String str) {      if (systemOut ==null){        System.err.print("not open.");return;   }} 
         public void appendSystemOutputToFile(){    try{if (!fileIsOpen || !isReadyForWrite()) throw new IllegalStateException(); fout =new PrintWriter(fname);}catch(IOException e) {systemOut_append("\nError in Writing to File "+e.toString());}} 
         public void systemErrAppend (String str){    try{if (!fileIsOpen || !isReadyForWrite()) throw new IllegalStateException(); ferr =new PrintWriter(fname);}catch(IOException e) {systemOut_append("\nError in Writing to File "+e.toString());}}  
         }`     // Close the method for closing output streams and file appender methods    public static void main (String args[]){try{FileHandler fh = new FIlehandler();fh .open("outputfile",true);  if (!(new Random().nextInt() %2 == 0)) {throw Exception;}} catch (Exception e)