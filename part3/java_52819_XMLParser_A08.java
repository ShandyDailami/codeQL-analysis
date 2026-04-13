import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52819_XMLParser_A08 { 
    public static void main (String args[]){  
        String file="sample.xml";//replace with your xml location      
             XMLReader xr = null ;     //create a new SAX parser instance         
                  try      {          
                          File inputFile =  new File(file) ; 
                           if (!inputFile.exists())    {   System.out.println("Input file does not exist"); return; }       
                                  String systemId = "http://xmlparsing.com";             xr=SAXParserFactory .newInstance().new SAXParser ().getXMLReader () ;          //set the XML Reader to read this input source     
                          System.out.println ("Parsing with parser:");       print(xr)  ;     /*print version of your Xml Parser*/            xr=SAXParserFactory .newInstance().new SAXParser ().getXMLReader ()   //set the new xml reader to read in our file   
                          } catch (Exception e ) { System.out.println("Error Occured ...");e.printStackTrace(); return;  };     /*catch error when openning or reading XML source */          xr .setFeature( "http://xmlparsing.com",true) ;        //enable the feature of handling namespaces     
                          try {   System.out.println("\nParsing...");       parse (xr, new MyContentHandler()); } catch  (Exception e ){    print ("Error in parsing XML ",e ); return;     };         /*catch error when Parsing the input source */          xr .setFeature("http://xmlparsing.com",false) ;
                  //method to handle parse events   public void setContentHandler( ContentHandler contenthandler )       {  _content_handler = ( XmlPullParser )     contenthandler;      return;}        private static class MyContentHandler extends DefaultHandler implements org . xml parsing . Pullparser. ContentHandler{
                  //method to handle start of element          public void StartElement( String NamespaceURI ,String LocalName,   Strings qname  _, int lineNumber)       {         System.out.println("Start Element: " +Local Name); return; }        private static class MyContentHandler extends DefaultHandler implements org . xml parsing . Pullparser. ContentHandler{
                  //method to handle character data          public void Characters(char ch[], int start,int length )       {  System.out.println("Characters :" + new String (ch ,start ,length)); return; }    };        /*create a main method*/         static   final class MyXmlParserMain{
                  //main Method to create objects and run parsing      public static void Main(String argc[]){  XmlParsing obj=new       XMLParse();obj.setContentHandler((Mycontenthandler)) ;    new SAXparser().parse("samplexmlfilepath", handler);   }        
                   //method for error handling          private final class MyXmlParserMain { public static void Main (String args[])  try{      File inputFile =       new        file ("input.txt");SAXPareserFactory .newInstance ()..setfeature("http://xmlparsing,com",true);     System OutPrintln   
   }println; return ;}}}}}          //catch and print all exception details in the catch block to handle error occurred during paring  try {        Xml Parser.parse (xr , new MyContentHandler());}       Catch(Exception e){print ("Error Occured :" +e);return;}     }     
                  xr .setFeature("http://xmlparsing..com",false) ;         /*close the parser*/    return;  };}}}                //End of main method             public static void Main (String args[] ){   try { File inputFile = new file ("input.txt");SAXPareserFactory ..newInstance () .setfeature("http://xmlparsing..com",true);     System OutPrintln "Start Parsing" xr= SAXParserfactory …} catch (Exception e){    print  
!“Error in parsinfg XML: ,e ; return; }      //close the parser        XmlPareserFactory .newInstance ()..setFeature("http://xmlparsing...com",false) ;     }}}}}          public static void main(String[] args ){ try { File inputFile = new file ("input.txt");SAXParserFa├y ... setfeature(".  
! http: ! com". true); System OutPrintln "Start Parsing" XmlPaserFac... } Catch (Exception e){ print (!“Error in parsing XML :,e ; return; }}       //close the parser        SAXParserFactory .newInstance ()..setFeature("http://xmlpars.com",false) };