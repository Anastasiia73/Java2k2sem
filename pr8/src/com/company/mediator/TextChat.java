package com.company.mediator;

import java.util.ArrayList;
import java.util.List;

public class TextChat implements Chat{
    User admin;
    List<User> users = new ArrayList<User>(); //список пользователей чата

    public void setAdmin(User admin){ //задается админ для чата
        this.admin = admin;
    }
    public void addUser(User user){ //добавление пользователей в чат
        users.add(user);
    }
    @Override
    public void sendMessage(String message, User user) {
        for(User u:users){
            if(u != user) u.getMessage(message); //пользователь не получает свои сообщение
        }
        if(user != admin)admin.getMessage(message); //админ не получает свои сообщения
    }
}
