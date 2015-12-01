package springbook.user.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**************************************************************************************************
 * @brief       UserDao
 * @file        UserDao.java
 * @author      조원태
 * @date        2015. 12. 2.
 **************************************************************************************************/
public class UserDao {
    /**************************************************************************************************
     * @brief       사용자정보 등록
     * @method      add
     * @author      조원태
     * @date        2015. 12. 2.
     * @param       user
     * @throws      ClassNotFoundException SQLException
     **************************************************************************************************/
    public void add(User user) throws ClassNotFoundException, SQLException {
        //
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    // MSSQL
        Class.forName("oracle.jdbc.driver.OracleDriver");                   // ORACLE
        // 
        Connection          c   = DriverManager.getConnection("jdbc:oracle:thin:@121.140.240.218:15211/orcl", "SPRING", "SPRING");
        //
        PreparedStatement   ps  = c.prepareStatement("INSERT INTO USERS(id, name, password)VALUES(?,?,?)");
        //
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());
        //
        ps.executeUpdate();
        //
        ps.close();
        c.close();
        //
    }
    //
    /**************************************************************************************************
     * @brief       사용자정보 조회
     * @method      get
     * @author      조원태
     * @date        2015. 12. 2.
     * @param       id
     * @throws      ClassNotFoundException SQLException
     **************************************************************************************************/
    public User get(String id) throws ClassNotFoundException, SQLException {
        //
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    // MSSQL
        Class.forName("oracle.jdbc.driver.OracleDriver");                   // ORACLE
        //
        Connection          c   = DriverManager.getConnection("jdbc:oracle:thin:@121.140.240.218:15211/orcl", "SPRING", "SPRING");
        //
        PreparedStatement   ps  = c.prepareStatement("SELECT * FROM USERS WHERE ID = ?");
        //
        ps.setString(1,  id);
        //
        ResultSet rs = ps.executeQuery();
        //
        rs.next();
        System.out.println("rs : " + rs);
        //
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        //
        rs.close();
        ps.close();
        c.close();
        //
        return user;
        //
    }
    //
}
