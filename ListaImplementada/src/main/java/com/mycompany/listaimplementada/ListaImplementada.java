/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listaimplementada;

/**
 *
 * @author eduardo
 */
public class ListaImplementada {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        System.out.println(arrayList.isEmpty());
        
        arrayList.addFirst(1);
        arrayList.addLast(3);
        arrayList.add(1, 2);
        System.out.println(arrayList);
        arrayList.set(2, 4);
        System.out.println(arrayList);
        System.out.println(arrayList.removeFirst());
        System.out.println(arrayList.removeLast());
    }
}
