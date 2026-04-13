import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_07993_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        int port = 1234; // Port to listen on

        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try (Socket client = server.accept()) {
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                         PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

                        String request = in.readLine();
                        System.out.println("Received: " + request);

                        if ("exit".equals(request)) {
                            out.println("Goodbye");
                            break;
                        } else {
                            out.println("Hello, you are authenticated user!");
                        }
                    }
                }
            }
        }
    }
}