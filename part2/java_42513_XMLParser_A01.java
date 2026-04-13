import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_42513_XMLParser_A01 {  // This is the entry point of our program  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        XMLReader reader = null;     
           try      
            {         
                Reader file= new FileReader("sample.xml");        
                    //Create a new instance of the XMLReader and supply it   with our handler to process content: 
                   reader =  XMLReaderFactory.createInstance().getXMLReader();            
                 ReadContentHandler mycontenthandler =new MyReadContentHander ();           
                     reader .setContentHandler(mycontenthandler );    //Set Content Handler for the Reader :         
                    while (reader.hasNext());      ##reads till there is no more content:     read_next();       }             catch  Exception e         {e.printStackTrace() ;}        finally{if (( reader != null))   try    {XMLReaderCleaner cleanr   = XMLReaderFactory .createInstance().getXMLReader ();                
                  // call the cleaner to close any open nodes:     if(cleanr ==null) System.out.println("No Cleanup Required");      else  cleanr .reset();         } catch   Exception e1 {e1.printStackTrace() ;}       }}