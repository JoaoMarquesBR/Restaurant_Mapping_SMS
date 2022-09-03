package com.jmarques;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
	// write your code here

        //sets the size of the restaurant map
        TableMapping tableMap = new TableMapping(20,20);


        TableMapping.createTable("A",4,0,0, 3,7);
        TableMapping.createTable("B",4,5,8, 2,5);
        TableMapping.createTable("C",4,7,0,2,4);
        for(int y=0;y<=10;y++){
            System.out.print(y +" = ");
            for(int x=0;x<=20;x++){
                ArrayList<Table>list = TableMapping.myTables;
                for(int i=0;i<list.size();i++){
                    if(list.get(i).isOccupying(x,y)){
                        System.out.print("" + list.get(i).getName());
                    }else{
                        System.out.print("-");
                    }
                }
            }
            System.out.println("\n");
        }


        TableManipulation manip = new TableManipulation();
        manip.tableOccupy("B","Busy","Joao");
        manip.tableOccupy("A","Busy");
        manip.tableOccupy("C","Busy","Vini");


        manip.printTables();


    }
}
