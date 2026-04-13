import java.io.*;   // for InputStreamReader Outputstream FileOutputStream    
public class java_47775_XMLParser_A08 {   
       public static void main(String args[]) throws Exception{     
             SAXParserFactory spf=SAXParserFactory.newInstance(); 
	         SAXParser saxparser;       
		 try          {saxparser =spf.newSAXParser(); }           catch (Exception e){   System.out.println ("Cannot instantiate a SAX parser");    return;      }           
             InputStreamReader isr= new InputStreamReader(System.in);      
	     //FileOutputStream fout=  new FileOutputStream("outputfile2104967583_xmlparserdemo",true );  use this if you want to append the output into file, comment out it otherwise  
             MyHandler mh =new MyHandler();    System.out.println ("Read XML content:");          //read from console and write on xmlhandler        saxparser.parse(isr ,mh);     }  catch (Exception e){e.printStackTrace() ;}         finally {      try{if(fout != null) fout .close(); isr.close();}}   
   public static class MyHandler extends DefaultHandler           //implements the SAXhandler          XMLCharacterEncoder xmle     Encoding (ISO-8859 text )  standard encoding of all read content      {        private int indentation=0;              boolean inLink=false ;             String link_url =null,link_text  = null ,inMetaData   = false      
                @Override          public void startDocument() throws SAXException{         System.out.println ("Start of Document"); }      //handling the Beginning  tag           indentation++;   str .append( "---Level" +indentation);}     StartElement (String uri, String localname ,
                string qName    )throws          SAXException {str=new            StringBuilder();             System.out.println ("Start of Element:");  }      //handling the Beginning element tag         indentation++; str .append( "---Level" +indentation);}     EndElement (String uri,
                string localname ,    String qName )throws          SAXException {str=new            StringBuilder();             System.out