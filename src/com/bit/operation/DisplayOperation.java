package com.bit.operation;/*
 * @Program:testbook
 * @Description:description
 * @Author:Pufang
 * @Time:2019-11-16 11-31-40
 **/

import com.bit.book.BookList;

public class DisplayOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("DisplayOperation");
        for (int i = 0; i < bookList.getSize(); i++) {
            System.out.println(bookList.getBook(i));
        }
    }
}
