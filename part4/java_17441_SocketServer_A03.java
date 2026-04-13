import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.xml.soap.SOAPMessage;
import org.apache.axis2.engine.Axis2Stack;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HTTPSender;
import org.apache.axis2.transport.http.util.Axis2HttpUtils;
import org.apache.axis2.transport.tcp.TCPTransportUtils;

public class java_17441_SocketServer_A03 {
    private static final int PORT = 8081;
    private static final String HOST = "localhost";

    public static void main(String[] args) throws Exception {
        InetAddress addr = InetAddress.getByName(HOST);
        ServerSocket serverSocket = new ServerSocket(PORT, 0, addr);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Accepted connection from: " + socket.getInetAddress().getHostAddress());

            ServerSocket secureServerSocket = null;
            try {
                secureServerSocket = (ServerSocket) socket.getTransportSocket().getSocket();
                secureServerSocket.setReuseAddress(true);
            } catch (Exception e) {
                socket.close();
                System.out.println("Failed to establish secure socket for client: " + socket.getInetAddress().getHostAddress());
                continue;
            }

            SOAPMessage soapRequest = null;
            try {
                soapRequest = HTTPSender.receiveSOAPMessage(secureServerSocket);
                System.out.println("Received SOAP request from: " + socket.getInetAddress().getHostAddress());
            } catch (Exception e) {
                secureServerSocket.close();
                System.out.println("Failed to receive SOAP request from: " + socket.getInetAddress().getHostAddress());
                continue;
            }

            Axis2Stack axis2Stack = Axis2HttpUtils.createAxis2Stack(secureServerSocket, HTTPConstants.HTTP_SOAP_RECEIVER);
            try {
                axis2Stack.setSender(new HTTPSender(secureServerSocket, Axis2Stack.DEFAULT_SOAP_ENVELOPE));
                Axis2Stack.install(axis2Stack);
                axis2Stack.start();
                System.out.println("Handling SOAP request from: " + socket.getInetAddress().getHostAddress());
            } catch (Exception e) {
                axis2Stack.stop();
                secureServerSocket.close();
                System.out.println("Failed to handle SOAP request from: " + socket.getInetAddress().getHostAddress());
                continue;
            }
        }
    }
}