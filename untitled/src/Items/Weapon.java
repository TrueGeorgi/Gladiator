package Items;

public class Weapon {

    String name;

    int attackSpeedIncrease;

    int attackPowerIncrease;

    int cost;



    public Weapon(String name, int attackSpeedIncrease, int attackPowerIncrease, int cost) {
        this.name = name;
        this.attackSpeedIncrease = attackSpeedIncrease;
        this.attackPowerIncrease = attackPowerIncrease;
        this.cost = cost;
    }

    public Weapon(String name, int attackSpeedIncrease, int attackPowerIncrease) {
        this.name = name;
        this.attackSpeedIncrease = attackSpeedIncrease;
        this.attackPowerIncrease = attackPowerIncrease;
    }

    public String getName() {
        return name;
    }

    public int getAttackSpeedIncrease() {
        return attackSpeedIncrease;
    }

    public int getAttackPowerIncrease() {
        return attackPowerIncrease;
    }

    public int getCost() {
        return cost;
    }

    public int getSellPrice() {
        return cost * 80 / 100;         // the selling price is with 20% lower than the buy cost.
    }
}
