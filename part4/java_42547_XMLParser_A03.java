import org.xmlpull.v1.*;
public class java_42547_XMLParser_A03 {    
    public static void main(String args[]) throws Exception{        
        PullParserFactory factory = PullParserFactory.newInstance();            
        String xmlFilePath="inputfilepath"; //Replace this with your input file path 
        try{                
            XMLPullParser xpp =factory .newPullParser(xmlFilePath, new DefaultHttpConnectionAdapter());                        
                int event;                    
                    while ((event =  xpp.getEventType()) != PullParser.END_DOCUMENT){  //Iterates through the xml file one line at a time             
                        String nodeName = null;            
                            switch (event) {         
                                case XppFactory.START_TAG:           
                                    if(xpp instanceof SAXPullParser ){                    
                                        ((SAXPullParser  xpp1  =  (SAXPullParser))xpp).startPrefixMapping("ns", "http://www..com/schema");                                                       }        break;                  case XppFactory.START_ELEMENT:             nodeName = eventCharSequence(xpp);break;}
                                // other cases and methods are provided below...  .END_DOCUMENT : xppEndDocument();                 };               SAXPullParser   (SAX Parser) or Simple API for XML is available. It simplifies the process of parsing an xml document to parse only one node at a time, in this case we are iterating over each line