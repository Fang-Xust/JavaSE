package com.bit;/*
 * @Program:testbook
 * @Description:description
 * @Author:Pufang
 * @Time:2019-11-16 11-30-15
 **/

import com.bit.book.Book;
import com.bit.book.BookList;
import com.bit.usr.Admin;
import com.bit.usr.NormalUser;
import com.bit.usr.User;

import java.util.Scanner;

public class Main {
    public static User login(){
        System.out.println("请输入你的名字：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("请输入你的身份(1 表示管理员, 0 表示普通用户):");
        int who = scanner.nextInt();
        if(who == 1){
            return new Admin(name);
        }else{
            return new NormalUser(name);
        }
    }
    public static void main(String[] args) {
        BookList bookList = new BookList();

        User user = login();
        while(true){
            int choice = user.menu();
            user.doOperation(choice,bookList);
        }
    }
}
