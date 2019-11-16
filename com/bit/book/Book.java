package com.bit.book;/*
 * @Program:testbook
 * @Description:description
 * @Author:Pufang
 * @Time:2019-11-16 11-28-08
 **/

public class Book {
    public String name;
    public String author;
    public int price;
    public String type;
    public boolean isBorrowed;

    public Book(String name, String author, int price, String type) {
        this.name = name;//书名
        this.author = author;//作者
        this.price = price;//价格
        this.type = type;//小说
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ((isBorrowed == true) ? "，已经被借出":"，未借出")+
                //", isBorrowed=" + isBorrowed +
                '}';
    }
}
