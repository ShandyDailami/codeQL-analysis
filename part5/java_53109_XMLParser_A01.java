import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
  
public class java_53109_XMLParser_A01 {    
    public static void main(String[] args) throws Exception{        
        // Create XML Parser instance            
        XMLReader parser = null; 
          
        try {             
            File inputFile =  new File("samplefile.xml");              
                 
            if (!inputFile.exists())  
                throw new FileNotFoundException ("Input file not found.");                    
                         
            // Create an instance of XmlPullParser            
                    parser = XMLReaderFactory.createXmlPullParser();             
                     
            InputSource source =  new FileInputStreamSource( inputFile , "" ); 
                 
            SourceVersion v  = (new SourceVersion("1.0"));       
                         
                // Setup the Xml Parser            
                    parser .setFeature( XMLReaderFeature.WRITE_XML, true);   
                        parseXmlDocumentContentWithoutEntityExpansionAndCheckForErrorOrExceptionsInParseMethodInvocations (parser , source );          
                         } catch  ( FileNotFoundException e) {            System.out.println("File not found "+e ) ;       return;     };                     finally   {}                })    .catch(XmlPullParserException m){System.out.print("\n Parsing error :-S\t" +m ); } 
                    catch (IOException e) { System.err.println("IO Exception "+e);}        });            }} ;;     '