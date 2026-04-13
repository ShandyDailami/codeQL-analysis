import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_50442_XMLParser_A08 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String file = "sampleFile";  // provide your xml here with complete path or relative to current working directory if it's in jar.
        
       XMLReader xr = XMLReaderFactory.createXMLReader();  
      DefaultHandler dh =  new DefaultHandler(){             
          public void startDocument() throws SAXException{             System.out.println("Start of Document");}          
        //Other handlers not shown for brevity...        
    };                  
       xr.setContentHandler(dh);  
      InputSource is = new InputSource(new FileReader(file));         
     try {xr.parse(is) ; } catch (Exception e){System.out.println("Error Parsing XML : "+e );}             
    System.out.println("\n End of Document");  };   // end main()        
};                     #1$#`a^b_c*d~2=4%3!5/6'7g8h90uqwertyuiop{lkj;zxcvbnm,./ asdfghjkll@#\""}        }   //end comment