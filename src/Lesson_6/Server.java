package Lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    static ServerSocket server;
    static Socket socket;
    static final int PORT = 8889;

    static DataInputStream in;
    static DataOutputStream out;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");

            socket = server.accept();
            System.out.println("Client connected");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Scanner serverInput = new Scanner(System.in);

            new Thread(() -> {
                try {
                    while (true) {
                        out.writeUTF(serverInput.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            while (true) {
                String serverMessage = in.readUTF();
                if (serverMessage.equals("/end")) {
                    System.out.println("Connection closed");
                    break;
                } else {
                    System.out.println("Client: " + serverMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
