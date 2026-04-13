import javax.xml.parsers.*;  // Import required java packages for XML Parsing - SAX, DOM or StAX parsing are all the same interface (parse method) i used here to keep it simple  
public class java_45471_XMLParser_A01 {   
     public static void main(String[] args){     
         try{         
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();//create factory object           
             SAXParserFactory saxFactory= (SAXParserFactory)dbFactory;  //sax parserfactory          
             
             SAXParser saxParser  = saxFactory.newSAXParser(true);   //parsing with Synchronous mode false, which is also default       
                         
             MyHandler myHandler = new MyHandler();      
              
             String inputFile="inputFile";  int i = 0;    char currentChar ;     boolean inTagName  =false ,inContent=  true ;      //initialization of flags         
                  saxParser.parse(new InputSource(new FileInputStream(inputFile)), myHandler);       return;}   catch (Exception e) {e.printStackTrace();}};    class MyHandler extends DefaultHandler{     public void startDocument(){ System.out.println("Start Document :"+ ++i );}         
public  void endDocument(){}              @Override      public void startElement(String uri, String localName , String qName   , Attributes attributes) {        inTagName=true; }         // Called for an opening tag       System.out.println("Start of "+qName);}
public  void endElement (String uri, String localName ,    String Qname ){          inTagName =false;}     public   void characters(char ch[], int start,int length){         if(!inContent) return;       System .out.println("Character Data :"+ new String(ch,start,length));} 
@Override      // Called for end tags           }};        MyHandler mh =new   MainClass().Myhandler();    };}}` END OF CODE `! I am sorry about the code provided but as per your request here's a possible solution: A01_BrokenAccessControl. 
Please let me know if you want any other exception handled or not, and also how to provide an input file for parsing in this context? The program will be more complex than my previous suggestions because we are dealing with XML security-sensitive operations which can't use Spring nor Hibernate but I hope it helps!