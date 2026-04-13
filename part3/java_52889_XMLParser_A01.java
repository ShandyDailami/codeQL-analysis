import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52889_XMLParser_A01 {
    public static void main(String[] args) throws Exception{
        String xml = "<person><name>John Doe</name><age>30</age><city>New York</city><country>USA</country></person>";  // Sample XML data. Replace this with your real source of the file content or URL
        SAXParserFactory factory = SAXParserFactory.newInstance();
        
       try {  
            SAXParser parser=factory.newSAXParser(null);//To parse xml string, we should use new SAXparser() method and pass null as an inputStream 
            
           MyHandler handler  = new MyHandler ( ); //Create a Handler that will handle the parsed content of XML file  
           
          parser .parse(new InputSource(new StringReader(xml)),handler);//Parse xml using SAX Parser. Here, we pass our created XmlSAxParser and input source  to parse method for parsing an given resource or a string in this case above line is responsible of loading the XML content from provided data
         }  
        catch (Exception e){     //catch exception if any error occurs during processing     
          System.out.println("Parsing failed --> "+e); 
       };   
          
             
             /* This program will print: Name : John Doe, Age is not present in the XML data */  
        }    
         public static class MyHandler extends DefaultHandler {      //Our custom SAX parser handler. Implementing default saxparser callbacks here 
          boolean bName = false;       Boolean bAge=false ;    private String age, city , country , name;                  
           @Override  
            public void startElement(String uri, String localname, String qName, Attributes attributes) throws SAXException {     //called for each opening tag found in the XML file. It calls back to us when it finishes parsing an element and its content  */         if (qName .equals ("name")){ bName = true; } else if(qName .equals("age") )
            {}    age= "";     city=  "" ; country =  " "; name  =  "" ;}      //called for each opening tag found in the XML file. It calls back to us when it finishes parsing an element and its content  */              @Override        public void endElement(String uri, String localname , String qName)throws SAXException {         if (qName .equals ("age")){ bAge = true; }else
             {}if(!bAge && !bName){   //check whether the tag is present or not and then print it.  If there's no data in that field, age will be null otherwise just display name of person */                  if(name!=null)    System . out .println (" Name : "+ name); else
               {System.out.print("Name: "); }if (age !=  null ){     //check whether the tag is present or not and then print it  If there's no data in that field, age will be null otherwise just display person’s Age   */                  if(country!=null) System . out .println (" Country : "+ country); else
                {System.out.print("Age: "); }if (city !=  null ){     //check whether the tag is present or not and then print it If there's no data in that field, city will be  null otherwise just display person’s City   */                  if(country!=null) System . out.println ("City : "+ city); else
                 {System.out.print("Country: "); }}};    //...and so on for other attributes as well}        };          MyHandler mh = new …..     (Your class name here ); Serving xml file to the SAX parser through input source and calling parse method of saxparser with our created handler object.