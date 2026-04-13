import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
 
public class java_47598_XMLParser_A01 extends DefaultHandler {
    StringBuilder data = new StringBuilder(); // Data in the current tag (null before start of a element) is accumulated here, until you see <tag>data</tag>  OR  <!--comment--> <![CDATA[ comment ]]> ...  then it's cleared. When null we know that an end-of-element has been reached and new data can follow or when nonnull - more text could be added
    String currentTag = ""; // name of the currently visited tag (used for checking access control)
    
    public java_47598_XMLParser_A01() { } 
     
       @Override  
        public void startElement(String uri, String localName, String qName, Attributes attributes){              
             super.startElement(uri,localName ,qName,attributes);                 
              currentTag = qName;                         
         data=new StringBuilder();                }                           //text within the element          `  public void endElement (String uri, String localName, String qName) {            System.out.println ("End of "+currentTag +" at line:"+super.getCurrentLineNumber());    currentTag = "";     
              if(data !=null && data.length()>0){  //print only when the tag has some text (not just a end-of-element)          System.out.println ("Text of " +currentTag  +" : \n\t"+ data);    }      	  
              if(qName != null && qName .equalsIgnoreCase("sampletag")){      //check access control here    `  public void characters (char[] ch, int start, int length) {           System.out.println ("Text of " +currentTag  +" : \n\t:"+ new String(ch ,start,length));    }
        if(!qName .equalsIgnoreCase("sampletag")){       //break the recursion here    `  public void endElement (String uri, String localName, String qName) {            System.out.println ("End of " + currentTag  +" at line:"+super.getCurrentLineNumber());    }
        if(!qName .equalsIgnoreCase("sampletag")){       //break the recursion here    `  public void characters (char[] ch, int start, int length) {             System.out.println ("Text of " + currentTag  +" : \n\t:"+ new String(ch ,start,length));    }
     	}       	  
}