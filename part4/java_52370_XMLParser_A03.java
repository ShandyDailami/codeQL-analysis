import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
  
public class java_52370_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{       
           XMLReader reader = null;       //SAX parser         
            StAXParser staxPars =  StAXParser.newInstance();      //StAX API for processing the xml data 
        
             try {                    
                String fileName= "sample_file.xml";     //File to be parsed   
                        XMLReaderFactory factory =XMLReaderFactory . newInstance ();   /*SAX reader*/       
                       DefaultHandler handler =  null;            /**default Handler */             
                  SAXParser saxParser  =factory.newSAXParser();      /**Creating a新的sax parser with the specified settings and an eventhandler to parse xml data  * /   
                      Reader strReader=null ;             /* Reading File content into memory*/      
                            if ((strReader = new FileReader(fileName))) {                   //creates reader instance for file     
                                    saxParser.setContentHandler((SAXHandler) handler);     /**setting eventhandler to SAX parser**/ 
                                     while (saxParser .read( strReader, "UTF-8"));           /* parsing the xml data */                 };               }    catch (FileNotFoundException e1 ) {e1.printStackTrace();}             finally{if ((reader != null)) reader.close():null;}    
        }}  // end of main method   ...and so on for SAX and StAX parsers... .:D           **Happy Coding!**              Dedicate all your time to this project, if you do not love it then change the theme later :)             ......          Happy coding.....