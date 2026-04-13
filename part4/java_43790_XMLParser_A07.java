import org.xmlpull.v1.*;
public class java_43790_XMLParser_A07 {   
     public static void main(String[] args) throws PullParserException, IOException{        
          String xmlFile = "example_file"; //replace this with your actual .XML filename            
           XmlPullParserFactory factory = 
                XmlPullParserFactory.newInstance(); 
            try {                   
                 XMLReader reader=factory.newPullParser(xmlFile, null);  
                  int event;             
                   while ((event = reader.getEventType()) != 4) //end of document   
                     switch (reader.getEventType()){          
                          case XmlPullParser.START_DOCUMENT: System.out.println("Start Document"); break ; 
                        /* The following cases are for other types events */  
                         default :     if(event ==XmlPullParser.COMMENT)break;    //ignore comments         
                              case XmlPullParser.START_TAG:System.out.print ("start tag "+ reader.getName()); break ; 
                                  /* Processing START tags here... */     
                               default : System.out.println("default ->" +reader.getEventType() );break;          //Process other event types like CLOSE_TAG, END_DOCUMENT etc     },here you can ignore the events which are not related to A07 auth failure operation and also don't print them */
                         }  else { reader.next();}             if(event==XmlPullParser.END_ELEMENT) System.out.println("end tag " +reader .getName());}}     catch (Exception e){System.err.println ("Caught Exception:   ");e.printStackTrace() ;},
            finally { reader != null ? reader.close():null; }                    }}`  //finally block is used to close the XML Reader no matter what happened in try or not, if any exception occurs it will be caught and printed out with stack trace                });    It's quite a clean code example for your requirement as requested above