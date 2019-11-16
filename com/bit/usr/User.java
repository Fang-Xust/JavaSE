package com.bit.usr;/*
 * @Program:testbook
 * @Description:description
 * @Author:Pufang
 * @Time:2019-11-16 11-28-35
 **/

import com.bit.book.BookList;
import com.bit.operation.IOperation;

public abstract class User {
    protected String name;
    protected IOperation[] operations;

    public abstract int menu();
    //根据用户选项执行操作
    public void doOperation(int choice, BookList bookList) {
        operations[choice].work(bookList);
    }
}
