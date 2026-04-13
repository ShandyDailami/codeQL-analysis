import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class java_35037_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(8080, null, null, InetAddress.getByName("localhost"));
            serverSocket.setNeedClientAuth(true); // enable client authentication

            System.out.println("Waiting for client authentication...");

            socket = (SSLSocket) serverSocket.accept();
            socket.startHandshake(); // client authentication

            System.out.println("Client authenticated successfully!");

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            String request = "Hello, Client!";
            outputStream.write(request.getBytes());
            outputStream.flush();

            byte[] bytes = new byte[256];
            int byteRead = inputStream.read(bytes);

            String response = new String(bytes, 0, byteRead);
            System.out.println("Server received: " + response);

            socket.close();
            serverSocket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}