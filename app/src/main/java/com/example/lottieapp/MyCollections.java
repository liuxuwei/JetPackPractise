package com.example.lottieapp;

class MyCollections {
    private static final MyArrayList arrayList = new MyArrayList();
    private static final MyLinkedList linkedList = new MyLinkedList();


    static MyLinkedList getLinkedListInstance(){
        return linkedList;
    }

    static MyArrayList getArrayListInstance() {
        return arrayList;
    }



    private static class MyArrayList extends MyCollections {

        MyArrayList() {
            System.out.println("init my arrayList");
        }
    }


    private static class MyLinkedList extends MyCollections {


        MyLinkedList() {
            System.out.println("init my linkedList");
        }


    }
}
