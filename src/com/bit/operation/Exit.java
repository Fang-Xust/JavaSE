package com.bit.operation;/*
 * @Program:testbook
 * @Description:description
 * @Author:Pufang
 * @Time:2019-11-16 11-32-07
 **/

import com.bit.book.BookList;

public class Exit implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("ByeBye!");
        System.exit(0);
    }
}
