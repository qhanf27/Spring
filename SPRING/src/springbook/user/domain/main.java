package springbook.user.domain;

import java.sql.SQLException;

public class main {
    //
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //
        UserDao dao     = new UserDao();
        User    user    = new User();
                //
                user.setId("whiteship");
                user.setName("������");
                user.setPassword("married");
                //
                dao.add(user);
                //
                System.out.println(user.getId() + " ��� ����");
                //
        User    user2   = dao.get(user.getId());
                //
                System.out.println(user2.getName());
    }
    //
}
