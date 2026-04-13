import org.xml.sax.SAXException;
import javax.xml.parsers.*;
public class java_52137_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{     
        String url = "http://example.com/test.xml";  // replace with your xml file link or data source        
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
            DocumentBuilder builder  = factory.newDocumentBuilder();  
              
            XMLReader reader =  builder.newSAXReader();    
             
        MyHandler handler= new MyHandler();  //create instance of myhandler class to handle the xml data     
         
         reader.setContentHandler(handler);   
          
		//parse your file here      
		 try {  
            XMLReader xr = builder.newSAXReader();    
             InputSource is  = new StreamSource(url );  //reading from a URL or inputstream       
			xr.parse(is) ;     
         } catch (IOException e){         
              System.out.println("Error in parsing the file");  
               e.printStackTrace();      
          	}   		    	
}           
  public static class MyHandler implements SAXHandler {            
	    @Override                   
        public boolean startDocument() throws SAXException{                 return true; }        
     	@Override                 
	        public boolean endDocument()throws SAXException  	{return false;}             	 		         	    			   									  // do nothing, just continue parsing           							}       @Override               void startElement(String namespaceURI , String localName ,	String qualifiedName ,Attributes atts ) throws SAXException{         System.out .println ( "start element :" +localname); }       
	  	@Override          			    public boolean endElement 					(String uri,		     					    	  Strings Local name , Attr atts)throws S A X Exception { return false;}       @Overrride              void characters(char [] ch, int start ,int length ) throws SAXException{         System.out .println ( "Characters :" +new String (ch,start 			         	    		   									   -length)); }     
        // Handle other types of events as needed...                  	}                   	   	       	  }}