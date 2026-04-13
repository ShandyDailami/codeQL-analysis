import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25016_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8000);
            System.out.println("Waiting for connection...");
            Socket socket = server.accept();
            System.out.println("Connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String input;
            while ((input = in.readLine()) != null) {
                System.out.println("Received: " + input);
                if (input.equals("bad_input")) {
                    out.println("Bad Input Detected, aborting connection...");
                    socket.close();
                    server.close();
                } else {
                    out.println("Hello, client!");
                }
            }
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}