import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40580_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444, 100, InetAddress.getByName("localhost"));
        System.out.println("Server started.");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            OutputStream outputStream = clientSocket.getOutputStream();
            String response = "Response from server.";
            outputStream.write(response.getBytes());

            clientSocket.close();
       
        }
    }
}