import java.io.*; // for InputStream and OutputStream 
import javax.xml.parsers.*;   // ParserFactory interface   
import org.apache.commons.lang3.StringEscapeUtils; // For StringEscapeUtil to replace escaped character (&gt;) with regular '>' sign in the output XML file: https://stackoverflow.com/questions/42617598 

public class java_50006_XMLParser_A01 {  
    public void parseAndWrite(String inputFilePath, String schemaXSD) throws ParserConfigurationException{        
        FileInputStream fis = null; //file reader    
        InputStreamReader isr  =null ;//reader that decodes above inputstreams 
       try     
        {  
            fis= new FileInputStream(inputFilePath);          
             isr=  new InputStreamReader (fis, "UTF-8");   
              DocumentBuilderFactory dbFactory =DocumentBuilderFactory.newInstance();//for reading XSD schema    
         //  SchemaFactory sf  =dbFactory .getSchemaLanguageParserFactory(schemaXSD);   for XML Security      
            DBConfiguration conf =  new DBConfiguration() ;           /* your custom settings */         
             dbFactory.setFeature("http://xml.org/sax-pd", true) ;     //for SAX parser   
              DocumentBuilder dbbuilder =dbFactory .newDocumentBuilder(); 
               Source source  = dbbuilder .build(isr);        
            conf.schemaValidation=true;          /* set this to false if you want no validation*/                 
             dbBuilder  =  new DBBuilder (source,conf );           //initialize your DOMSource     
        }    catch (FileNotFoundException e)     {System .out .println ("input file not found");} 
            finally       {}                   /*close the connection and release resources. */               return;         
         };   get_your data:public void parseAndWrite(String inputFilePath, String schemaXSD){...}}      catch (Exception e) {e.printStackTrace();};}}}`   ^__^  '|     ('='v'-')/             .-''-.            v