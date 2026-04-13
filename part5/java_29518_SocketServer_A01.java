import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class java_29518_SocketServer_A01 {
    private static List<PrintWriter> clientOutputStreams;

    public static void main(String[] args) {
        clientOutputStreams = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientOutputStreams.add(new PrintWriter(clientSocket.getOutputStream(), true));
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error occurred during server listening: " + ex);
            ex.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;
        private final BufferedReader in;

        public java_29518_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException ex) {
                clientSocket.close();
                ex.printStackTrace();
                return;
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    for (PrintWriter clientOutputStream : clientOutputStreams) {
                        clientOutputStream.println(message);
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}