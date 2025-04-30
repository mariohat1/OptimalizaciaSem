import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

    ArrayList<Item> items;

    public Reader(String costFileName, String weightFileName) throws FileNotFoundException {
        this.items = new ArrayList<Item>();
       ArrayList<Integer> weights = readFromFile(weightFileName);
        ArrayList<Integer> costs = readFromFile(costFileName);
        for (int i = 0; i < weights.size(); i++) {
            items.add(new Item(costs.get(i), weights.get(i)));
        }

    }
    private ArrayList<Integer> readFromFile(String filename) throws FileNotFoundException {
        ArrayList<Integer> result = new ArrayList<>();
        Scanner reader = new Scanner(new File(filename));
        while (reader.hasNextInt()) {
            result.add(reader.nextInt());
        }
        reader.close();
        return result;
    }

    ArrayList<Item> getItems()  {
        return this.items;

    }
}
