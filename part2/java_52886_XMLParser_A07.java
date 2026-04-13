public class java_52886_XMLParser_A07 {
    public static void main(String[] args) throws Exception{
        //Step1 - Read XML file using FileInputStream or InputStreamReader for security sensitive operations (not shown in this example). 
        
       /*File inputFile = new File("src/main/resources/sample.xml");  
        FileInputStream fis = null;*/
    	ClassLoader classLoader=new ClassLoader();   
           // not sure whether the above two are required or if so, how to use it?  This line might be needed for loading a non-jar resource such as an XML file in your program.   If you can't load resources from jar then comment this part and uncomment next one which is using FileInputStream
        /*fis = new FileInputStream(inputFile);*/     // reading xml data into inputstream  not shown here for security sensitive operations only show case when dealing with external file resource loading.   This line might be needed if you are trying to read XML from network or other non-jar resources such as a database, web services etc
        	
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8"); // Converting FileInputStream into an inputstreamreader for character encodings.  not shown here only show case when dealing with external resource loading and converting file to string or byte array using different encoding, if necessary you can use these line
        	
        XmlPullParserFactory xppf = Xml.newPullParserFactory(); // creating a new xml parser factory for parsing XML data not shown here  only show case when dealing with external resource loading and converting file to string or byte array using different encoding, if necessary you can use these line
        	
        /*Create an instance of the Parser Factory */   XmlPullParser xpp =xppf.newPullParser(); // creating a new xml parser not shown here only show case when dealing with external resource loading and converting file to string or byte array using different encoding, if necessary you can use these line
        	*/    /*End of step 1: Reading XML from File */     /**/   /****************************** Step2 - Parsing the xml data **********************************// Create a method for parsing Xml which is not shown here only show case when dealing with external resource loading and converting file to string or byte array using different encoding, if necessary you can use these line
        		//xpp.setInput(isr); //setting input stream into XML Parser  */    /*End of step2 - parsing xml data*/   /****************************** Step3: Extracting the Data **********************************// Create a method to extract information from parsed Xml which is not shown here only show case when dealing with external resource loading and converting file to string or byte array using different encoding, if necessary you can use these line
        		//System.out.println(extractDataFromXmlNode("books")); //calling the function for example purposes   /*End of step3 - extract data*/    /****************************** Step4: Closing Connection and Streams **********************************// closing connection, streams not shown here only show case when dealing with external resource loading
        			//fis.close();  isr.close() xpp.close (); //closing the connections to file resources   /*End of step3 - close*/    /****************************** Step5: Program Ends **********************************// The program ends here */}        }catch(Exception e){e.printStackTrace();}}