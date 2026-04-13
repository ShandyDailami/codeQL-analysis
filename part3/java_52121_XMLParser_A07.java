import javax.xml.parsers.*;
public class java_52121_XMLParser_A07 {  
    public static void main(String[] args){    
        try{          
            SAXParserFactory factory = SAXParserFactory.newInstance();        
            SAXParser saxParser=factory.newSAXParser();      //Create a new instance of the parser      
              MyHandler myhandler  =   new  MyHandler ();   
             Handler hdlr1 =  (Handler)myhandler;         
               XMLReader xreader =null ;       
            SAXSource source= null;                
                String xmlfile=  "src/test.xml";           // your input file name and path  
              saxParser .parse(new File(  xmlfile),hdlr1 );    #Parse the content of an XML document       with this parser     
            }catch (Exception e){                     System.out.println("Parsing failed");     e.printStackTrace();}       
          }}`;