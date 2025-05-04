public class Item {
    private int weight;
    private int cost;
    private boolean isAdded = false;
    private int index;

    public Item(int cost, int weight, int index) {
        this.weight = weight;
        this.cost = cost;
        this.index = index;
    }

    public int getWeight() {
        return weight;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCost() {
        return cost;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }

    public int getIndex() {
        return  this.index;
    }
}
