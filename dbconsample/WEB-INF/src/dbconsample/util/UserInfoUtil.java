package dbconsample.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbconsample.dto.UserInfo;
import dbconsample.io.DBConnector;

public class UserInfoUtil {
    public static List<UserInfo> selectAllUsers() throws Exception {
        DBConnector connector = new DBConnector();
        Connection connection = null;
        List<UserInfo> userList = new ArrayList<>();
        String sql = "SELECT userid, username, birthday FROM users\n"
                + "ORDER BY userid";

        try {
            connection = connector.getConnection();
            int userid = -1;
            String username = "";
            Date birthday = null;
            PreparedStatement state = connection.prepareStatement(sql);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                userid = rs.getInt("userid");
                username = rs.getString("username");
                birthday = rs.getDate("birthday");

                UserInfo user = new UserInfo(userid, username, birthday);
                userList.add(user);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connector.close();
            }
        }
        return userList;
    }

    public static List<UserInfo> selectMatchUsers(String keyword) throws Exception {
        DBConnector connector = new DBConnector();
        Connection connection = null;
        List<UserInfo> userList = new ArrayList<>();
        String sql = "SELECT userid, username, birthday FROM users\n"
                + "WHERE username LIKE ?\n"
                + "ORDER BY userid";

        try {
            connection = connector.getConnection();
            int userid = -1;
            String username = "";
            Date birthday = null;
            PreparedStatement state = connection.prepareStatement(sql);
            state.setString(1, "%"+keyword+"%");
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                userid = rs.getInt("userid");
                username = rs.getString("username");
                birthday = rs.getDate("birthday");

                UserInfo user = new UserInfo(userid, username, birthday);
                userList.add(user);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connector.close();
            }
        }
        return userList;
    }
    
    public static UserInfo selectUser(String useridStr) throws Exception {
        DBConnector connector = new DBConnector();
        Connection connection = null;
        UserInfo user = null;
        String sql = "SELECT userid, username, birthday FROM users\n"
                + "WHERE userid = ?";

        try {
            connection = connector.getConnection();
            int userid = Integer.parseInt(useridStr);
            String username = "";
            Date birthday = null;
            PreparedStatement state = connection.prepareStatement(sql);
            state.setInt(1, userid);
            ResultSet rs = state.executeQuery();
            if (rs.next()) {
                userid = rs.getInt("userid");
                username = rs.getString("username");
                birthday = rs.getDate("birthday");

                user = new UserInfo(userid, username, birthday);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connector.close();
            }
        }
        return user;
    }
    
    public static int insertUser(UserInfo user) throws Exception {
        DBConnector connector = new DBConnector();
        Connection connection = null;
        String sql = "INSERT INTO users\n"
                + "(username, birthday)\n"
                + "VALUES\n"
                + "(?, ?)";

        try {
            connection = connector.getConnection();
            String username = user.getUsername();
            Date birthday = user.getBirthday();
            PreparedStatement state = connection.prepareStatement(sql);
            state.setString(1, username);
            state.setDate(2, birthday);
            int count = state.executeUpdate();
            if (count > 0) {
                connection.commit();
            }
            return count;
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connector.close();
            }
        }
    }
    
    public static int updateUser(UserInfo user) throws Exception {
        DBConnector connector = new DBConnector();
        Connection connection = null;
        String sql = "UPDATE users\n"
                + "SET (username, birthday)\n"
                + "=\n"
                + "(?, ?)\n"
                + "WHERE userid = ?";

        try {
            connection = connector.getConnection();
            String username = user.getUsername();
            Date birthday = user.getBirthday();
            int userid = user.getUserid();
            PreparedStatement state = connection.prepareStatement(sql);
            state.setString(1, username);
            state.setDate(2, birthday);
            state.setInt(3, userid);
            int count = state.executeUpdate();
            if (count > 0) {
                connection.commit();
            }
            return count;
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connector.close();
            }
        }
    }
    
    public static int deleteUser(UserInfo user) throws Exception {
        DBConnector connector = new DBConnector();
        Connection connection = null;
        String sql = "DELETE FROM users\n"
                + "WHERE userid = ?";

        try {
            connection = connector.getConnection();
            int userid = user.getUserid();
            PreparedStatement state = connection.prepareStatement(sql);
            state.setInt(1, userid);
            int count = state.executeUpdate();
            if (count > 0) {
                connection.commit();
            }
            return count;
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connector.close();
            }
        }
    }
}
