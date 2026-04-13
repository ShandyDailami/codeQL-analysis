import javax.xml.parsers.*;   // Stands for XML Parser API in Java SDK    
public class java_44731_XMLParser_A08 {   
 public static void main(String[] args) throws Exception{      
          
      try {            
        URL url = new File("EncryptedDataXMLSampleFile.xml").toURI().toURL();  // replace with your file path           
         XMLPullParserFactory factory = 
                  XMLPullParserFactory.newInstance();    
          XmlPullParser xpp  =factory .newPullParser(url);   
           int event;  
             while ((event =xpp .getEventType()) != XmlPullParser.END_DOCUMENT) {      // loop to parse the XML document        
                String name; 
                 switch (event){         
                     case XmlPullParser.START_ELEMENT:   // start of element              
                         break ;    
                      default :    /* not a START or END tag */             
                             }        if(xpp .getName() != null) {      name = xpp  .getName();       System.out.print (name+" ");}            else return;             }}catch (Exception e){e.getStackTrace();}}   // catching any exception that might occur in the try block }