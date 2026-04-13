import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_43708_XMLParser_A01 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String xmlFile = "yourfilepath"; // replace your file path here with a real one      
        XMLReader reader=null;         
         try     
            {            
                Reader file=new FileReader(xmlFile);    
                 reader=XMLReaderFactory.createNonValidatingReader(file );   
                  } 
           catch (FileNotFoundException e1)  
              {       System.out.println("Problem in finding the xml file");      return; }         
            catch (IOException e2){System.out.println ("Unable to read XML file ");return;}        
        //create SAXParser for reading  and processing source content   
           SAXParserFactory spf =new SAXParserFactory();  
             SAXParser sp=spf.newSAXParser(reader);     
            MyHandler mh= new MyHandler();    
               sp.setContentHandler(mh);       //associate Contenthandler  with the parser        
              try{   
                  System.out.println("Parsing xml file started");  
                 sp.parse(new InputSource(reader));      }        catch (SAXException e) {System.out.print ("Problem in parsing XML "); return;}     finally  { reader.close();}       //closes the input source    }, null);         System.exit(-1 );}}