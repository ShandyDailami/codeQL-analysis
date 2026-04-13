import junit.framework.*;

public class java_47217_XMLParser_A03 extends TestCase {
    
    private static final String INJECTION_DETECTED = "Injection Detected!"; // This should not be displayed in console output due to security reasons, it is here for demonstration purposes only 
       
   public void testParse() throws Exception{        
       XMLPullParserFactory factory=XMLPullParserFactory.newInstance();          
       File file = new File("src/testXmlFileForTestingInjectionDetection.xml");      //Replace "yourfilepath" with the actual path of your xml document 
       
       System.out.println(INJECTION_DETECTED);                                     
                       
          factory=XMLPullParserFactory.newInstance();                           
           XMLPullParser xpp =factory.newPullParser(file,null );                   //This will parse the xml file 
        int event;                                                               
         while ((event  =xpp.getEventType()) != 10 ){                           ## Check for end of document   
             String name= null ;                            
                     switch (event){    
                 case XML_TEXT:                        
                       break;      //do nothing 
                      default :break;   /* do not call getName() */              
                                           }          xpp.next( event );              continue;}                  while((xpp) != null ) {                   if (event == XPPER_START){    ## Begin of XML Document                     xmlDoc = ((XppFactoryImpl)) factory .newPullParser("src/testXmlFileForTestingInjectionDetection.xml",null ); xdp  = new XXparsEr( "org,mozilla->netscape" ,false); 
                                              }                                                                                        else if (event == XML_TEXT){                   str =xpp .getText();                SystemOutPutStream out =  printoutstream("str");println ("text :",+ ) ;           break;}                    case XPPER_END:                     xdp. endDocument( );break;}}                  catch