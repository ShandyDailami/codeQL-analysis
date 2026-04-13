import java.io.*; // for FileInputStream, InputStreamReader etc..
import javax.xml.parsers.*; // for SAXParserFactory...

public class java_48433_XMLParser_A01 {  
     public static void main(String[] args) throws Exception{   
         String xmlFile = "path_to_yourfile";  // replace with your file path here     
          parseXmlFile(xmlFile);       
       }               
           
           private static void parseXmlFile (String filename ) {  
             try {    
                 FileInputStream fis  = new FileInputStream(filename );   
                  SAXParserFactory spf = SAXParserFactory.newInstance();     
                   SAXParser saxParser=spf.newSAXParser();  //create a parser using the factory       
                MyHandler myHandler=  new MyHandler() ;   //handler object      
                 saxParser.parse(fis,myHandler);    }    
             catch (Exception e) {e.printStackTrace();}           
          }     
              public static class  MyHandler extends DefaultHandler{         private boolean inEntry;        @Override protected void startElement(String uri , String localName ,  
               String qName, Attributes atts ) throws SAXException     { if (qName.equalsIgnoreCase("entry"))    //check for entry element     
                this.inEntry=true ; return;}           public static  boolean isXmlFileSyntacticallyCorrect(String xmlFilePath)       try{       
                 File file = new File(xmlFilePath);            if (!file .exists()) {return false; }    //check for the existence of XML  
                FileReader fr=new     FileReader (xmlFilePath ); return true;} catch      Exception e  {}         public static boolean isAccessDeniedInXMLParsing()        try{      
                 BufferedInputStream bis = newBuffedInputSteam(System.in);//reads from the standard input   //check for access denied exception     if (bis .available () < 1) {return false; } return true;} catch      Exception e {}  private static void main!    (!String[] args){
                SecureXMLParse secureXml=newSecureXYMlPa~       sichertemXParsing() ;   //calls the method to check access denied exception     if(!securexml.isAccessDeniedInXMLparsing())  {System .out!println(" Access is granted"); }
                else{ System ,err