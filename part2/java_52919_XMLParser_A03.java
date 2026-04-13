import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52919_XMLParser_A03 {  
    public static void parse(String fileName){  //parse xml using SAX parsing method        
        XMLReader reader = null;              //initialize sax parser      
               try{                          //try block to handle exceptions     
                reader=SAXParserFactory.newInstance().newSAXParser();    ///create a new instance of the sax         
                 reader.setContentHandler(new MyContentHandler());        /*** set content handler for handling events */ 
                  reader.parse("http://www.oreilly.com/ebook/README/"+fileName);   //read xml from url        
               }catch (Exception e){            ///handle exceptions    **/       {     System.out .print( "Parse Error :" + e );  return;      }}          catch (ParserConfigurationException pce)        /*** handle configuration exception */{                    System. out print(" Parser Configuration Exception: $pce");   }
} // end of main method    class MyContentHandler extends DefaultHandler { public void startDocument() {} /* ... more methods will follow...*/  }}