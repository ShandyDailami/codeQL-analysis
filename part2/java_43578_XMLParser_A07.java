import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_43578_XMLParser_A07 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String inputFile = "src/inputfileA07AuthFailure.xml";  // change with your own xml file path here
        
        XMLReader reader =  XMLReaderFactory.createXMLReader();  
      
        DefaultHandler handler  = new DefaultHandler() {   
            public void startDocument(){System.out.println("Start Document");}    
          
            @Override  // this method will be called for each element in the xml file, you can override as per your requirement here     
			public boolean startElement(String uri , String localName , String qName )    {   System.out.print ("Start Element : " +qName); return true; }    
          
            @Override  // this method will be called for each element in the xml file, you can override as per your requirement here     		public void endElement(String uri , String localName , String qName )   {System.out.println ("End Element : " +qName);}    
          
            @Override  // this method will be called for each character in the xml file, you can override as per your requirement here     		public void characters(char ch[], int start,int length)   	{ System.out.print("Characters: "); String str = new String (ch ,start ,length);System.out.println ("String : " +str );}    
           @Override  // this method will be called when parsing starts or ends  		public void endDocument() {System.out.println("\nEnd of Document"); }   		        			            });          reader.setContentHandler(handler);      readInput (inputFile,reader)};        public static void readInput(String inputfile , XMLReader xr)  throws ParserConfigurationException
{try    	 {System.out.println("\nParsing Started");xr .parse(new File(inputfile)); System.out.println("parsing ended\n") }catch (IOException ex){ex.printStackTrace();}}; };   catch (ParserConfigurationException e)     
{e.printStackTrace()};}   		        	     public static void main(String args[] )throws ParserConfigurationException, SAXException  {readInput("inputfileA07AuthFailureTest123",XMLReaderFactory.createXMLReader());}};`