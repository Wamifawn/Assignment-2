import java.util.Random;
import java.io.FileWriter; 
import java.io.IOException;

public class Main {
    public static void saveNumbers(int[] array, String filename) { 
        try { 
            FileWriter writer = new FileWriter(filename); 
            for (int num : array) { 
                writer.write(num + "\n"); 
            }
            writer.close();
            System.out.println("Saved " + array.length +  " numbers to " + filename); 
        } catch (IOException e ) { 
            System.out.println("Errorr saving to file: " + e.getMessage()); 
        }
    }
    public static void main(String[] args) {
        int size = 1000; 
        int[] numbers = new int[size]; 
        Random rand = new Random(); 

        for (int i = 0; i < size; i++) { 
            numbers[i] = i; 
        }
        for (int i = 0; i < size; i++ ) { 
            int j = i + rand.nextInt(size - i); 
            int temp = numbers[i]; 
            numbers[i] = numbers[j]; 
            numbers[j] = temp; 
        }

        saveNumbers(numbers, "numbers.txt");
    }

}
