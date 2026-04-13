import java.io.*;   // Import Input/Output Stream classes for use in our server program   
                import java.net.* ;     // Include this to get socket programming functions, including ServerSocket and Socket objects         
                
public class java_52788_SocketServer_A07 {     
// Start the main method from where execution starts 
 public static void startServer() throws IOException{        PrintWriter out;       BufferedReader in;         String line ;     int port=8096,clients=0;    ServerSocket welcome=new   ServerSocket(port); System.out .println ("HTTPServer listening on port 8096 ..");
      while (true) {          Socket connection =welcome.accept();         clients++ ;     PrintWriter out=  new PrintWriter(connection.getOutputStream(), true);           BufferedReader in=new   BufferedReader    (new InputStreamReader(connection.getInputStream()));                String line;        try{               while ((line  =in .readLine()) != null) {                 System.out .println ("Got : " + line );                     }        
      out.close();             in .close();           connection   .close() ;       if (clients==10){                   for(int i = 5;i < clients - 2 && i < 896473+((long)(Math.random()))* ((double)Integer.MAX_VALUE- Integer.MIN_VALUE);
      port=port + ++a[c++]< c ? (short)-1 :  0 ;         }             if(clients>2){     for (;i < 54789+((long)(Math