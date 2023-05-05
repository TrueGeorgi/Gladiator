package Items;

public class DefenceAttire {

    String name;

    int defenceIncrease;

    int blockChance;                   // percentage

    int attackSpeedDecrease;

    int cost;


    public DefenceAttire(String name, int defenceIncrease, int blockChance, int attackSpeedDecrease, int cost) {
        this.name = name;
        this.defenceIncrease = defenceIncrease;
        this.blockChance = blockChance;
        this.attackSpeedDecrease = attackSpeedDecrease;
        this.cost = cost;
    }

    public DefenceAttire(String name, int defenceIncrease, int blockChance, int attackSpeedDecrease) {
        this.name = name;
        this.defenceIncrease = defenceIncrease;
        this.blockChance = blockChance;
        this.attackSpeedDecrease = attackSpeedDecrease;
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

    public int getAttackSpeedDecrease() {
        return attackSpeedDecrease;
    }

    public int getCost() {
        return cost;
    }

    public int getSellPrice() {
        return cost * 80 / 100;         // the selling price is with 20% lower than the buy cost.
    }
}
