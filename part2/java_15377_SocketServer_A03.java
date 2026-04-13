import java.io.*;
import java.net.*;

public class java_15377_SocketServer_A03 {
    private static final String QUIT = "quit";
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        server = new ServerSocket(12345, 10);
        System.out.println("Server started!");

        while (true) {
            try {
                Socket sock = server.accept();
                System.out.println("Connected to: " + sock.getRemoteSocketAddress());

                PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    if (inputLine.equals(QUIT)) {
                        out.println("Quit");
                        sock.close();
                    }
                }
            } catch (IOException e) {
                System.out.println("Exception caught when trying to read from or write to socket");
                e.printStackTrace();
                break;
            }
        }
        server.close();
    }
}