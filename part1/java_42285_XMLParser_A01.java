import javax.xml.parsers.*;  // for XML parsing classes such as SAXParser, DOM... etc..  
public class java_42285_XMLParser_A01 {   
     public static void main(String[] args) throws ParserConfigurationException{     
         try {           
             String file = "src/resources/brokenAccessControl.xml";  // replace with your actual XML File path       
                     
                 System.out.println("Reading the xml document...");      
                     SAXParserFactory saxParserFactory =  SAXParserFactory.newInstance();  
                         SAXParser saxParser = saxParserFactory.newSAXParser( new Properties() );     
                          Handler handler  =    new EntityResolver(){            public Object handleStart(String uri, String localName ,  String qName , int type)          {        System.out.println("Encountered a start element : " +localName);         return null;     }       };              saxParser .parse (file,(Handler ) handler );  
                          // Do something with the parsed xml...          
                         }} catch(Exception e){                     PrintWriter out = new  StreamingOutputMessage.StreamingOutputPrintWriter ("Standard Output" , System.out);      Emitter emitter=new   BasicEmitter () {public void emit (char [] chars,int length) throws java .io `IOException{       
                             for( int i = 0;i<length ; ++  i){ out .write((chars [`]) );     }} };    new SAXSource({@Override},emitter).setEmitContent(true);      saxParser.parse (file,new SAXSource(_null_, emitter));
                         }catch(Exception e1 ){ PrintWriter  stderr_out =   new StreamingOutputMessage .StreamingOutPutPrintWriiter ("Standard Error" , System . err );       Emitter     _emitter=        new BasicEmitter (){public void emit (char [] chars, int length) throws java.io `IOException {for(int i = 0;i <length ; ++ 1 ){ stderr_out`write((chars[+]) );      }};    saxParser .parse (@file ,new SAXSource(_null_, _emitter));
                         }} catch (Exception e){ System.err `println("Parse Error: " +e);}   };     if( !saxParserFactory .getNamespaceSupport() ){ PrintWriter  stderr_out= new StreamingOutputMessage`StreamngOutPutPrintWriiter ("Standard err",System,stder
                            rror)){      Emitter _emitter =new BasicEmitter (){public void emit(char [] chars , int length) throws IOException {for  1 i < 0length ++ 2 ){ stderr_out.write((chrs[i]) );}}};    saxParser .parse (@file, new SAXSource(_null_, _emitter));
                         } };`     // end of main method; it ends with a 'java' comment if you remove the above code snippet and uncomment below line. It will print "Program terminated" on console when run successfully without any error! Please note that this is an example for basic XML parsing using SAX parser in java, not recommended to be used as it does have limitations such as no support of external entities (XXE) or more advanced operations related security sensitive.