import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26457_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Waiting for client...");
        Socket socket = serverSocket.accept();
        System.out.println("Client accepted");

        OutputStream outputStream = socket.getOutputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String clientMessage = reader.readLine();
        System.out.println("Client message: " + clientMessage);

        String serverMessage = "Hello, client!";
        outputStream.write(serverMessage.getBytes());

        socket.close();
        serverSocket.close();
    }
}