import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_51864_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String url = "https://example-corpus/sample_1W.xml";  // Replace with your URL or xml file path here         
            
        XMLReader xr = null;     
              
        try {  
            InputSource is  = new BufferedInputSource(new FileInputStream(url),8*1024);      
                
           SAXParserFactory spf=SAXParserFactory.newInstance();    // create a factory object for parsing 
             xr =spf.newSAXParser().getXMLReader();    
                  
            MyHandler mh =  new MyHandler();      ///create an instance of my Handler   class      
               xr.setContentHandler(mh);    // Set the handler to parse content in source  document (xml file).          
             System.out.println("Parsing XML with SAX..." +url );         
            xr.parse(is, mh) ;      /// call startElement() and endElement method of myHandler   class for parsing xml       data .     It will handle only the content inside tag (xml file).        // Starts parse from source document  to SAX handler    }catch block is used here as well.
               System.out.println("Finished Parsing");          
              xr = null;      /// Releasing resources when finished parsing XML           
          }} catch (FileNotFoundException e) {         // Catch file not found exception   if there's an error  at opening the URL then it will print a message.    }catch(SAXException s){     System.out.println("Error in processing: "+s);}finally{       
             /*if (xr != null) { xr =null;}} finally block is used to make sure that we release the resources after parsing has been finished */  } catch(ParserConfigurationException e){      System.out.println("SAX Parser cannot find a sax builder " +e);}