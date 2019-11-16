package com.bit.operation;/*
 * @Program:testbook
 * @Description:description
 * @Author:Pufang
 * @Time:2019-11-16 11-30-39
 **/

import com.bit.book.Book;
import com.bit.book.BookList;

public class AddOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("添加书籍");
        System.out.println("请输入图书的名字：");
        String name = scanner.next();
        System.out.println("请输入图书的作者：");
        String author = scanner.next();
        System.out.println("请输入图书的价格：");
        int price = scanner.nextInt();
        System.out.println("请输入图书的类型：");
        String type = scanner.next();
        Book book = new Book(name,author,price,type);
        //没有考虑满的情况
        int curSize = bookList.getSize();
        bookList.setBooks(curSize,book);
        bookList.setSize(curSize + 1);
        System.out.println("添加书籍成功！");
    }
}
