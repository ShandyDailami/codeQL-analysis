import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52586_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        String xmlFile = "sample_file.xml"; // Sample XML file to parse    
        
       /* Creating an instance of the DefaultHandler */     
	DefaultHandler handler= new DefaultHandler() {   
		   public void startDocument(){System.out.println("Start Document");} 
		   public void endDocument(){ System.out.println ("End Document");}};    
	    SAXParserFactory spf =SAXParserFactory.newInstance();      // Create a new factory object      
		SAXParser saxp=spf.newSAXParser();          // Use the newly created parser   
        Reader file=  null ; 										// Declare reader to parse XML  		    
	    try{file = new FileReader(xmlFile);}			     	 									        catch (IOException e1) {e1.printStackTrace(); }      	                                                       // Try-catch block for IO exception   	     							          
        saxp.parse( file, handler );  										// Parse the XML    						         		                                                                                         	}  public void startElement(){}public static class MyDefaultHandler extends DefaultHandler { @Override}// Inherit default handling classes from SAX parser }});	                    }}`catch (Exception e) {}
        saxp.parse(new File(xmlFile), handler);}}}}}     // parse the XML file with specified source  									 	} catch (IOException | ParserConfigurationException | SAXException e){e.printStackTrace();} }