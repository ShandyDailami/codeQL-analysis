import org.xmlpull.v1.*;
public class java_46143_XMLParser_A07 {  
    public static void main(String[] args) throws PullParserException, IOException  {         
        String url = "file:///C:/myFile.xml";      // Change this to the location of your file      
         XmlPullParserFactory factory=XmlPullParserFactory.newInstance();   
          
         XmlPullParser parser  =factory .createPullParser(null,url);  
          while (parser.getEventType() !=  PullParser.END_DOCUMENT) {     // read document     
            String elementname=parser.getName(); 
              if ("auth".equalsIgnoreCase(elementname))    {      
                parser.requireNamespaceDeclaration("http://www.w3.org/2001/XMLSchema-instance");  
                  while (true)                      // loop through authentication elements    
                    switch ((parser.getEventType())){  case XmlPullParser.START_TAG:      
                              if ("user".equals(parser.getName()) ) { parser .next(); String user = parser.getText() ; }      break;   default :if ( "passwd".equals(elementname)){    parsertype=XmlPullParser.START_TAG;}  else                          return false;      
                              case XmlPullParser.END_TAG:              if ("user".equalsIgnoreCase((parser .getName()))) {return true ;} break default :if ( "passwd" == elementname)    parsertype = parser.next();   }break  else                       throw new ParserAbortException("not in a auth tag");    
                  switch(parsertype){case XmlPullParser.START_TAG: if ("fail".equalsIgnoreCase (parser .getText())) { return false;}}              break ; default :throw new ParseException("unknown starttag"+ elementname);    }break;}      // end of main while loop    
                case PullParser.END_DOCUMENT   throw parserExcept ("Error parsing XML");  finally{System . out (). println( "done reading ");}                  try {FileInputStream fin = new FileInputStream("file:/// C:/my file" );XmlPullParserFactory factory2= XmlPullParserFactory.newInstance();  
        PullParser p1 =  factory2  .createPullParser (fin , null);     // Create a pull parser with the input stream    }catch(Exception e){System outprintln ("reading error");}            }} catch_all block to handle all exceptions within try-catches.         finally {// clean up code here}}