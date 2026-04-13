import java.io.*;
import java.net.*;
import java.util.*;

public class java_09335_SocketServer_A07 {
    private static final String PASSWORD = "password";
    private static ArrayList<PrintWriter> clientOutputStreams = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server started!");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            new SocketServerThread(socket).start();
        }
    }

    private static class SocketServerThread extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private BufferedWriter writer;

        public java_09335_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            while ((message = readMessage()) != null) {
                processMessage(message);
            }
        }

        private String readMessage() {
            String message;
            try {
                message = reader.readLine();
            } catch (IOException e) {
                return null;
            }
            return message;
        }

        private void processMessage(String message) {
            if (message.equals("exit")) {
                closeConnection();
            } else {
                sendMessage(message);
            }
        }

        private void sendMessage(String message) {
            String response;
            if (message.equals(PASSWORD)) {
                response = "Authorized";
            } else {
                response = "Unauthorized";
            }

            for (PrintWriter clientOutputStream : clientOutputStreams) {
                clientOutputStream.println(response);
            }
        }

        private void closeConnection() {
            try {
                reader.close();
                writer.close();
                socket.close();
                System.out.println("Connection closed!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}