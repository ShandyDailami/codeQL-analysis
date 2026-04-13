import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
public class java_49805_XMLParser_A03 {  
    public static void main(String[] args) throws Exception{    	        		         
	        String xmlContent = "<note>" + "\n <to>Tove</to>\n  <from>Jani</from>\n   <heading>Reminder</heading>\n    <body>Don't forget me this weekend!</body><br /> <attendees>Carol and John, Jane Doe.</attendees></note>";
	        parse(xmlContent);  	        		         	     			  }    	 				             public static void parse (String xml) throws Exception{    ParserFactory pf = ParserFactory .newInstance();        DocumentBuilderFactory dbFactory =  pf.getDocumentBuilderFactory();      dbFactory.setValidating(false);      
	        DocumentBuilder dbbuilder  =dbFactory.newDocumentBuilder();   NodeList nl=null; String strName,strBody ; int count =0; 
	         try {              
		     URL xmlFile = new File("input.xml").toURI().toURL();         
			    nl =  dbbuilder .parse(new SourceResource(xmlFile)).getElementsByTagName ("note");   //parsing the input XML file      for (int temp=0;temp<nl.getLength();temp++) {     strBody = "";  count ++ ;                     Node node  = nl.item(count);      
				    Element eElement1 =  ((Element )node );             	        		         			        //accessing the details of note           	 					   }                      for (int temp=0;temp<nl.getLength();temp++) {     strName = "";  count ++ ;                     Node node  = nl.item(count);      
				    Element eElement2 =  ((Element )node );            	        		         			        //accessing the details of note              }                 for (int temp=0;temp<nl.getLength();temp++) {     strBody = "";  count ++ ;                     Node node  = nl.item(count);      
				    Element eElement3 =  ((Element )node );            	        		         			        //accessing the details of note              }                 for (int temp=0;temp<nl.getLength();temp++) {     strName = "";  count ++ ;                     Node node  = nl.item(count);      
				    Element eElement4 =  ((Element )node );            	        		         			        //accessing the details of note              }                 for (int temp=0;temp<nl.getLength();temp++) {     strBody = "";  count ++ ;                     Node node  = nl.item(count);      
				    Element eElement5 =  ((Element )node );            	        		         			        //accessing the details of note              }                 for (int temp=0;temp<nl.getLength();temp++) {     strName = "";  count ++ ;                     Node node  = nl.item(count);      
				    Element eElement6 =  ((Element )node );            	        		         			        //accessing the details of note              }                  try{if (strBody != null){                 if (!strBody .equals ("") && strName! =null) {  String[] names  =   new     Strings [count];    NodeList nl1 =  eElement2.getElementsByTagName("to");      for(int i= 0;i<nl1.length;+++){names[i]=((Element )nl1).getTextContent();}}
catch (Exception ex) {ex.printStackTrace() ;}   }                 if (!strBody .equals ("") && strName ! =null )){String[] names  = new String [count]; NodeList nl2 =  eElement5.getElementsByTagname("to");     for(int i= 0;i<nl1.length + ++){names[++]=((element )node).getTextContent();}}catch (Exception ex) {ex .printStackTrace() ;} }
		} catch (ParserConfigurationException pce) 					{   	pce. print Stack trace ()；		       					  			     }; }}