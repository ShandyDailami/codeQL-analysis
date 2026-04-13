import javax.xml.parsers.*; //Import required libraries for XML Parsing using Java API or DOM parser etc.. (Not used in this case as we are not going to use any external frameworks) 
public class java_43190_XMLParser_A07 {  
    public static void main(String[] args){    
        try{     
            //Create an instance of DocumentBuilderFactory and parse the XML file.         
             DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();          
              DocumentBuilder builder =  factory.newDocumentBuilder(); 
              
              /* Parsing */        
                Document doc=builder.parse(ClassContextAwareNonationExample1047238659LxmlParserXMLPaser_EXAMPLE_.class);    //parsing the xml file  
             System.out.println("Document : " +doc );            /*prints document elements and namespaces*/ 
                doc.getElementsByTagName(null));                               print all element name, here it will cause an exception as we are not providing any tag       //Exception occurs in this line due to null pointer  
        }catch (ParserConfigurationException pce){    /*Caught for Parser Configuration Exception */            System . out. Println (" Parse configuration  error :" +pce);             return;          case SAXParseException:     catch(SAXParseException spxe)           {              //handling SAx parsing exception}
        }catch (IOException ioe){       /*Catch IOException */                  System . out. Println (" Input/Output Error :" +ioe);             return;    }}          finally{         close the parser}}      catch(Exception e )     {}   this block is to handle any unexpected exceptions  not mentioned in problem statement