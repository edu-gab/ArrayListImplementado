/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listaimplementada;

/**
 *
 * @author eduardo
 */
public class ArrayList<E> implements List<E> {
    
    private int capacity = 100;
    private E[] elements = null;
    private int effectiveSize = 0;
    
    public ArrayList(){
        this.elements = (E[]) new Object[capacity];
        this.effectiveSize = 0;
    }
    
    @Override
    public boolean addFirst(E e) {
        if(e == null){
            return false;
        } else if(isEmpty()){
            elements[effectiveSize++] = e;
            return true;
        } else if(isFull()){
            addCapacity();
        }
        
        for(int i = effectiveSize - 1; i >= 0; i--){
            elements[i+1] = elements[i];
        }
        
        elements[0] = e;
        effectiveSize++;
        
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if(e == null){
            return false;
        } else if(isEmpty()){
            elements[effectiveSize++] = e;
            return true;
        } else if(isFull()){
            addCapacity();
        }
        
        elements[effectiveSize] = e;
        effectiveSize++;
        return true;
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
       return remove(this.effectiveSize - 1);
    }

    @Override
    public int size() {
        return effectiveSize;
    }

    @Override
    public boolean isEmpty() {
        return effectiveSize == 0;
    }

    @Override
    public void clear() {
        effectiveSize = 0;
    }

    @Override
    public void add(int index, E element) {
        if(element == null){
            throw new NullPointerException();
        } else if(index < 0 || index > this.effectiveSize){
            throw new IndexOutOfBoundsException();
        } else if(this.isEmpty()){
            elements[effectiveSize++] = element;
        } else if(this.isFull()){
            this.addCapacity();
        }
        for(int i = effectiveSize; i >= index; i--){
            elements[i+1] = elements[i];
        }
        
        elements[index] = element;
        effectiveSize++;
        
    }

    @Override
    public E remove(int index) {
        E eRemove = null;
        
        if(this.isEmpty() || index > this.effectiveSize || index < 0){
            throw new IndexOutOfBoundsException();
        } else{
            eRemove = elements[index];
            for(int i = index; i < this.effectiveSize - 1; i++){
                elements[i] = elements[i+1];
            }
            
            effectiveSize--;
            
        }
        
        return eRemove;
    }

    @Override
    public E get(int index) {
        if(this.isEmpty() && index < effectiveSize){
            return elements[index];
        }
        
        return null;
    }

    @Override
    public E set(int index, E element) {
       if(index < 0 || index >= this.effectiveSize){
           throw new IndexOutOfBoundsException();
       } else{
           E eViejo = elements[index];
           elements[index] = element;
           
           return eViejo;
       }
    }
    
    private void addCapacity(){
        E[] nuevo = (E[]) new Object[capacity * 2];
        for(int i = 0; i < elements.length; i++){
            nuevo[i] = elements[i];
        }
        
        elements = nuevo;
        capacity *= 2;
    }
    
    private boolean isFull(){
        return effectiveSize == capacity;
    }

    @Override
    public String toString() {
        return "ArrayList{" + ", elements=" + elements + '}';
    }
    
    
}
