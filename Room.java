import java.util.Scanner;
//import java.util.Arrays;

public class Room
{
   //inst vars
   private int roomNumber, capacity; 
   private boolean smart, occupied;

   
//---------------------------constrs----------------------

   //Default constr
   public Room()
   {
      setRmNum(0);
      setCapacity(0);
      smart = false;
      occupied = false; 
   }//end default
   
   //non-default constr
   public Room(int rmNumPassed, int capacityPassed, boolean smartPassed, boolean occupiedPassed)
   {
      setRmNum(rmNumPassed);
      setCapacity(capacityPassed);
      setSmartRm(smartPassed);
      setOccupied(occupiedPassed); 
   }//end non-default
   
   //ToString
   public String toString()
   {
      return "\nRoom #: " + roomNumber +
             "\nCapacity: " + capacity +
             "\nSmart T/F: " +  smart +
             "\nOccupied T/F: " + occupied +"\n";
   }//end ToString


//---------------------------getters----------------------------------
   public int getRmNum()
   {
      return roomNumber;
   }//end getRm#
   
   public int getCapacity()
   {
      return capacity;
   }//end getCapacity 
   
   public boolean getSmart()//and his shoe phone
   {
      return smart;
   }//end getSmart
   
   public boolean getOccupied()
   {
      return occupied;
   }//end getOccupied


//---------------------------setters----------------------------------------

   public void setRmNum(int rmNumPassed)
   {
      Scanner keyboard = new Scanner(System.in);
      roomNumber = rmNumPassed;
      //data val
      while(roomNumber < 1 || roomNumber > 24)
      {
         System.out.println("Room# must be 1 - 24; enter room#: ");
         roomNumber = keyboard.nextInt();
      }//end while 4 data val 
   }//end setRm#
   
   public void setCapacity(int capacityPassed)
   {
      Scanner keyboard = new Scanner(System.in); 
      capacity = capacityPassed;
      //data val
      while(capacity < 20 || capacity > 50)
      {
         System.out.println("Capacity of room must be 20 - 50; enter capacity: ");
         capacity = keyboard.nextInt();
      }//end while 4 data val 
   }//end setCapacity
   
   public void setSmartRm(boolean smartPassed)
   {
      smart = smartPassed;
   }//end setSmartRm
   
   public void setOccupied(boolean occupiedPassed)
   {
      occupied = occupiedPassed;
   }//end setOccupied


//------------------------------other methods-------------------------- 

   //OVERRIDE dot equals
   public boolean equals(Room roomPassed)
   {
      /*
      inst vars: roomNumber, capacity, smart, occupied
      */
      return this.roomNumber == roomPassed.roomNumber
      &&
      this.capacity == roomPassed.capacity
      &&
      this.smart == roomPassed.smart
      &&
      this.occupied == roomPassed.occupied;
   }//end OVERRIDE dot equals
   
}//end class Room