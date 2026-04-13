import java.io.*;
import org.xmlpull.v1.*;
public class java_48295_XMLParser_A03 {  
    public static void main(String[] args){    
        try{     
            // Create a parser object with SAXParserFactory to parse xml file        
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();         
             String inFile="inputfile";  
             
                PullParser parser =factory .newPullParser(inFile, null);     // Creating a new XML-pull parsing instance   
            int event;     
               while ((event =  parser.getEventType()) !=  XmlPullParser.END_DOCUMENT){  /* until end of document */          
                  String name = parser.getName();  
                   switch (event) {     // Switch statement to handle different events       
                       case XmlPullParser.START_TAG:    System.out.println("Start tag :" +name); break;      
                        /*case for other tags and attributes */ 
                    }         
                 parser.next();   }}      catch (XmlPullParserException e){e .printStackTrace( );}        // Catch Exception     if any occur            System.out..println("Something went wrong while parsing the XML document.");}}    });