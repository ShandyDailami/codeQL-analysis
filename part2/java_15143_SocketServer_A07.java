import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_15143_SocketServer_A07 {

    public static void main(String[] args) {
        int port = 1234;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);

            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("Client connected");

                    try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                            String inputLine;
                            while ((inputLine = in.readLine()) != null) {
                                System.out.println("Received: " + inputLine);
                                out.println("Hello, client, you are connected!");
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}