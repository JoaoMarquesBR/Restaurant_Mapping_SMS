package com.jmarques;

import java.util.ArrayList;

public class TableMapping {
    static ArrayList<Pixel> map = new ArrayList<>();
    public static ArrayList<Table>myTables = new ArrayList<>();

    public TableMapping(int x, int y) {
        for(int a = 0;a<x+1;a++){
            for(int b=0;b<y+1;b++){
                map.add(new Pixel(a,b));
            }
        }
    }

    private static boolean  checkPixelUse(int x,int y){
        for(int i=0;i<map.size();i++){
            if(map.get(i).x == x && map.get(i).y == y){
                if(map.get(i).status.equals("empty")){
                    return true;
                }
            }
        }
        return false;
    }

    private static void setPixel(int x,int y){
        for(int i=0;i<map.size();i++){
            if(map.get(i).x == x && map.get(i).y == y){
                map.get(i).setStatus("USE");
            }
        }
    }

    public static void createTable(String tableName,int seats,int x,int y,int height,int length){
        boolean permissionToCreate=false;
        int endX =( x+length-1);
        int endY =( y+height-1);

        //check if pixels of table are in use in the map or not
        for(int myX = x; myX<=endX ;myX++){
            for(int myY = y; myY <= endY ; myY++){
                if(checkPixelUse(myX,myY)){
                    permissionToCreate=true;
                }else{
                    permissionToCreate=false;
                    break;
                }
            }

            //in case one of the pixels can't be used, then we Break the whole loop
            if(!permissionToCreate)
                break;
        }


        if(permissionToCreate){
            Table table = new Table(tableName,seats,x,y,height,length );
            TableMapping.myTables.add(table);
            for(int myX = x; myX<=endX ;myX++){
                for(int myY = y; myY <= endY ; myY++){

                    setPixel(myX,myY);

                }
            }
        }else{
            System.out.println("One of these pixels are already in use");
        }

    }

}

 class Pixel{
    int x;
    int y;
    String status;
     public Pixel(int x, int y) {
         this.x = x;
         this.y = y;
         status = "empty";
     }


     public String getStatus() {
         return status;
     }
     public void setStatus(String status) {
         this.status = status;
     }
 }

 class Table {
    private String name;
    private int seats;
    private String status;
    private String guestName;

    private int height;
    private int length;

    private int x;
    private int y;


     public Table(String name, int seats,int x,int y,int height, int length) {
         this.name = name;
         this.seats = seats;
         this.x = x;
         this.y= y;
         this.height = height;
         this.length = length;
         status="free";
         guestName = "Guest";

     }

    public Table(String name, int seats, String status) {
        this.name = name;
        this.seats = seats;
        this.status = status;
    }

     public boolean isOccupying(int x,int y){

         int startX = this.x;
         int endX =( this.x+length-1);

         int startY = this.y;
         int endY = this.y+height-1;

         if( (x>= startX && x<=endX) &&  (y>= startY && y<= endY) ) {
             return true;
         }

         return false;
     }

     public void setStatus(String status) {
         this.status = status;
     }

     @Override
     public String toString() {
         return "\nTable{" +
                 "name='" + name + '\'' +
                 ", seats=" + seats +
                 ", status='" + status + '\'' +
                 ", guestName='" + guestName + '\'' +
                 '}';
     }

     public String getStatus() {
         return status;
     }

     public int getSeats() {
         return seats;
     }

     public String getName() {
         return name;
     }

     public String getGuestName() {
         return guestName;
     }

     public void setGuestName(String guestName) {
         this.guestName = guestName;
     }
 }