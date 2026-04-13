public class java_52714_XMLParser_A01 {
    public void parse(String xml) throws Exception{  
        // This is just an example, it will not work in real scenario due security reasons     
       XMLReader xr = null; 
         try {
            String systemId="http://example.com/mystuff";//id for the stuff to read (used by some parsers)    //replace with your URL or local file path  	    		          									                } catch(Exception e){        System.out.println("XMLReader Error: " +e);      	} finally { if 	(xr != null ) xr .close();}
             XmlPullParserFactory factory = Jsoup.connect (systemId).attain  	DefaultHttpClient()).parser;    //create a parserfactory object for the stuff to read, use it in try and catch block      } 		    				}         finally { if(xr != null ) xr .close();}}
        /*public void parse() throws Exception{          XMLReader reader = factory.newSAXReader ();       //Create a SAX Reader for the stuff to read           XmlHandler handler;  	try	{                   		                     } catch 	   			   				      e { System out println ("Error: " +e) ;} finally     try{reader .close();}}