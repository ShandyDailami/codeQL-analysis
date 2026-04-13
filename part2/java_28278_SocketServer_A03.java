import java.io.*;
import java.net.*;

public class java_28278_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);
                // The injection point for a real application would be here.
                // It would likely involve using command and parameter injection to send back a SQL or OS command to execute.
                // For instance, the command `rm -rf /`
                out.println("Hello, client, I received your message: " + clientMessage);
                out.flush();
            }
            socket.close();
        }
    }
}