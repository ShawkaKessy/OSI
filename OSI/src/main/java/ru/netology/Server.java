package ru.netology;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final Integer PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер стартовал на порту " + PORT);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    // Чтение сообщения от клиента
                    String infoFromClient = bufferedReader.readLine();
                    System.out.printf("Новое сообщение. Информация: %s, порт: %d%n", infoFromClient, clientSocket.getPort());

                    // Отправка ответа клиенту
                    printWriter.printf("Привет, %s! Ваш порт: %d%n", infoFromClient, clientSocket.getPort());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
