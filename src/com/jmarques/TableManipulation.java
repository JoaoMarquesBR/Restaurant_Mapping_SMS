package com.jmarques;

import java.util.List;

public class TableManipulation {
    static List <Table>list = TableMapping.myTables;

    public void printTables(){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }


   public void tableOccupy(String tableName, String newStatus, String... customerName) {
       System.out.println("Customername length is " + customerName.length);
       for (int i = 0; i < list.size(); i++) {
           if (list.get(i).getName().equals(tableName)) {
               if (customerName.length != 0) {
                   list.get(i).setGuestName(customerName[0]);
               }
               list.get(i).setStatus(newStatus);
           }
       }
   }
}
