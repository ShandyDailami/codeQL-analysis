import org.xmlpull.v1.*;
public class java_46326_XMLParser_A01 {  
    public static void main(String[] args) throws Exception{ 
        String url = "http://exampleurl"; //replace this with your URL where the xml file is located, or read from a stream using InputStreamReader/FileInputStream etc., depending on how you're going to get XML data.  
          PullParserFactory factory=PullParserFactory.newInstance(); 
        XmlPullParser myparser =factory .newPullParser(url); //reading xml document from the url          
         try {   
            int event;    
             while ((event  =myparser.getEventType()) != 3)   /*end of file*/      
              switch (event){  case XmlPullParser.START_DOCUMENT: System.out .println("Start document");break;}      //beginning of xml docuement   
            else {switch(myparser.getEventType())     {"case START_TAGS : printStackTrace() ; break; }   /*  tag not closed */}          default:'';       case XmlPullParser.END_DOCUMENT: System . out Println("End Document")；break;}
             catch (XmlPullParserException e) {System .outprintln ("Error : " +e);}}         //xml parsing exception     system exit  if xmldoc is not well-formed xml.   }catch(IOException ioe){system exits;    }}            */        /*end of class*/