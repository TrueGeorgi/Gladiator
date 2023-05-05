import Items.DefenceAttire;
import Items.Shield;
import Items.Weapon;

public class Character {

    // Character info
    String firstName;

    String lastName;

    String homeProvince;

    boolean death = false;

    // Character Defence stats

    int health;

    int defence;

    // Character Attack stats

    Attack attack;

    // Character items, Inventory, money etc..

    int denarius = 0;

    Weapon weapon;

    Shield shield;

    DefenceAttire armor;

    DefenceAttire helmet;

    DefenceAttire boots;

    int inventorySize = 0;

    String[] inventory = new String[inventorySize];

    //Constructors
    public Character(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Character(String firstName, String lastName, String homeProvince) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeProvince = homeProvince;
    }

    public Character(String firstName, int health) {
        this.firstName = firstName;
        this.health = health;
    }

    // Setters


    public void setHomeProvince(String homeProvince) {
        this.homeProvince = homeProvince;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    public void setEarnDenarius(int denarius) {
        this.denarius += denarius;
    }

    public void setSpendDenarius(int denarius) {
        if (denarius <= this.denarius) {
            this.denarius -= denarius;
        } else {
            int difference = denarius - this.denarius;
            System.out.printf("You need %d more denarius%n", difference);
        }
    }

    public void setInventorySizeIncrease(int inventorySize) {
        this.inventorySize += inventorySize;
    }

    public void setInventorySizeDecrease(int inventorySize) {
        this.inventorySize -= inventorySize;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public void setArmor(DefenceAttire armor) {
        this.armor = armor;
    }

    public void setHelmet(DefenceAttire helmet) {
        this.helmet = helmet;
    }

    public void setBoots(DefenceAttire boots) {
        this.boots = boots;
    }

    public void setInventorySize(int inventorySize) {
        this.inventorySize = inventorySize;
    }

    public void setDenarius(int denarius) {
        this.denarius = denarius;
    }

    // Getters


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHomeProvince() {
        return homeProvince;
    }

    public int getHealth() {
        return health;
    }

    public int getDefence() {
        return defence;
    }

    public int getAttackSpeed() {
        return attack.getSpeed();
    }

    public int getAttackPower() {
        return attack.getPower();
    }

    public int getDenarius() {
        return denarius;
    }

    public int getInventorySize() {
        return inventorySize;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Shield getShield() {
        return shield;
    }

    public DefenceAttire getArmor() {
        return armor;
    }

    public DefenceAttire getHelmet() {
        return helmet;
    }

    public DefenceAttire getBoots() {
        return boots;
    }

    public String[] getInventory() {
        return inventory;
    }
}
