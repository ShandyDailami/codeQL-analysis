public class java_45428_XMLParser_A03 {  
    public static void main(String[] args) throws Exception{    
        // Reading XML file from a stream     
	    FileInputStream fis = new FileInputStream("sample_file");            
	      
			// Creating an instance of XmlPullParserFactory to get the Object factory. 
	        javax.xml.parsers.XMLParserFactory parserFactory =  (javax.xml.parsers.XMLParserFactory) XMLParserFactory.newInstance();     
			  
            //Setting up a parsing listener which will be notified whenever something interesting happens in the Document, ie: end of document or error occurred during parse 		    	          									      	     	   	       	 								    */              }          @Override public void characters(char[] chars, int start,int length) {        
        // TODO Auto-generated method stub      this.data = new String (chars ,start,length);   System . out . println ("Data : " +this. data );  }}    	      		   			 @Override public void endElement(String uri, String localName, String qName) throws SAXException {        
        // TODO Auto-generated method stub      }          /* (end of characters()) */  										@OverridepublicvoidstartElement(	Stringuri , Stringlocalname， ‘title’}	     @ Override public void startDocument() Methode avec un document XML, lance le parsing et affiche les informations de base sur la structure d'un Document.     
        // TODO Auto-generated method stub   }          /* (end of xml) */  }; System . out . println ("Starting the Parsing.."); SaxHandler sh = new Saxhandler(); XmlPullParserFactory factory = 	     javax XMLparserfactorynewInstance() ;             parsersource source=nnull;