import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class java_23671_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Create a socket and bind it to a port
        Socket socket = new Socket();
        socket.bind(new InetSocketAddress(8080));

        // Listen for incoming connections
        socket.listen(5);

        // Accept a connection
        Socket acceptedSocket = socket.accept();

        // Read from the input stream
        InputStream inputStream = acceptedSocket.getInputStream();
        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);
        String message = new String(buffer, 0, bytesRead);
        System.out.println("Received: " + message);

        // Write to the output stream
        OutputStream outputStream = acceptedSocket.getOutputStream();
        String response = "Hello, client!";
        outputStream.write(response.getBytes());

        // Close the socket
        acceptedSocket.close();
    }
}