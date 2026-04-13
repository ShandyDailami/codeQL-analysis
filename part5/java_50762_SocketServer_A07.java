import java.io.*;  // for InputStream and OutputStream classes  
import java.net.*;    //for ServerSocket class java_50762_SocketServer_A07 class SocketServerExample {     
private static final int port = 1234;      
// create server socket object of IP_ADDR:PORT             (IPv6 address in case required)          
static ServerSocket welcomeSocket = new ServerSocket(port);   //create a loopback/localhost server     sockets.          Socket clientSocket=welcomeSocket.accept();  for incoming connection    InputStream input=clientSocket.getInputStream();       OutputStream output; int bytesRead,bytesWritten; byte[] bufferOut=new byte[1024];   CharArrayReader chararrout = new     CharArrayReader(bufferIn); String lineOUT ;
while((bytesRead =input.read())!=  -  //loop to read the content from client         outputStreams, you can send multiple data at once          input=clientSocket      .getInputStream();//here we are just reading till server writes some message and closing connection    if (lineIN==null)break;
}catch(IOException e){System.out     .println("Error in transmission: "+e); System       .exit(-1)} //print error for the user  finally {clientSocket      .close();welcomeSock          et               }        welcomeSocket    .close() ;}}            catch (Exception ex)  
{ex           e.getMessage()); }}`;