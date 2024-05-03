/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integernumberarray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author Asus
 */
public class IntegerArray {
    
    private int count;
    private int[] elements;
    
    private int num;
   
    
    public int getElement(int index){
        try {
         int el = elements[index];
         System.out.println("Access element "+ index +": "+ el);
        } catch (ArrayIndexOutOfBoundsException e) {
           System.out.println("Exception thrown  :" + e);
        }
        return elements[index];
    }  
    public void setElement(int index, int value){
        try {
         elements[index] = value;
         System.out.println("Access element "+ index + "\n");
        } catch (ArrayIndexOutOfBoundsException e) {
           System.out.println("Exception thrown  :" + e +"\n");
        }
    }
    
    public int getCount(){
       return count;    
    }    
    public void setNum(int x){
       num = x;    
    }
    public int getNum(){
       return num;    
    }  
   
    public int getInteger() {
    java.util.Scanner scan = new java.util.Scanner(System.in);
    while (scan.hasNextLine()) {
        if (scan.hasNextInt()) {
            return scan.nextInt();
        } else {
            System.out.printf("%s не е цяло число %n", scan.nextLine());
        }
    }
    return -1;
}
    public IntegerArray(){

        int [] array = new int[100];
        int cnt = -1;
        try{
        java.util.Scanner scan = new java.util.Scanner(new File("age.csv"));
        
        while(scan.hasNextInt()){
            int a;
            a = scan.nextInt();
            if( a>0 ){
                cnt++;
                array[cnt] = a;
            }else
                break;
        }
        scan.close();
        count = cnt + 1;
        elements = new int[count];
        for(int i = 0; i < count; i++){
            elements[i] = array[i];
        }
        }
        catch(FileNotFoundException e) {
           System.out.println("Exception thrown  :" + e);
        }
    
    }
    public IntegerArray(int[] array, int num1){
        int length = array.length;
        count = length;
        elements = new int [length];
        for (int i = 0; i < length; i++){
            elements[i] = array[i];
        }  
        num = num1;
    }
    public IntegerArray( IntegerArray array){
        count = array.getCount();
        elements = new int[count];
        for(int i = 0; i < count; i++){
            elements[i] = array.getElement(i);
        }    
        num = array.getNum();
    } 
    public int calcMid(){
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < count; i++){
            sum = sum + elements[i];
            cnt = cnt + 1;
        }
        int midAge = sum/cnt;
        return midAge;
        
    }
    public void calcSum(){
        int sum = 0;
        for(int i = 0; i < count; i++){
            sum = sum + elements[i];
        }
        System.out.print("\n Сума на елементите на масива:" + sum + " \n");
    }
    public void calcProduct(){
        int product = 1;
        for(int i = 0; i < count; i++){
            product = product*elements[i];
        }
        System.out.print("\n Произведение на елементите на масива:" + product + " \n");
    }
    public int calcMax(){
        int max = elements[0];
        for(int i = 0; i < count; i++){ 
            if(max < elements[i]) max = elements[i];
        }
        return max;
        
    }
   public int calcMin(){
     int min = elements[0];
        for(int i = 0; i < count; i++){ 
            if(elements[i] < min) 
            {
                min = elements[i];
            }
        }
        return min;
    }
    public int byGroups(int a, int b){
       int sum = 0;
       for(int i = 0; i < count; i++){ 
            if( (elements[i]>= a)&&( elements[i] <=b)) 
            {
                sum ++;
            }
        }
       return sum;
    }    
    
    public void writeLessThan(){
        System.out.print("\n Елементите, по-малки от " + num + " са:\n");
        int flag = 0;
        for(int i = 0; i < count; i++){ 
            if(num > elements[i]){
                flag++;
                System.out.print("\n element[" + (i + 1) + " ] = " + elements[i] + "\n");
            }
        }
        if(flag == 0)
            System.out.print("\n  Няма елементи, по-малки от " + num +"\n");
    }    
    public void writeGreaterThan(){
        System.out.print("\n Елементите, по-големи от " + num + " са:\n");
        int flag = 0;
        for(int i = 0; i < count; i++){ 
            if(num < elements[i]){
                 flag++;
                 System.out.print("\n element[" + (i + 1) + " ] = " + elements[i] + "\n");
            }
        }
        if(flag == 0)
            System.out.print("\n  Няма елементи, по-големи от " + num + "\n");
    }  
    public void writeEqualTo(){
        System.out.print("\n Елементите, равни на " + num + " са:\n");
        int flag = 0;
        for(int i = 0; i < count; i++){ 
            if(num == elements[i]){
               flag++; 
               System.out.print("\n element[" + (i + 1) + " ] = " + elements[i] + "\n");
            }
        }
        if(flag == 0)
            System.out.print("\n  Няма eлементи, равни на " + num +  "\n");
    }   
    public void printElements(){
        for (int i = 0; i < count; i++) {

            System.out.print("\n elements[" + (i + 1) + "] = " + elements[i]);
        }
    }    
}
