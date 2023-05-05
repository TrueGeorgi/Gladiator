package Items;

public class Shield {

    String name;

    int defenceIncrease;

    int blockChance;                   // percentage

    int cost;


    public Shield(String name, int defenceIncrease, int blockChance, int cost) {
        this.name = name;
        this.defenceIncrease = defenceIncrease;
        this.blockChance = blockChance;
        this.cost = cost;
    }

    public Shield(String name, int defenceIncrease, int blockChance) {
        this.name = name;
        this.defenceIncrease = defenceIncrease;
        this.blockChance = blockChance;
    }

    public String getName() {
        return name;
    }

    public int getDefenceIncrease() {
        return defenceIncrease;
    }

    public int getBlockChance() {
        return blockChance;
    }

    public int getCost() {
        return cost;
    }

    public int getSellPrice() {
        return cost * 80 / 100;         // the selling price is with 20% lower than the buy cost.
    }
}
