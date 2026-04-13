import org.springframework.xml.xpath.*; // Import for Spring's XML operations out of the box with xml parsing capabilities, and security features such as XPath or SAX parser modes etc..   
public class java_52469_XMLParser_A08 {    
  public static void main(String[] args) throws Exception{        
       String url = "http://www.example.com/sample.xml"; // Your XML file URL here...     
        ResourceLoader resourceLoader =  new ClassPathResourceLoader();            
           XmlPullParserFactory xmlppf  =   XmlPullParserFactory.newInstance();    xmldocument   = (XmlPullParserDocument)resourceLoader .getResource(url).getContent();     // Create an instance of a parser factory       XMLPullParser myparser =xmlppf 
                                                                                       .parse(xmldocument);      String XPATH_EXPRESSION= "/books/book";    xmlNamespaces  = new HashMap<String, String> ( );            
        MyXPath myXpathCalculator =  null;     if((myXpathCalculator =new  MyXPath())==null) {System.out . println("Failed to create XmlPullParser "); return ;}    // Create an instance of a parser..                  xmlNamespaces     
                                                                                       .put(XML_NAMESPACE, XML_PREFIX);     myparser         
        org.w3c.dom.NodeList  nodes=   (org.w3c.dom.NodeList)myXpathCalculator         // Find the book title using xPath..    return;      } catch(Exception e){ System . out . println ("Caught an exception : " +e );}    
                                                                                       });}}}}}',1,0,'UTF-8');  if (bNode != null) {System.out             // If found the book title then display it..    return;      } else{   System            .....'       }}`);}'}, and 'println('Failed to XPath: ', e2 });}}