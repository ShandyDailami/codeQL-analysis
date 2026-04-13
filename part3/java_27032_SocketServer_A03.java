import java.io.*;
import java.net.*;

public class java_27032_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Connected to: " + socket.getRemoteSocketAddress());

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            out.println("Hello, client, your message has been received!");
        }

        socket.close();
        serverSocket.close();
    }
}