package board.CRUDBoard.controller;

import java.util.Date;

public class BoardForm {
    private String name;
    private String password;
    private String title;
    private String content;
    private Date date;

    public Date getDate() {
        Date time = new Date();
        return time;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
