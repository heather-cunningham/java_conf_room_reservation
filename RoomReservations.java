import java.util.Scanner;
//import java.util.Arrays;
import java.util.Random;

public class RoomReservations
{
   public static void main(String [] args) throws Exception
   {
      int rmTotal = 24;
      Room[] reservations = new Room[rmTotal];
      populateReservations(reservations);
      displayMenu(reservations);
    }//end main
   
   
//------------------------Methods------------------------ 
 
   public static Room[] populateReservations(Room[] reservationsPassed)
   {
		int rmCount = 1;
      Random rng = new Random();
      boolean smartY_N = false;      
      
      for(int i = 0; i < reservationsPassed.length; ++i)
      {
         smartY_N = alternateSmartT_F(smartY_N);
         reservationsPassed[i] = new Room(rmCount, (rng.nextInt(30) + 20), smartY_N, false);
         ++rmCount;
      }//end outer for loop to pop res arr
      
      return reservationsPassed;
   }//end populateReservations
   
   public static boolean alternateSmartT_F(boolean smartY_Npassed)
   {
      if(smartY_Npassed == false)
         smartY_Npassed = true;
      else
         smartY_Npassed = false;
      
      return smartY_Npassed;
   }//end alternateSmartRoom
   
   public static void displayMenu(Room[] reservationsPassed)
   {
      Scanner keyboard = new Scanner(System.in);
      int menuOption;
      
      do
      {
         System.out.println("Menu Options");
         System.out.println("------------");
         System.out.println("Press 1 to List all rooms");
         System.out.println("Press 2 to List all available rooms");
         System.out.println("Press 3 to List all available smart rooms");
         System.out.println("Press 4 to List all available non-smart rooms");
         System.out.println("Press 5 to List all available rooms sorted by capacity (low to high)");
         System.out.println("Press 6 to List all available smart rooms sorted by capacity (low to high)");
         System.out.println("Press 7 to List all available non-smart rooms sorted by capacity (low to high)");
         System.out.println("Press 8 to Reserve a room");
         System.out.println("Press 9 to Cancel a room reservation");
         System.out.println("Press 0 to Quit");
         System.out.println();
         System.out.println("Enter menu option: ");
         menuOption = keyboard.nextInt();
      
         //menu switch
         switch(menuOption)
         {
            case 0://Quit
               System.out.println("Thank you for using the room reservation system.");
               break;
            case 1://List all Rooms
               listAllRooms(reservationsPassed);
               System.out.println();
               break;   
            case 2://List all avlbl rooms
               listAllAvlblRooms(reservationsPassed);
               break;
            case 3://List all avlbl Smart rooms
               listAllAvlblSmart(reservationsPassed);
               break;
            case 4://List all avlbl Non-Smart rooms
               listAllAvlblNonSmart(reservationsPassed);
               break;
            case 5://Sort and List all AVLBL rooms by capacity
               sortRmCapacity(reservationsPassed);
               listAllAvlblRooms(reservationsPassed);
               break;
            case 6://Sort and List all AVLBL smart rooms by capacity
               sortRmCapacity(reservationsPassed);
               listAllAvlblSmart(reservationsPassed);
               break;
            case 7://Sort and List all AVLBL Non-smart rooms by capacity
               sortRmCapacity(reservationsPassed);
               listAllAvlblNonSmart(reservationsPassed);
               break;
            case 8://Reserve room
               reserveRoom(reservationsPassed);
               break;
            case 9://Cancel reservation
               cancelReservation(reservationsPassed);
               break;
            default:
               System.out.println("Please enter 0 - 9 or M for menu.");
               break;          
         }//end menu switch
      }while(menuOption != 0);//end do while
   }//end displayMenu
   
   public static void menuSelection(String menuOptionPassed, Room[] reservationsPassed)
   {
      Scanner keyboard = new Scanner(System.in);
      String m = "";
         }//end menuSelection
      
   //menu option 1
   public static void listAllRooms(Room[] reservationsPassed)
   {
      for(int i = 0; i < reservationsPassed.length; i++)
         System.out.println(reservationsPassed[i].toString() );
   }//end listAllRooms
   
   //menu option 2
   public static void listAllAvlblRooms(Room[] reservationsPassed)
   {
      for(int i = 0; i < reservationsPassed.length; i++)
      {
         if(reservationsPassed[i].getOccupied() == false)
            System.out.println(reservationsPassed[i].toString() );
      }   
   }//end listAllAvlblRooms
   
   //menu option 3
   public static void listAllAvlblSmart(Room[] reservationsPassed)
   {
      for(int i = 0; i < reservationsPassed.length; i++)
      {
         if(reservationsPassed[i].getOccupied() == false && reservationsPassed[i].getSmart() == true)
            System.out.println(reservationsPassed[i].toString() );
      }
   }//end listAllAvlblSmart
   
   //menu option 4
   public static void listAllAvlblNonSmart(Room[] reservationsPassed)
   {
      for(int i = 0; i < reservationsPassed.length; i++)
      {
         if(reservationsPassed[i].getOccupied() == false && reservationsPassed[i].getSmart() == false )
            System.out.println(reservationsPassed[i].toString() );
      }
   }//end listAllAvlblNonSmart
   
   //menu options 5,6,7
   public static void sortRmCapacity(Room[] reservationsPassed)
   {
      Room temp;
      
      for(int i = 1; i < reservationsPassed.length; ++i)
      {
         for(int j = 0; j < (reservationsPassed.length - i); ++j)
         {
            if( reservationsPassed[j].getCapacity() > reservationsPassed[j+1].getCapacity() )
            {
              temp = reservationsPassed[j];
              reservationsPassed[j] = reservationsPassed[j + 1];
              reservationsPassed[j + 1] = temp;
            }//end IF    
         }//end inner loop
      }//end outer loop
   }//end sortRmCapacity
   
   //menu option 8
   public static void reserveRoom(Room[] reservationsPassed)
   {
      Scanner keyboard = new Scanner(System.in);
      int rmNum = 0;
      
      do
      {
         System.out.println("Which room # would you like to reserve (1 - 24)?");
         rmNum = keyboard.nextInt();
      }while(rmNum < 1 || rmNum > 24);
      
      if( reservationsPassed[rmNum - 1].getRmNum()== rmNum && reservationsPassed[rmNum - 1].getOccupied() == false)
      {
         reservationsPassed[rmNum - 1].setOccupied(true);
         System.out.println("You have reserved:" + reservationsPassed[rmNum - 1].toString() );
      }
      else
      {
         System.out.println("Room # " + rmNum + " is reserved already.  Please, pick another room.\n" );
         reserveRoom(reservationsPassed);
      }
            
   }//end reserveRoom
   
   //menu option 9
   public static void cancelReservation(Room[] reservationsPassed)
   {
      Scanner keyboard = new Scanner(System.in);
      int rmNum = 0;
      String yesNo = "";
      
      do
      {
         System.out.println("Which room # would you like to cancel (1 - 24)?");
         rmNum = keyboard.nextInt();
      }while(rmNum < 1 || rmNum > 24);
      
      if( reservationsPassed[rmNum - 1].getRmNum()== rmNum && reservationsPassed[rmNum - 1].getOccupied() == true)
      {
         reservationsPassed[rmNum - 1].setOccupied(false);
         System.out.println("You have canceled reserved room:" + reservationsPassed[rmNum - 1].toString() );
      }
      else
      {
         System.out.println("Room # " + rmNum + " hasn't been reserved yet.");
         System.out.println("Did you mean to cancel another room #?" );
         System.out.println("Returning to main  menu.\n");
      }
   }//end cancelReservation
   
}//end class RoomReservations
