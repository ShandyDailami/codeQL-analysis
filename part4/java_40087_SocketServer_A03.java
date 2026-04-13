import java.io.*;
import java.net.*;

public class java_40087_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                if (message.equals("exit")) {
                    break;
                }
                System.out.println("Received: " + message);

                // Send back the received message
                out.println(message);
            }

            socket.close();
        }
    }
}