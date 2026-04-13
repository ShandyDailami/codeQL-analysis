import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_47867_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String input = "<data><item>Apple - red</item> <item>Orange - orange <color>orange</color><price>$1.50-$2.76 per pound and 3lbs from $8 free for whole farm or up to  $9 pickup at style store . Buy now !!! www.sellerone.com, Fruits & Vegetables - Grocery Store</item> </data>";
        parse(input);     //parse the xml input string 
    }  
      
      public static void parse (String str) throws ParserConfigurationException , SAXException {         
           XMLReader xr = null;            
            DefaultHandler dh  = new DefaultHandler(){                 
               boolean bItem=false ;             
                @Override                    
                 public void startElement( String uri,  String localName,  
                       String qName, Attributes attributes ) throws SAXException {                     
                    if (qName.equalsIgnoreCase("item")){                        
                        System.out.println("\nProduct :");      //print on console        
                            bItem=true;          }                    
                 };                  @Override                   public void  endElement(String uri, String localName ,    
                          String qName ) throws SAXException {                      if (qName .equalsIgnoreCase("item") &&   
                               !bItem) return ;                         System.out.println("\nEnd of product :"); bItem=false; } };   //end handler  for item      
              @Override public void characters(char [] ch, int start,     int length){ if (bItem ) { String str = new    string(ch ,start ,length); System .out.println("\nProduct Name: " +str );} ; }}          xr=SAXParserFactory   //create SAX parser instance      
              XmlReader("http://xmlparser/dtds/sample1.dtd");       xr  .setFeature( "http://xmlparser/tao/features/dom" , true);     r   =  (XmlReader) xr;      try {   System.out.println("\n Parsing the xml document with SAX : \n ");      
              while (!rx1_isEndElement  && !rax .hasNext()); rax       = rxr.nextToken();}}};    catch (FileNotFoundException e){     //catch file not found exception      System   ..println(e); }}          try { XmlReader xr = SAXParserFactory..createSAXParser() ;      
              while (!rx1_isEndElement  && !rax .hasNext()); rax       = rxr.nextToken(); }catch (Exception e){    System   ..println(e); }}          finally { try{ XmlReader xr = SAXParserFactory..createSAXParser() ;      
              while (!rx1_isEndElement  && !rax .hasNext()); rax       = rxr.nextToken(); }catch (Exception e){    System   ..println(e); }}     };}}}          `;});}}};})))) {}})";          println("Error parsing XML :", saxe)