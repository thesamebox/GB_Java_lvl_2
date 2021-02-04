package Lesson_7.server.src.main.java;

import org.w3c.dom.ls.LSOutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class server {
    private final int PORT = 8189;
    private ServerSocket server;
    private Socket socket;
    private List<ClientHandler> clients;


    public server() {
        clients = new CopyOnWriteArrayList<>();
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started.");
            while (true) {
                socket = server.accept();
                System.out.println("Client connected" + socket.getRemoteSocketAddress());
                clients.add(new ClientHandler(this, socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadCastMessage(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }
}
