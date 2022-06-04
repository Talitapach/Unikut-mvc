package Codes.View.user;

import Codes.Model.entities.Singleton;
import Codes.Model.utils.date.Datee;

public class ViewPerfil {
    public static void perfilUser(String userName){
        System.out.println("\n");
        System.out.println(Datee.calendar());
        System.out.println("@"+ userName);
        System.out.println("#######" + "   "+ Singleton.searchUser(userName).sizePosts() + "     " + Singleton.searchUser(userName).sizeFriends());
        if(Singleton.searchUser(userName).sizePosts() < 2 && Singleton.searchUser(userName).sizeFriends() < 2){
            System.out.println("#######" + " Post " + " Friend ");
        }
        if(Singleton.searchUser(userName).sizePosts() >= 2 && Singleton.searchUser(userName).sizeFriends() >= 2){
            System.out.println("#######" + " Posts " + " Friends ");
        }
        if(Singleton.searchUser(userName).sizePosts() < 2 && Singleton.searchUser(userName).sizeFriends() >= 2){
            System.out.println("#######" + " Post " + " Friends ");
        }
        if(Singleton.searchUser(userName).sizePosts() >= 2 && Singleton.searchUser(userName).sizeFriends() < 2){
            System.out.println("#######" + " Posts " + " Friend ");
        }
        System.out.println("#######");
        System.out.println("#######");
        System.out.println(Singleton.searchUser(userName).getName());
        System.out.println(" ");
        ViewPosts.viewPost(userName);
        System.out.println(" ");
    }
}
