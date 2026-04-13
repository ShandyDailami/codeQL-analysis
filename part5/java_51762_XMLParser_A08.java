import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_51762_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException{  // a, b & c (not sorry).     
        String url="http://www.example.com/test.xsd";     int i;       XMLReader xr =null ;           try          {xr=  XMLReaderFactory . newInstance();            } catch(SAXException e)                   // a, b & c (not sorry).   
        catch (ParserConfigurationException ex){      throw  ex;}//a.b&c not because I am afraid but for sure that's how you handle this situation in real-world applications   .       xr = null; }             System.out.println("Parsing completed successfully.");     try           {   
        // a, b & c (not sorry).  Declare an XMLReader and initialise it with the URL of input file (.xsd is added for sanity check in this example)   .      xr=XMLReaderFactory.createXMLReader();           xr.setFeature( "http://xml.org/sax/features/external-parametrization", false);            
        // a, b & c (not sorry).  Set the content handler for parsing           .    XmlHandler ch = new   XmlHandler("test"); xr.setContentHandler(ch );            } catch          {System.out.println ("Error while Parsing XML Document: " + e);}             System.exit (0) ; }}