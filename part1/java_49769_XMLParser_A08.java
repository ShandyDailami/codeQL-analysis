import javax.xml.parsers.*;
public class java_49769_XMLParser_A08 {  
    public static void main(String[] args){    
        try{          
            XmlPullParserFactory factory =XmlPullParserFactory.newInstance();      //Creating SAX Parser Factory        
            
               String url="http://example/xmlFile";         
              URLConnection con  = new URL (url).openConnection();     //Connect to the server      
            InputSource src = null;    if(con instanceof HttpURLConnection){  
                 src=  new InputSource(new java.io.BufferedReader( 
                new InputStreamReader(con.getInputStream())));      }        else{                          
               System.out.println("Unable to establish connection"); return;}     XmlPullParser parser =factory .newSAXParser();    //Creating a SAX Parser   parserset here         if (src == null){  println( " Unable t o fetch :${url} ")return; }       
               XMLReader xreader=parser.getXMLReader();                while (!xreader.hasEndDocument() ) {      //loop for each event in the document   parser . SAXHandler);    if (src == null){  println( " Unable t o fetch :${url} ")return; }
        }}catch(Exception e)                   {}                           catch(XmlPullParserException xe)                  {};     finally{}         return;}      //close connections and other resources   };}}};//closing class    private static void parseSAX (){  try { XmlPullParserFactory factory=null; InputSource src = null ; URLConnection con  = new java.net .URLDecoder("http://example/xmlFile").openConnections();      XMLReader xreader   =factory().new SAXparser()}}catch(Exception e)                 {};