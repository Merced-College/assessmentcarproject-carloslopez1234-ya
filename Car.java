// Asssmesment 



public  class Car {
            
                
                private String car_ID; 
                private String Brand;
                private String model;
                private int year;
                private String Fuel_type;
                private String Color;
                private double Mileage_kmpl;

                // Constructor
                public Car(String car_ID, String Brand, String model, int year, String Fuel_type, String Color, double Mileage_kmpl) {
                    this.car_ID = car_ID;
                    this.Brand = Brand;
                    this.model = model;
                    this.year = year;
                    this.Fuel_type = Fuel_type;
                    this.Color = Color;
                    this.Mileage_kmpl = Mileage_kmpl;
                }
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
                    return car_ID + ", " + Brand + ", " + model + ", " + year + ", " + Fuel_type + ", " + Color + ", " + Mileage_kmpl;
                }

        }
        
            