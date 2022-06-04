package Codes.Model.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Post extends Comment{
    private String moment;
    private String title;
    private String content;

    public Post() {
    }

    public Post(String moment, String title, String content) {
        this.moment = moment;
        this.title = title;
        this.content = content;
    }
    

    public String getMoment() {
        return this.moment;
    }

    public Date getDate() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  HH:mm");
        Date d = sdf.parse(getMoment());
        return d;
        
    }

    public void setMoment(String moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public static void addPost(Post post, String userName){
        Singleton.searchUser(userName).getPosts().add(post);
    }

    public static Post removePost(String userName, String title){
        for (Post post : Singleton.searchUser(userName).getPosts()) {
            if (post.getTitle().equals(title)) {
                return post;
            }
        }
        return null;
    }



    @Override
    public String toString() {
        return "moment: " + moment + "\n" +
        "title: " + title + "\n" +
        "content: " + content +"\n";
    }
}
