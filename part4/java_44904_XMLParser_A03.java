import org.xmlpull.v1.XPullConnection;
import org.xmlpull.v1.*;
public class java_44904_XMLParser_A03 {  
  public static void main(String args[]) throws Exception{   
        String url = "http://sample.org/test.xml";     // Replace with your xml file URL     
         try (XPullConnection connection = new XPullConnection(url)){      
          PullParserFactory factory=connection .getPullParserFactory();  
            PP result; 
           while ((result  =factory.parse(null, connection)) != 1){    // Iterate until the whole file is read    
                 if (((XPullConnection)connection).isStartTag("note")){     
                   String title = XPullConnection .getAttributeValue( null , "title");  
                    System.out.println ("Title: --------->"+title);    // Print the note's Title    
                 } else if (((XPullConnection)connection).isEndTag("note")){     
                   connection_.complete();       return;         }}          {{{{}}}}}   catch(Exception e){e.printStackTrace()};}  Exception in thread "main" java.lang .NullPointerExcceptionatorgo org/xmlpull / v1/.XMLPullConnection (Xpp3_impl)