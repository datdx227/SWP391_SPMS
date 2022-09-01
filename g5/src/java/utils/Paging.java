/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.List;

/**
 *
 * @author Acer
 */
public class Paging<T> {
    private final int PAGE_SIZE =5;
    private List<T> list;
    //private int page;
    public Paging(List<T> list){
        this.list = list;
        //this.page = page;
    }
    public List<T> show(int page){
        int startIndex = Math.max((page-1)*PAGE_SIZE, 0);
        int endIndex = Math.min(page*PAGE_SIZE, list.size());
        return list.subList(startIndex, endIndex);
    }
    public boolean isNext(int page){
        return (list.size()-1>page*PAGE_SIZE-1);
    }
    public boolean isPrevious(int page){
        return (page>1);
    }
}
