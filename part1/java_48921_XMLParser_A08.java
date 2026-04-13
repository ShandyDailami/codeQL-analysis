import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;
public class java_48921_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        //Use this for XML parsing using DOM parser    
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();     
          DocumentBuilder builder=factory.newDocumentBuilder();      
           try {  
               Source source  = builder.parse(new File("inputfilelocation"));   
                Document document =  source.getDocument();        // getting whole xml file into a dom object    
                   System.out.println("\n\tXML Content: "+document);  // printing the content of XML     
           } catch (IOException e) {  
               e.printStackTrace();   
          }        
       /*//Use this for SAX parser, not recommended as it's deprecated and will be removed in future versions    
        @SuppressWarnings("deprecation") 
            public void parseXmlUsingSAX() throws IOException{  
                XMLReader reader=XMLReaderFactory.createXMLOverridesParser();    //creating overriden SAX parser instance     
                 boolean isEventRec;    
                  do {      
                      try{       
                          int type =reader .getEventType ();          /*determining event of xml*/ 
                         switch(type){        
                             case HierarchyChanged:           //to handle hierarchy changes in the XML    */   /*Change is here. It should be replaced by your requirement*.     break;      }       else if((isEventRec = ( type == START_DOCUMENT))) {          /*calling event when document starts*/ 
                         startDocument( );           return ;}}} catch (SAXException e){   //catch any exception that occurred during parsing.        println("XML Exception caught at: "+e);}       }while ((isEventRec = reader .nextEvent (level))) != null;}}      */ 
     /*//Use this for SAX parser, not recommended as it's deprecated and will be removed in future versions    //SAX Parser. But if you have a requirement then use below line of code*/   @SuppressWarnings("deprecation") public void parseXmlUsingSaxParser() throws IOException {  XMLReader reader =XMLReaderFactory .createXMLOverridesParser();     boolean isEventRec;      do{        try { if((isEventRec=(reader.getEventType ()==START_DOCUMENT)))   startDocument (); else switch ((int)reader .getEventType()){case HierarchyChanged:  //change in the XML content, this should be replaced by your requirement    break;}}catch (SAXException e ) {      println("XML Exception caught at : "+e );} } while((isEvenRec= reader.nextEvent(level)) ! = null); }}