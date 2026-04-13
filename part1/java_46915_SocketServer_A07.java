import java.io.*;
import java.net.*;

public class java_46915_SocketServer_A07 {
    public static void main(String[] args) throws Exception{  
        ServerSocket server = new ServerSocket(80); // create a socket at port no:7954  which is preemited for our HTTP requests (standard web ports are usually from 135 to 443, but not necessarily; this example uses default as per standard)
        System.out.println("Server Started @ "+server);   // print a message stating server started at port no:7954   
         while(true){    
            Socket s=server.accept();  /* accept request from the client */     
             PrintWriter pw = new PrintWriter (s.getOutputStream(), true );       System.out.println("Server : Connection Established @ "+s);   // print message to confirm a successful connection    ServerSocket ss =new Socket ("127.0.0.1",6543) ;
             BufferedReader br= new BufferedReader(      new InputStreamReader ( s.getInputStream() ) );       String request, response;     try{   // read the http request  from a client    RequestLine r = c .readRequestline(); System.out.println ("Request line : " +r);
             while ((request=br.readLine()) != null) {                  if ("/dork/".equals(request))                   response =  "HTTP/1.1 403 Forbidden\n\n"; else   //if it's not /dork/, send back a generic page
      HTTP_HEADER; } pw .println ("HTTP/1.1 200 OK \r\n" + "\r\n "+ response);    s.close(); System.out.println("Connection closed by the client @:   ");}catch (Exception ex){System.out.println(ex.getMessage());}} }
     catch (IOException e) {  // if there is an error, print it out and continue to next connection       System.err .println ("Problem with clients " +e); }} c );}}}    private static final String HTTP_HEADER ="HTTP/1.1 200 OK\r\n"+
     "\r\nContent-Type: text/html; charset=utf-8\r\n" ;}}// End of HTTPServer class }}   // closes the main function    }}}} Programming language in Java is not suitable for implementing complex security mechanisms like SSL, TLS etc. It's better to use existing libraries and frameworks that are designed with these features already incorporated into them such as Spring or Hibernate which has support methods/features required by A07_AuthFailure standard protocol specification of HTTP secure server (HTTPS).