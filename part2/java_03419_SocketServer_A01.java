import java.io.*;
import java.net.*;

public class java_03419_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected.");

            // Limit access by limiting concurrent connections
            if (serverSocket.getAcceptedSockets() >= Integer.MAX_VALUE) {
                System.out.println("Server is full, please wait for a moment.");
                socket.close();
                continue;
            }

            try (OutputStream os = socket.getOutputStream();
                 PrintWriter out = new PrintWriter(os, true)) {

                out.println("Server is ready.");
            } catch (IOException e) {
                e.printStackTrace();
            }

            handleClient(socket);
            socket.close();
        }
    }

    private static void handleClient(Socket socket) {
        try (InputStream is = socket.getInputStream();
             BufferedReader in = new BufferedReader(new InputStreamReader(is))) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received from client: " + inputLine);

                // For a real application, you would also want to verify the client's identity here.

                // For simplicity, we'll just echo back the input
                out.println("Server echo: " + inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}