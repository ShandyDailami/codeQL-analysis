import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class java_09220_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                InetAddress clientAddress = socket.getInetAddress();
                int clientPort = socket.getPort();
                System.out.println("Accepted connection from " + clientAddress + ":" + clientPort);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Hello Client, you connected to port " + clientPort);
            } catch (SocketException e) {
                System.out.println("Exception caught when trying to accept connection from client. Client might be down.");
            }
        }
    }
}