/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author anumj
 */
public class SampleArray {

    public static class OrderLine {

        private String item;
        private int quantity;

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
        
        @Override
        public boolean equals(Object o){
            return (o instanceof OrderLine) && ((OrderLine) o).getItem().equals(this.getItem())
                    && ((OrderLine) o).getQuantity() == this.getQuantity();
        }
        
        @Override
        public int hashCode(){
            return (1 + this.getQuantity() + this.getItem().hashCode());
        }

        @Override
        public String toString() {
            return "Item :: " + item + " Quantity :: " + quantity;
        }

    }

    public static void main(String args[]) {
        ArrayList<OrderLine> list1 = generateList();
        ArrayList<OrderLine> list2 = generateList();
        toPrint(list1, list2);
    }
//    static ArrayList<OrderLine> diffList = new ArrayList<OrderLine>();

    static void toPrint(ArrayList<OrderLine> list1, ArrayList<OrderLine> list2) {
        System.out.println(" -list1- "+list1);
        System.out.println(" -list2- "+list2);
//        System.out.println("Iterating list1\n\n");
//        list1.forEach((OrderLine newLine1) -> {
//            System.out.println("newLineItem N1:" + newLine1);
//            diffList.add(newLine1);
//            list2.forEach((newLine2) -> {
//                System.out.println(" N2:" + newLine2.getItem() + " Q2: " + newLine2.getQuantity());
//                if ((newLine1.getQuantity()) == (newLine2.getQuantity()) && ((newLine1.getItem()).equals(newLine2.getItem()))) {
//                    System.out.println("Entering if...");
//                    
//                    diffList.remove(newLine1);
//
//                    System.out.println("1st size : " + diffList.size());
//                }
//
//            });
//        });
        List<OrderLine> diffList1 = list1.stream().filter(orderLine -> !list2.contains(orderLine)).collect(Collectors.toList());
        List<OrderLine> diffList2 = list2.stream().filter(orderLine -> !list1.contains(orderLine)).collect(Collectors.toList());
        diffList1.addAll(diffList2);
        
        /* Iterating 2nd list*/
//        System.out.println("Iterating list2 \n\n");
//        list2.forEach((OrderLine newLine2) -> {
//            diffList.add(newLine2);
//            System.out.println("newLineItem N2:" + newLine2.getItem() + " Q2: " + newLine2.getQuantity());
//            list1.forEach((newLine1) -> {
//                System.out.println("N1:" + newLine1.getItem() + " Q1: " + newLine1.getQuantity());
//                if ((newLine2.getQuantity()) == (newLine1.getQuantity()) && ((newLine1.getItem()).equals(newLine2.getItem()))) {
//                    System.out.println("2nd Entering if...");
//                    diffList.remove(newLine2);
//                    System.out.println("2nd size : " + diffList.size());
//                }
//            });
//        }
//        );
        /*Iterating diff list*/
        diffList1.forEach(diffLine -> {
            System.out.println("Different ArrayList Values .." + diffLine);
        });

    }

    static ArrayList<OrderLine> generateList() {
        ArrayList<OrderLine> list = new ArrayList<>();
        Random random = new Random();
        int listSize = random.nextInt(5);
        for (int x = 0; x < listSize; x++) {
            OrderLine newLine = new OrderLine();
            newLine.setItem("ITEM" + random.nextInt(3) + random.nextInt(3));
            newLine.setQuantity(random.nextInt(3));
            list.add(newLine);
        }
        return list;
    }

}