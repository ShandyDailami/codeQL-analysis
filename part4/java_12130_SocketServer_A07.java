import java.io.*;
import java.net.*;

public class java_12130_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);

        while (true) {
            Socket socket = serverSocket.accept();

            // Here you can add the authentication code
            if (!authenticate(socket)) {
                close(socket);
                continue;
            }

            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello client, you are authenticated!");
        }
    }

    private static boolean authenticate(Socket socket) {
        // For simplicity, we'll just assume that the authentication is always successful
        return true;
    }

    private static void close(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}