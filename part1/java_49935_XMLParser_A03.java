import org.xmlpull.v1.*;    // For PullParser interface, constants etc...    
public class java_49935_XMLParser_A03 {     
  public static void main(String[] args) throws Exception{         
        String xmlContent = "<note>\n" +          
                "\t <to>Tove</to>\n" + 
                "\t <from>Jani</from>\n"+ 
                 "   <heading xmlns=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">  Reminder  </heading > \n   
                <body  xmlns=\"http://www.w3.org/1999/xhtml\"/>Remind me to buy groceries at the market.</body><br /> <p>Note Body goes here... </p> </note>";      //XML content    
        PullParserFactory factory = PullParserFactory.newInstance();         
           XMLPullParser xpp =  factory .newPullParser( xmlContent ,null, "UTF-8");   
            int eventType; 
             while (true) {                     
                 try{   // Try block for exceptions                 
                     if (!xpp.next()){ break;}              else {}                   }                           catch (XMLStreamException e1 ){}                          try          {eventType = xpp .getEventType();}      except     (NullPointerException  npe)    {npe        =null;        //Handle Null Pointer Exception                    
                      if( eventType == XmlPullParser.START_DOCUMENT){System.out.println("Start of Document");             }                            else {}                                                          try          {switch (eventType)}{ case XmlPullParser.END_TAG: System. out .print ("End tag : " + xpp.getName()); break;      default           : throw new IllegalStateException(  
                           eventType+" found when expecting elements."); }catch     ((IllegalStateException e)             {System    .out  println("Error at:" +  (new          String((char[] )xpp ..... //Parse the XML content and handle errors as per requirement. For simplicity, it's ignored here  
                             }}      catch(XMLStreamException x){ System     out       .print ("Parsing error: " +    xmlContent);}           }}}                  };//End of try..catch block  for handling exceptions                     );          //Closing XML content readers             reader.close();         writer, close;
              }}   ;      throw new UnsupportedOperationException("Not supported by your profile");       });     /* End Main */    Clone not allowed and you can't copy the code here as it is a teaching example without context or intention to share sensitive information in real-world applications. Use of this sample for educational purposes only!