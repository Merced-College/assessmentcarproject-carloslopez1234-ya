// Asssmesment 



        public  class Car {
            
                
                private String car_ID; 
                private String Brand;
                private String model;
                private int year;
                private String Fuel_type;
                private String Color;
                private double Mileage_kmpl;
                public String getCar_ID() {
                    return car_ID;
                }

                    // make getters and setters
                public void setCar_ID(String car_ID) {
                    this.car_ID = car_ID;
                }

                public String getBrand() {
                    return Brand;
                }

                public void setBrand(String brand) {
                    this.Brand = brand;
                }

                public String getModel() {
                    return model;
                }

                public void setModel(String model) {
                    this.model = model;
                }

                public int getYear() {
                    return year;
                }

                public void setYear(int year) {
                    this.year = year;
                    }

                 public void setFuel_type(String fuel_type) {
                    this.Fuel_type = fuel_type;
                }

                public String getFuel_type() {
                    return Fuel_type;
                }

                public String getColor() {
                    return Color;
                }

                public void setColor(String color) {
                    this.Color = color;
                }

                public double getMileage_kmpl() {
                    return Mileage_kmpl;
                }

                public void setMileage_kmpl(double mileage_kmpl) {
                    this.Mileage_kmpl = mileage_kmpl;

                }
                // The to string to show the car types
                @Override
                public String toString() {
                    return "Car [ID=" + car_ID + ", Brand=" + Brand + ", Model=" + model + 
                    ", Year=" + year + ", Fuel=" + Fuel_type + ", Color=" + Color + 
                    ", Mileage=" + Mileage_kmpl + "]" ;



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
        }
        scanner.close();
    } catch (java.io.FileNotFoundException e) {
        System.out.println("Could not find the CSV file!");
    }
}
                }
            