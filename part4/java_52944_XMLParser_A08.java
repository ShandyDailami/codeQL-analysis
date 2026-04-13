import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52944_XMLParser_A08 extends DefaultHandler {    
    private boolean bName = false, bAge=false ;      // flags to indicate presence of the elements "name" and age". 
                                                     
    @Override   public void startDocument() throws SAXException{       super.startDocument();}       
                                                                           System.out.println("Start Document"); }    
            Public boolean isbName () { return b Name; }      // getter for the flag that indicates presence of "name"  .....                      @Override   public void startElement(String uri, String localname , string name ) throws SAXException{ if (local-names.equals("name"))   
            this .bName=true ;     System.out.println ("Start Element: " + Local Name);}       //if the element is found then set flag to true...   @Override public void endElement(String uri, String localname , string name ) throws SAXException { if (local-names.equals("age")) this .bAge=true ; }    
            System outprintln ("End Element: " + Local Name);} //if the element is found then print success message...   @Override public void characters(char [] ch , int start,int length ) throws SAXException { if (!this. bName) return;  char[] buffer = new CharArray (length+1)) ; Charcopy [ ] src=ch :buffer . offset by starnamemt strcpy() }
            // to copy the characters... System outprintln ("characters: " +new String( ch ,0, length));}    ...   if(! this.bAge) return; CharArray buffer = new char [length + 1];  Source .getCharAt (start ) :buffer ; offset by start name=strcpy () }
            // to copy the characters... System outprintln ("characters: " +new String(ch ,0, length));} ...   if(!this.bName) return; CharArray buffer = new char[length + 1]; Source .getCharAt (start ) :buffer ; offset by start name=strcpy() }
            // to copy the characters...  In your main method call this parser and pass it with sample xml data ...     if( !this.bName ||! This bAge) return; throw new SAXException("Missing 'name' or age") ;    System . outprintln ("Processed Successfully"); }
             // to print success message...   public static void main (String [] args ) { try{ MyXMLParser p =new myxmlparser() ; XMLReader reader= Xml. createPull parser () …..} catch(Exception e){System .outprintl("exception caught: " +e); }
            // Call this method with sample xml data ...   System outprintln ("main start"); try { MyXMLParser p = new myxmlparser(); XMLReader reader= Xml.createPuller (url) ;reader.setContentHandler(p)} catch …..}// call the above methods inside a main function...