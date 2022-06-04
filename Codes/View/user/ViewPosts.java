package Codes.View.user;

import java.util.InputMismatchException;
import java.util.Scanner;

import Codes.Model.entities.Post;
import Codes.Model.entities.Singleton;
import Codes.Model.utils.date.Datee;
import Codes.View.design.ViewInterface;

public class ViewPosts {
    private static Scanner s = new Scanner(System.in);


    public static void homeScreenPosts(String userName){
        int option;
        System.out.println("\n");
        ViewInterface.homePosts();
        option = s.nextInt();

        while (option < 1 || option > 3) {
            ViewInterface.homeMessages();
            option = s.nextInt();
        }
        try{
            switch (option) {
                case 1:
                    ViewPosts.createPost(userName);
                    break;
                case 2:
                    ViewPosts.removePost(userName);
                    break;
                case 3:
                    break;
            }
        }catch(InputMismatchException ex){
            System.out.println("You have entered a different type of read");
            System.out.println("Critical error has occored");
            System.out.println(" :C ");
        }
    }

    

    public static void viewPost(String userName){
        for (Post post :  Singleton.searchUser(userName).getPosts()) {
            System.out.println(post.toString());      
        }
    }


    public static void createPost(String userName){
        String date = Datee.calendar();
        System.out.println("\n");
        System.out.println("New Post");
        System.out.println("Add a new title to your post");
        String title = s.nextLine();
        title = s.nextLine();
        System.out.println("Add a new content to your post");
        String content = s.nextLine();
        Post post = new Post(date, title, content);
        System.out.println("\n");
        
        System.out.println(post);
        Post.addPost(post, userName);
    }



    public static void removePost(String userName){ 
        System.out.println("\n");
        System.out.println("Enter the title of the post you want to remove");
        String title = s.next();
        Singleton.searchUser(userName).getPosts().remove(Post.removePost(userName, title));
        System.out.println("post successfully removed");
    }
}
