import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.AbstractExecutorService;

public class Heuristika {

    private Reader reader;
    private ArrayList<Item> data;
    private static final int K = 11500;
    private ArrayList<Item> solution;
    private static final int R = 350;
    private Reader data1;

    public Heuristika() throws FileNotFoundException {
        this.reader = new Reader("H1_c.txt", "H1_a.txt");
        this.data = reader.getItems();
        this.solution = new ArrayList<>();
    }

    public void algoritmus() {
        int currentWeight = 0;
        while (solution.size() < R) {
            Item bestWeight = null;
            for (Item item : this.data) {
                if (!item.isAdded() && currentWeight + item.getWeight() <= K) {
                    if (bestWeight == null || item.getWeight() < bestWeight.getWeight()) {
                        bestWeight = item;
                    }
                }
            }


            if (bestWeight == null) {
                break;
            }
            bestWeight.setAdded(true);
            this.solution.add(bestWeight);
            currentWeight += bestWeight.getWeight();

        }
        int totalCost = 0;
        for (Item item : this.solution) {
            totalCost += item.getCost();
        }
        System.out.println("Pocet prkov: " + solution.size());
        System.out.println("Celkova hmotnosť: " + currentWeight);
        System.out.println("Hodnota ucelovej funckie: " + totalCost);


    }

    public void betterSolution() {
        int totalCost = 0;
        int totalWeigth = 0;


        for (Item item : solution) {
            totalCost += item.getCost();
            totalWeigth += item.getWeight();

        }


        for (int i = 0; i < solution.size(); i++) {
            Item current = solution.get(i);

            for (Item candidate : data) {
                if (!candidate.isAdded()) {
                    double currentRatio = (double) current.getCost() / current.getWeight();
                    double candidateRatio = (double) candidate.getCost() / candidate.getWeight();

                    int newWeight = totalWeigth + candidate.getWeight() - current.getWeight();
                    int newCost = totalCost + candidate.getCost() - current.getCost();

                    if (candidateRatio > currentRatio && newWeight <= K) {

                        candidate.setAdded(true);
                        current.setAdded(false);
                        solution.set(i, candidate);
                        totalWeigth = newWeight;
                        totalCost = newCost;
                        break;
                    }
                }
            }
        }


        totalWeigth = 0;
        totalCost = 0;
        for (
                Item item : solution) {
            totalCost += item.

                    getCost();

            totalWeigth += item.

                    getWeight();
        }
        System.out.

                println("Pocet prkov: " + solution.size());
        System.out.

                println("Celkova hmotnosť: " + totalWeigth);
        System.out.

                println("Hodnota ucelovej funckie: " + totalCost);
    }


}


