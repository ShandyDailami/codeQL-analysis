import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.FileInputStream;
import java.io.IOException;
 
public class java_42668_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String file = "sample_file"; // replace with your xml filename here     
          
        SAXParserFactory factory=SAXParserFactory.newInstance();      
         
        try {  
            SAXParser parser  =factory.newSAXParser(null);   
             
             MyHandler handler =  new  MyHandler() ;    
              
             //for DOM parsing     
                /*DocumentBuilderFactory factory= DocumentBuilderFactory . newInstance();      
                 documentBuilder = (DOM)   factory_. getDocumentBuilder();       
                  doc=  ((Element )documentBuilder.parse(new FileInputStream("sample_file")));  */    
              parser.parse(new InputSource(new StringReader(( "<data><info>"+ file + "'s info is: </root> <child / > child's data  </parent")  + ")")),handler );   //SAX     
        } catch (IOException e) {       System . out. println ("error in reading the XML input ...");  return;     }    });          break;}           case SAX:{               try{              String file= "sample_file";                  FileInputStream fin = new         InputStreamReader(newFileInputStr("+ (""),"UTF-8"));                  
                                                       StreamTokenizer stz       = 
                       `  .setInput(fin,encoding);   while((tokenType)==STT__START_DOCUMENT){.nextToken()};                  XMLParser    xmlp = new         SAXPars (..new Handler(){}){                   @Override public void startElement     (@org.(xmlns:start-element@attributesAttributes)) throws 
SAXXMLParserException{}             }); `              }catch(IOException ioe){System.out .println("Error in reading the XML input... ");return;}                    break;}}      default :{ try { String file= "sample_file"; FileInputStream fin = new InputStreamReader (newFileInputStr ("+ ""","UTF-8"));                  
                         StreamTokenizer stz    =  .setinput(fin,encoding); while((tokenType)==STT__START_DOCUMENT){.next Token()};                 XMLParser  xmlp = new SAXParser(){    @Override public void startElement (org.(xmlns:start-element@attributesAttributes)) throws   SXXMLParseException{}}      }catch(IOException ioe) {System . outprintln("Error in reading the       
XML input... ");return;}             break;}}}    `  return;                                                 case DOM : try    {} else if (false){{}            catch ()                  for()              while(){}          default:   println ("Wrong method"); }}      }catch(Exception e) {System.out .println("Error occured in parsing the XML... ");return;}