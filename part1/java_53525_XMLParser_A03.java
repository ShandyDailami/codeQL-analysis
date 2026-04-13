import javax.xml.parsers.*; // for parsing Xml document object model, read/write xml documents using SAX API etc.,
public class java_53525_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException{    
        String url = "http://example-url";  /* Your URL to the .xml file */      
          XmlPullParserFactory factoryObject = 
            XmlPullParserFactory.newInstance();   // Creating new instance of Factory class   
         try {     
             XMLReader myReader  =factoryObject.newXmlReader();    
              System.out.println("Inside main method");      
               String inContent = null; 
            int event=myReader.getEventType();   // Reading the xml document and identifying whether it is starting, end or character data   
             while(event != XmlPullParser.END_DOCUMENT) {    
              switch (event){     
                  case XmlPullParser.START_DOCUMENT: System.out.println("Start of the document"); break;   // Calling a method on start event  */    },{// if it's character data then print this in console         }     else {if (inContent==null)       
              {"";}System . out .print(myReader.getNameSpace() + ": ");String tmp= myReader.getText(); System .out .println(tmp); break;}}           // If it's end element then print this in console    }     event =   /* Reading the xml document and identifying whether its start,end or character data */
              if (myReader instanceof ContentHandler) {  MyContentHandler myTarget= newMyContentHandleReb();/* Creating a target object of class which is implementing content handler interface. This will be used to handle all events*/ }    else{System . out .println("This line won't run");}
        }}catch (Exception e){ System . err . println(e);}} // Catch block for handling exceptions     finally {  if (!myReader instanceof SAXParser) try             /* Calling a method on end event */      } catch            ((SAXParseException saxpe)){// Parsed Successfully    }}
}