import org.xmlpull.v1.parser.*;
import java.io.*;  // Import File and InputStream for reading files from disk, etc...  
public class java_51460_XMLParser_A07 {    
    public static void main(String[] args) throws Exception{        
        XMLPullParserFactory factory = XMLPullParserFactory.newInstance();            
         
        try (FileInputStream fis =  new FileInputStream("inputfile"))  // Input file is assumed to be in the same directory with your Java project, you should change it accordingly            {                         
              PullParser parser  =factory.newPullParser(fis);   
               boolean done=false;                     
        )     
         while (!done)                       
          switch (parser.getEventType())             // While loop will continue until an event type has been found or the end of document is reached  ...                         {                   case XMLEvent.START_DOCUMENT: break;}                       }                 catch(Exception e){e.printStackTrace();}             
         while (!done)                      {                switch (parser.getEventType())           // Switch statements will be needed to handle each event type...  ...                           if ((event == XMLEvent.START_ELEMENT))                     try{                   PullParserHelper parserData= new CustomXmlParser();                       } catch(Exception e){e.printStackTrace();}             
        while (!done) {      // This loop will handle each child node...         case XMLPullParser.END_TAG: break;}                        if ((event == XMLEvent.START_DOCUMENT))break;}}}   }catch (Exception e){e.printStackTrace();}