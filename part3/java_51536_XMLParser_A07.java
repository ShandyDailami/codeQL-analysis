import java.io.*; // FileInputSream , XMLEventFactory, etc are used here...  
          
public class java_51536_XMLParser_A07 {    
    public static void main(String[] args) throws Exception{        
        String inputFile = "inputfile.xml";  /* Set your file path */      
            
            FileInputStream fis  = new FileInputStream(new File (inputFile));      // Create a stream to read the XML document  
              
          XMLEventFactory factory =  EventFactory.createInstance();           //Create event factor for reading xml data   
              Reader reader = new InputStreamReader(fis, "UTF-8");         //set encoding of line inside your file  **** Important!!!!! ***//    
                XMLParser parser=factory.createParser(reader);             /* Create a Parser from Stream */     	  		      									   			       	   	 	     															// create an instance to parse xml data           	        //XML parsing begins here.....         
                    for (int event;  ((event = parser.getEvent()) ) != null;) {     //parse through all the XML file content...     	  		      									   			       	   	 	     															// iterate and print out each element in your xml data           	        /* end of loop */         
                        switch (parser.getEvent()){                            //switch statements for different types elements, attribute values etc         Case Event.START_DOCUMENT -> {...}           case event here: ...;                  }                    parser.next();            	  		      									   			       	   	 	     															}