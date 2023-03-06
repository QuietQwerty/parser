package org.example;



import java.sql.*;

public class AddDialog {
    String chanelId;
    int chatId;
    int day;
    int month;
    String transport;

    public AddDialog(String chanelId, int chatId, int day, int month, int dialogs, String transport) {
        this.chanelId = chanelId;
        this.chatId = chatId;
        this.day = day;
        this.month = month;
        this.dialogs = dialogs;
        this.transport = transport;
    }

    int dialogs = 2;
    private static ResultSet rs;


    public void addDialog() throws SQLException, ClassNotFoundException {

        int chatCount = 0;
        Class.forName("org.postgresql.Driver");
        String dburl = "jdbc:postgresql://49.12.21.128:5432/wazzup";
        Connection conn = DriverManager.getConnection(dburl, "wazzup", "!jfu0YgrvfFs28");
        Statement stmt = conn.createStatement();


        try {

            for (int i = 1; i <= dialogs; i++) {

                String sql = "INSERT INTO public.\"chats\"" + "VALUES ('" + 62346473 + "', '" + channelId + "', '" + chatId + "', '2023" + month + "' , '2023-" + month + "-" + day + " 09:48:00.001+00')";

                System.out.println("Chat " + i);
                stmt.executeUpdate(sql);
                chatId++;
                // chatsCount++;
//                if (chatsCount == 15) {
//                    days++;
//                }
            }

            String sql2 = "select COUNT(*) from \"uniqueChats\" where \"channelId\" = '" + chanelId + "'";
            rs = stmt.executeQuery(sql2);
            while (rs.next()) {
                chatCount = rs.getInt("COUNT");
            }

            String sql1 = "UPDATE public.channels SET \"uniqueChatsCount\"= '{\"2023" + month + "\":" + chatCount + "}' where guid = " + "'" + chanelId + "'";
            stmt.executeUpdate(sql1);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
            System.out.println("Чатов добавлено - " + dialogs);
            System.out.println("Чатов в счетчике - " + chatCount);
            System.out.println("Connection close");
        }

    }

}
