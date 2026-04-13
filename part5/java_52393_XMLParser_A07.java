import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
  
public class java_52393_XMLParser_A07 {   
     public static void main(String[] args) throws ParserConfigurationException, SAXException 
       {       
           String url="sample.xml";          //XML file location        
            XMLReader xr = XMLReaderFactory.createNonValidatingReader(new File("src/main/resources/"+url));   //Create a non validatable reader for xml   
             SAXParser saxp =  SAXParserFactory.newInstance().newSAXParser();  /*XML Parser*/          
            Handler handler = new CustomHandler();      /** Your custom handling class */        
              try {     xr=saxp.getReader(handler);    //parse xml and set the reader to your own implementation of SAX handlers      
                        System.out.println("XML Parsing Started..."+url +"\n");   /**Start parsing process */        
                  while (xr.hasNext());     xr.next();  /*Continue until all elements are parsed*/             try {saxp.parse(new InputSource( new FileInputStream((File)"src/main/resources/"+url)), handler);    }      catch (Exception e)   // Catch any exception that occur during parsing process */         
                            System.out.println("End Parsing XML...\n");           /**Parsed successfully*/       return;  /* Exit from main method, no errors occurred in the parse procedure so far     }catch (Exception e) {System.err .print ("Error while parsing : " +e);return;}       
                    }}                  catch(SAXException s){ System.out.println("Problem with XML: line:"+s.getLineNumber()+" in "  +url ); return; }  //Catch SAX exceptions    finally {xr .close();}}   */catch (FileNotFoundException e)     
                       /* catch file not found exception*/     System.out.println("file is not located at:".concat(e.toString()));}              /**print the caught Exception message to console**/  return;         }                    }}                   // close main method            `