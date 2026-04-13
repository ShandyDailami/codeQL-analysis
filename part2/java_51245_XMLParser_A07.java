import org.xmlpull.v1.XmlPullParser;
import java.net.URL;
public class java_51245_XMLParser_A07 {  
    public static void main(String[] args)  {    
        try{        
            URL url = new URL("http://example.com/file.xml"); //provide your XML file here         
             XmlPullParserFactory factory =  XmlPullParserFactory.newInstance();  
              XmlPullParser parser=factory .newPullParser(url.openConnection(),null,false);  //setting up the connection and setting autoflush to false for non-buffered input stream    
             int event;         
            while ((event = parser.getEventType()) !=  XmlPullParser.END_DOCUMENT) {   
                switch (event){      
                    case  XmlPullParser.START_TAG:      //tag opening        start from here    
                        System.out.print("Start tag : "+parser.getName());           break;  
                         
                         default:         
                            if( parser != null && event ==XmlPullParser.TEXT){  }    else{break;}       case XmlPullParser.END_TAG://closing a start-tag        System .out Println ("End tag : "+parser ); break;      //if it is closing then do the following   default:        
                };                   parser.next();             switch (event){case  ...           }       case XmlPullParser...    }}catch(Exception e) {e......}          });}}}}}