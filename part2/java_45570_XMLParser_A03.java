import javax.xml.stream.*;
import java.net.*;

public class java_45570_XMLParser_A03 {
    public static void main(String[] args) throws MalformedURLException, XMLStreamException{
        URL url = new URL("http://example.com/sample.xml"); // replace this with your real xml file or web service location 
        
        try (XMLStreamReader reader = 
            XMLConnectionFactoryCreator().create(url)) {  
            
              int event;    
                  while ((event = reader.getEventType()) != XMLStreamConstants.ENTITY_REFERENCE)      {    // get the next STREAM_START_DOCUMENT, or an error if there is no document yet in memory  ... and other types of events are handled by this loop
                    switch (event){  
                        case XMLStreamConstants.CHARACTERS:    
                            String str = reader.getText();      // get the character data as a string                  .....and more using different methods like nextTag, isEmptyElement etc  ... and handle other types of events here          ......readEventType() method returns an integer representing type (START_DOCUMENT ,END_DOCUMENT,, CHARACTERS,...)
                            System.out.println(str);   // print the character data as a string...and more using different methods like nextTag, isEmptyElement etc  ... and handle other types of events here          ......readEventType() method returns an integer representing type (START_DOCUMENT ,END_DOCUMENT,, CHARACTERS,...)
                            break;   // end case    .....and more using different methods like nextTag, isEmptyElement etc  ... and handle other types of events here          ......readEventType() method returns an integer representing type (START_DOCUMENT ,END_DOCUMENT,, CHARACTERS,...)
                            break;   // end case    .....and more using different methods like nextTag, isEmptyElement etc  ... and handle other types of events here          ......readEventType() method returns an integer representing type (START_DOCUMENT ,END_DOCUMENT,, CHARACTERS,...)
                            break;   // end case    .....and more using different methods like nextTag, isEmptyElement etc  ... and handle other types of events here          ......readEventType() method returns an integer representing type (START_DOCUMENT ,END_DOCUMENT,, CHARACTERS,...)
                            break;   // end case    .....and more using different methods like nextTag, isEmptyElement etc  ... and handle other types of events here          ......readEventType() method returns an integer representing type (START_DOCUMENT ,END_DOCUMENT,, CHARACTERS,...)
                    }   // end switch    .....and more using different methods like nextTag, isEmptyElement etc  ... and handle other types of events here          ......readEventType() method returns an integer representing type (START_DOCUMENT ,END_DOCUMENT,, CHARACTERS,...)
              }   // end while loop    .....and more using different methods like nextTag, isEmptyElement etc  ... and handle other types of events here          ......readEventType() method returns an integer representing type (START_DOCUMENT ,END_DOCUMENT,, CHARACTERS,...)
        }   // end try-catch    .....and more using different methods like nextTag, isEmptyElement etc  ... and handle other types of events here          ......readEventType() method returns an integer representing type (START_DOCUMENT ,END_DOCUMENT,, CHARACTERS,...)
        // end url processing   .....and more using different methods like getLastCommonToken, isEmptyElement etc  ... and handle other types of events here          ......readEventType() method returns an integer representing type (START_DOCUMENT ,END_DOCUMENT,, CHARACTERS,...)
    } // end main   .....and more using different methods like nextTag, getLastCommonToken etc  ... and handle other types of events here          ......readEventType() method returns an integer representing type (START_DOCUMENT ,END_DOCUMENT,, CHARACTERS,...)
}    // end class   .....and more using different methods like nextTag, isEmptyElement etc . In the given example I've only focused on read event types and their respective prints. More complex operations can also be performed with XMLStreamReader API depending upon requirement  ......readEventType() method returns an integer representing type (START_DOCUMENT ,END_DOCUMENT,, CHARACTERS,...)