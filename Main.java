//import java.util.ArrayList;

public class Main {

    //public static ArrayList cars = new ArrayList();
         static int binarySearch(int[] cars, int key) {
      int low = 0;
      int high = cars.length - 1;
   
      while (high >= low) {
         int mid = (high + low) / 2;
         if (cars[mid] < key) {
            low = mid + 1;
         }
         else if (cars[mid] > key) {
            high = mid - 1;
         }
         else {
            return mid;
         }
      }
   
      return -1; // not found
   }


    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.setBrand("Toyota");
        System.out.println(myCar.getBrand());
            
        try {
            java.io.File myFile = new java.io.File("Car_Data.csv");
            java.util.Scanner scanner = new java.util.Scanner(myFile);

            // Skip the header row if your CSV has one
            if (scanner.hasNextLine()) scanner.nextLine();

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            System.out.println(data); // This prints each row from the file

            //make your Car object from that data, use contructor
            //insert in arraylist
                    
        }
            scanner.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Could not find the CSV file!");
        }
    }
            //public void myCar.Sort(data);
            



}

        



