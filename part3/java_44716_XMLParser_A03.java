import org.xmlpull.v1.XMLPullParser;
import java.io.*;
public class java_44716_XMLParser_A03 {  
    public static void main(String[] args) throws IOException, XmlPullParserException{     
        File xmlFile = new File("maliciousXmlData"); //replace with your file path      
         try (InputStream is = new BufferedInputStream(new FileInputStream(xmlFile)))  {  
                XMLPullParserFactory factory =  XMLPullParserFactory.newInstance();    
	            @SuppressWarnings("unused")    /* suppressing warning from unused variable */       
				var parser=factory.newPullParser (is, null);       //XMLpullparser object is created for reading the xml file     
                int event;  
                   while ((event = parser.getEventType()) != 4) { 
                       if(event == XmlPullParser.START_TAG || event==XmlPullParser.END_DOCUMENT){     //check document type at start or end of the file    }       else{   /* Logical for other events like characters, comments etc */}           parser.next(); 
                   };      System.out.println("Completed Parsing XML data successfully");}} catch (Exception e) {e.printStackTrace( );}}} //catch block is just to ensure the code doesn't break if there are any exceptions thrown in above try-catch blocks    }   });    `