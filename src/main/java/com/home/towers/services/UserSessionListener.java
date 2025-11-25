package com.home.towers.services;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.home.towers.models.user;
import com.home.towers.repos.UsersRepository;

public class UserSessionListener implements HttpSessionListener {
        static final String ONLINE_USERS = "OnlineUsers";

    private final UsersRepository userdao;

    public UserSessionListener(UsersRepository userdao) {
        this.userdao = userdao;
    }

    @Override
        public void sessionCreated(HttpSessionEvent se)
        {

//
//            public interface List<vistors> extends Collection<E>
//
//
//
//            List<onlineUsersCount> context = se.getSession().getServletContext();
//
//            Integer onlineUsersCount = 0;

//            Object attributeValue = context.getAttribute(ONLINE_USERS);

//            if(attributeValue != null){
//                onlineUsersCount = (Integerd) attributeValue;
//            }

//            context.setAttribute(ONLINE_USERS, ++onlineUsersCount);



        }


    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
//        ServletContext context = se.getSession().getServletContext();

//        Integer onlineUsersCount = (Integer) context.getAttribute(ONLINE_USERS);
//
//        context.setAttribute(ONLINE_USERS, --onlineUsersCount);

    }



}
