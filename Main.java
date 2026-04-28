import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Car> loadCars(String filename) {
        ArrayList<Car> cars = new ArrayList<>();
        try {
            java.io.File myFile = new java.io.File(filename);
            java.util.Scanner scanner = new java.util.Scanner(myFile);

            // Skip the header row
            if (scanner.hasNextLine()) scanner.nextLine();

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] parts = data.split(",");
                if (parts.length == 7) {
                    try {
                        String car_ID = parts[0].trim();
                        String Brand = parts[1].trim();
                        String model = parts[2].trim();
                        int year = Integer.parseInt(parts[3].trim());
                        String Fuel_type = parts[4].trim();
                        String Color = parts[5].trim();
                        double Mileage_kmpl = Double.parseDouble(parts[6].trim());
                        Car car = new Car(car_ID, Brand, model, year, Fuel_type, Color, Mileage_kmpl);
                        cars.add(car);
                    } catch (Exception e) {
                        // Skip malformed rows
                    }
                }
            }
            scanner.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Could not find the CSV file!");
        }
        System.out.println("Total cars loaded: " + cars.size());
        return cars;
    }

    // Selection sort by Brand (case-insensitive)
    public static void selectionSort(ArrayList<Car> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getBrand().toLowerCase().compareTo(list.get(minIndex).getBrand().toLowerCase()) < 0) {
                    minIndex = j;
                }
            }
            // Swap
            Car temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }

    // Binary search by Brand (case-insensitive)
    public static Car binarySearch(ArrayList<Car> list, String key) {
        int low = 0;
        int high = list.size() - 1;
        key = key.toLowerCase();
        while (low <= high) {
            int mid = (low + high) / 2;
            String midBrand = list.get(mid).getBrand().toLowerCase();
            if (midBrand.compareTo(key) < 0) {
                low = mid + 1;
            } else if (midBrand.compareTo(key) > 0) {
                high = mid - 1;
            } else {
                return list.get(mid);
            }
        }
        return null;
    }

    // Compute stats
    public static void printStats(ArrayList<Car> list) {
        double totalMileage = 0;
        int count = 0;
        java.util.Map<String, Integer> fuelCounts = new java.util.HashMap<>();
        for (Car car : list) {
            totalMileage += car.getMileage_kmpl();
            count++;
            String fuel = car.getFuel_type().toLowerCase();
            fuelCounts.put(fuel, fuelCounts.getOrDefault(fuel, 0) + 1);
        }
        double avgMileage = count > 0 ? totalMileage / count : 0;
        System.out.println("Average mileage: " + avgMileage);
        System.out.println("Fuel type counts:");
        for (String fuel : fuelCounts.keySet()) {
            System.out.println(fuel + ": " + fuelCounts.get(fuel));
        }
    }

    public static void main(String[] args) {
        ArrayList<Car> cars = loadCars("Car_Data.csv");
        ArrayList<Car> working = new ArrayList<>(cars.subList(0, Math.min(2000, cars.size())));

        Scanner scanner = new Scanner(System.in);
        boolean sorted = false;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Sort by Brand");
            System.out.println("2. Search by Brand");
            System.out.println("3. Show Stats");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                selectionSort(working);
                sorted = true;
                System.out.println("Sorted. First 10 cars:");
                for (int i = 0; i < Math.min(10, working.size()); i++) {
                    System.out.println(working.get(i));
                }
            } else if (choice == 2) {
                if (!sorted) {
                    System.out.println("Please sort first.");
                    continue;
                }
                System.out.print("Enter brand to search: ");
                String brand = scanner.nextLine();
                Car found = binarySearch(working, brand);
                if (found != null) {
                    System.out.println("Found: " + found);
                } else {
                    System.out.println("Not found.");
                }
            } else if (choice == 3) {
                printStats(working);
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}

        



