import java.io.*;
import java.net.*;

public class java_07651_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started on port 1234");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create output stream
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Create input stream
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                String inputLine;

                // Read client input
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    out.println("Echo: " + inputLine);
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}