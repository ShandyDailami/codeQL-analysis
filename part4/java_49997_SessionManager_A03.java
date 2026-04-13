import java.io.*;
import javax.servlet.*;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
public class java_49997_SessionManager_A03 {  
    public static void main(String[] args) throws Exception{       
       // Create HttpClient and Post Request 
	HttpPost httppost = new HttpPost("targetURL");    
         ServletRequest servletRequest=new ServletRequest(){                  @Override                       protected CloseableChannel getCloseableChannel()throws IOException {               return null; }};    String userName  = "USER";String password   ="PWD".getBytes();byte[] encodedPassword = Base64.encodeBase64(password);
	     httppost.setEntity(new NamedStringEntity("user="+ userName +"&passwd=" +  new String(encodedPassword)));          HttpClient client =  new DefaultHttpClient() ;    try {        Response response =client .execute(httppost)  ){       PrintWriter out  =   httppost.getResponse().getOutputStream();
	     BufferedReader in    =new InputStreamReader (response.getEntity().getContent());         String inputLine;StringBuffer buffer= new  StringBuffer() ;while((inputLine =    in .readLine()) != null) {buffer.append(inputLine);}       out .write( buffer.toString());        } finally{ client.getConnectionManager().shutdown();}}
      //Closing http connection if any exception occurred during the process  try/catch    	 catch (Exception e){  		 System.out.println("Error in Session Management"+e);}    }}                 Closed successfully         '