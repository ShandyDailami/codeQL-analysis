import java.io.*;
import java.net.*;
import java.util.*;

public class java_01580_SocketServer_A03 {
    private static final String SERVER_MESSAGE = "Server listening...";
    private static final int PORT = 4446;

    private static Set<PrintWriter> clientOutputStreams = new HashSet<>();

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                clientOutputStreams.add(out);

                handleClient(socket, out);
            }
        } catch (IOException e) {
            System.out.println("Error establishing server socket");
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket socket, PrintWriter out) {
        new Thread(() -> {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String input;
                while ((input = in.readLine()) != null) {
                    System.out.println("Received: " + input);
                    out.println(SERVER_MESSAGE + ": " + input);
                    broadcastMessage(SERVER_MESSAGE + ": " + input);
                }
                clientOutputStreams.remove(out);
                out.close();
                socket.close();
            } catch (IOException e) {
                System.out.println("Error handling client");
                e.printStackTrace();
            }
        }).start();
    }

    private static void broadcastMessage(String message) {
        for (PrintWriter out : clientOutputStreams) {
            out.println(message);
        }
    }
}