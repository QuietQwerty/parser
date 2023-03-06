package org.example;


import lombok.RequiredArgsConstructor;

import java.sql.*;
import java.time.Instant;
import java.time.format.DateTimeFormatter;


public class main {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        /** Айди канала **/
        String chanelId = "f587ec49-ec77-4053-8bac-6d4554cd6a7f";
        /** Это значение должно быть уникальным. Заполни произвольно **/
        int chatId = 896844;
        /** День в котором нужно добавить чаты **/
        int day = 31;
        /** День в котором нужно добавить чаты **/
        int month = 01;
        /** Количество диалогов которые нужно добавить **/
        int dialogs = 500;
        /** Транспорт должен соответсвовать каналу - avito, whatsapp, telegram, vk */
        String transport = "telegram";

        AddDialog addDialog = new AddDialog(chanelId, chatId, day, month, dialogs, transport);
        addDialog.addDialog();


    }
}
