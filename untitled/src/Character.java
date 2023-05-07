import Items.DefenceAttire;
import Items.Shield;
import Items.Weapon;

import java.util.HashMap;
import java.util.Map;

public class Character {

    // Character info
   private String firstName;

   private String lastName;

   private String homeProvince;

   private boolean death = false;

    // Character Defence stats

   private int health = 0;

   private int defence = 0;

   private int blockChance = 0;

    // Character Attack stats

   private Attack attack = new Attack(0, 0);

    // Character items, Inventory, money etc..

   private int denarius = 0;

   private Weapon weapon = new Weapon("none", 0 , 0);

   private Shield shield = new Shield("none", 0, 0);

   private DefenceAttire armor = new DefenceAttire("none", 0, 0, 0);

   private DefenceAttire helmet = new DefenceAttire("none", 0, 0, 0);;

   private DefenceAttire boots = new DefenceAttire("none", 0, 0, 0);;

   private int inventorySize = 0;

   private String[] inventory = new String[inventorySize];

    //Constructors


    public Character(String firstName, int health, int defence, Attack attack) {
        this.firstName = firstName;
        this.health = health;
        this.defence = defence;
        this.attack = attack;
    }

    public Character(String firstName, String lastName, int health, int defence, Attack attack) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.health = health;
        this.defence = defence;
        this.attack = attack;
    }

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
        int increaseAttackPower = weapon.getAttackPowerIncrease() + getAttackPower() - getWeapon().getAttackPowerIncrease();
        int increaseAttackSpeed = weapon.getAttackSpeedIncrease() + getAttackSpeed() - getWeapon().getAttackSpeedIncrease();
        this.attack = new Attack(increaseAttackSpeed, increaseAttackPower);
        System.out.println("You automatically sold your old weapon to the shop.");
        this.denarius += this.weapon.getSellPrice();
        System.out.println("You received " + this.weapon.getSellPrice() + " denarius for it.");
        this.weapon = weapon;
    }

    public void setShield(Shield shield) {
        int defenceIncrease = shield.getDefenceIncrease() + getDefence() - getShield().getDefenceIncrease();
        int blockChanceIncrease = shield.getBlockChance() + getBlockChance() - getShield().getBlockChance();
        this.defence = defenceIncrease;
        this.blockChance = blockChanceIncrease;
        System.out.println("You automatically sold your old shield to the shop.");
        this.denarius += this.shield.getSellPrice();
        System.out.println("You received " + this.shield.getSellPrice() + " denarius for it.");
        this.shield = shield;
    }

    public void setArmor(DefenceAttire armor) {
        int defenceIncrease = armor.getDefenceIncrease() + getDefence() - getArmor().getDefenceIncrease();
        int blockChanceIncrease = armor.getBlockChance() + getBlockChance() - getArmor().getBlockChance();
        int attackSpeedDecrease = getAttackSpeed() - armor.getAttackSpeedDecrease() + getArmor().getAttackSpeedDecrease();
        int attackKeep = attack.getPower();
        this.defence = defenceIncrease;
        this.blockChance = blockChanceIncrease;
        this.attack = new Attack(attackSpeedDecrease, attackKeep);
        System.out.println("You automatically sold your old armor to the shop.");
        this.denarius += this.armor.getSellPrice();
        System.out.println("You received " + this.armor.getSellPrice() + " denarius for it.");
        this.armor = armor;
    }

    public void setHelmet(DefenceAttire helmet) {
        int defenceIncrease = helmet.getDefenceIncrease() + getDefence() - getHelmet().getDefenceIncrease();
        int blockChanceIncrease = helmet.getBlockChance() + getBlockChance() - getHelmet().getBlockChance();
        int attackSpeedDecrease = getAttackSpeed() - helmet.getAttackSpeedDecrease() + getHelmet().getAttackSpeedDecrease();
        int attackKeep = attack.getPower();
        this.defence = defenceIncrease;
        this.blockChance = blockChanceIncrease;
        this.attack = new Attack(attackSpeedDecrease, attackKeep);
        System.out.println("You automatically sold your old helmet to the shop.");
        this.denarius += this.helmet.getSellPrice();
        System.out.println("You received " + this.helmet.getSellPrice() + " denarius for it.");
        this.helmet = helmet;
    }

    public void setBoots(DefenceAttire boots) {
        int defenceIncrease = boots.getDefenceIncrease() + getDefence() - getBoots().getDefenceIncrease();
        int blockChanceIncrease = boots.getBlockChance() + getBlockChance() - getBoots().getBlockChance();
        int attackSpeedDecrease = getAttackSpeed() - boots.getAttackSpeedDecrease() + getBoots().getAttackSpeedDecrease();
        int attackKeep = attack.getPower();
        this.defence = defenceIncrease;
        this.blockChance = blockChanceIncrease;
        this.attack = new Attack(attackSpeedDecrease, attackKeep);
        System.out.println("You automatically sold your old boots to the shop.");
        this.denarius += this.boots.getSellPrice();
        System.out.println("You received " + this.boots.getSellPrice() + " denarius for it.");
        this.boots = boots;
    }

    public void setInventorySize(int inventorySize) {
        this.inventorySize = inventorySize;
    }

    public void setDenarius(int denarius) {
        this.denarius = denarius;
    }

    public void looseHealth (int damage) {
        this.health -= damage;
        if (this.health == 0) {
            this.death = true;
        }
    }

    public void setDeath(boolean death) {
        this.death = death;
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

    public int getBlockChance() {
        return blockChance;
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

    public boolean isDeath() {
        return death;
    }
}
