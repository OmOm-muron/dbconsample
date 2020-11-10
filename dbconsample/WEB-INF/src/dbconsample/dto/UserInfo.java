package dbconsample.dto;

import java.sql.Date;
import java.util.Calendar;

public class UserInfo {
    private int userid;
    private String username;
    private Date birthday;
    
    public UserInfo() {
        // blank constructor
    }
    
    public UserInfo(String useridStr, String username, String birthdayStr) {
        if (useridStr != null && !useridStr.isEmpty()) {
            int userid = Integer.parseInt(useridStr);
            this.setUserid(userid);
        }
        if (username != null) {
            this.setUsername(username);
        }
        if (birthdayStr != null && !birthdayStr.isEmpty()) {
            String[] birthdaySplit = birthdayStr.split("-");
            int year = Integer.parseInt(birthdaySplit[0]);
            int month = Integer.parseInt(birthdaySplit[1]) - 1;    // Calendarクラスの月定数が0スタートのため
            int day = Integer.parseInt(birthdaySplit[2]);
            
            Calendar birthdayCal = Calendar.getInstance();
            birthdayCal.set(Calendar.YEAR, year);
            birthdayCal.set(Calendar.MONTH, month);
            birthdayCal.set(Calendar.DAY_OF_MONTH, day);
            
            Date birthday = new Date(birthdayCal.getTimeInMillis());
            this.setBirthday(birthday);
        }
    }
    
    public UserInfo(int userid, String username, Date birthday) {
        if (userid > 0) {
            this.setUserid(userid);
        }
        if (username != null) {
            this.setUsername(username);
        }
        if (birthday != null) {
            this.setBirthday(birthday);
        }
    }
    
    /**
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }
    /**
     * @param userid the userid to set
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }
    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
