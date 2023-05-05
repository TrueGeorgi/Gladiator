import Items.DefenceAttire;
import Items.Shield;
import Items.Weapon;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        INTRO:

        System.out.println("******************************************************************************************");

        System.out.println("So many noises around you. Footsteps, talking, screaming ");
        System.out.println("\"Come, bring it faster you idiots. The sun is killing me...\"");
        System.out.println("The person was right next to you, but still, you have decided to keep your eyes closed.");
        System.out.println("Lying there on the warm ground, seeing just dark, was kind of peaceful.");
        System.out.println("They can scream as much as they want. A small stone flew right at your head.");
        System.out.println("Someone must have kicked it pacing somewhere. You finally decide to open your eyes.");
        System.out.println("You were in a cage with around 10 other people. One of them was looking at you with an emotionless face.");
        System.out.println("You sat up, trying not to look at him, but he kept staring at you. \"What is your name?\" he asked.");

        System.out.println("******************************************************************************************");

        System.out.println();
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        System.out.println();
        Character mainCharacter = new Character(firstName, lastName);

        System.out.println("******************************************************************************************");

        System.out.println("I hope you can fight ... This person behind you is your new owner. A slave trader, gathering fighters for the arena.");
        System.out.println("In other words, you are soon to become a Gladiator. I'm Lucius Aemilius. From the African provinces.");
        System.out.println("How about you? Where is your home?");

        Character luciusAemilius = new Character("Lucius", "Aemilius", "Africa");

        System.out.println("******************************************************************************************");
        System.out.println();
        String[] provinces = {"Hispania", "Britannia", "Thrace", "Syria", "Gallia"};
        System.out.println("Choose your birth region:");
        System.out.println();
        System.out.println("1. Hispania");
        System.out.println("2. Britannia");
        System.out.println("3. Thrace");
        System.out.println("4. Syria");
        System.out.println("5. Gallia");
        System.out.println();
        mainCharacter.setHomeProvince(provinceCheck(provinces));
        System.out.println();
        System.out.println("******************************************************************************************");

        System.out.println("Ok, " + mainCharacter.getFirstName() + " " + mainCharacter.getLastName() + " from " + mainCharacter.getHomeProvince() + ".");
        System.out.println("\"We are probably going to leave any moment soon. As far as I understood we are heading to Pula, Venetia et Histria.\"");
        System.out.println("\"Lets go, you lazy donkeys\". What a miserable man this slave trader is, you thought.");
        System.out.println("After a couple of days of traveling, you have finally arrived at Pula.");
        System.out.println("The Amphitheatre was majestic, a beautiful place to die maybe. But no...you are here to survive.");
        System.out.println("The slave trader said that your new lanistae, was a man of honor.");
        System.out.println("If you survive 12 consecutive fights, you are to be a free man.");

        StatsSetUp:

        System.out.println("******************************************************************************************");
        System.out.println("Before you and the other gladiators are set to fight your first munera, you get to train a bit.");
        System.out.println("Maybe earn something that might help you in the long run as well.");
        Character dummy = new Character("Dummy", 5);
        mainCharacter.setAttack(new Attack(1, 1));
        mainCharacter.setHealth(10);
        mainCharacter.setDefence(1);
        mainCharacter.setEarnDenarius(5);

        mainCharacter.setWeapon(weapons().get(0));
        mainCharacter.setShield(shields().get(0));
        mainCharacter.setArmor(armors().get(0));
        mainCharacter.setHelmet(helmets().get(0));
        mainCharacter.setBoots(boots().get(0));

        mainCharacterStats(mainCharacter);

        TRAIN:

        System.out.println("Should we start?");
        String answerShouldWeStart = yesOrNoAnswer();
        int no = 0;

        while (!answerShouldWeStart.equals("yes")) {
            no++;

            if (no == 12) {
                System.out.println("Come on...there is no other option but to start.");
                no = 0;
            } else if (no == 9) {
                System.out.println("Still waiting for that yes...");
            } else if (no == 5) {
                System.out.println("Maybe now?");
            } else if (no == 2) {
                System.out.println("now?");
            } else {
                System.out.println("Ok, how about now?");
            }

            answerShouldWeStart = yesOrNoAnswer();
        }

        System.out.println("******************************************************************************************");

        System.out.println();
        System.out.println("What action would you like to take? Please choose the letter of the action you have chosen.");

        trainMenu();

        int trainMenuLength = 5;

        String action = correctLetterChosen(trainMenuLength);

        boolean continueAction = true;

        while (continueAction) {
            switch (action) {
                case "A":                                                      // train
                case "B":                                                      // shop
                    System.out.println("Do you want to: ");
                    System.out.println("A. Buy");
                    System.out.println("B. Sell");
                    String answerBuyOrSell = correctLetterChosen(2);
                    if (answerBuyOrSell.equals("A")) {
                        buyShop(weapons(), shields(), armors(), helmets(), boots());
                        String letterToBuy = correctLetterChosen(25);
                        char letterToBuyChar = letterToBuy.charAt(0);
                        int numberToBuy = 0;
                        if (letterToBuyChar >= 65 && letterToBuyChar <= 69) {
                            numberToBuy = letterToBuyChar - 65;
                            Weapon toBeBought = weapons().get(numberToBuy);
                            boolean canIBuyIt = canYouBuyIt(toBeBought.getCost(), mainCharacter);
                            if (canIBuyIt) {
                                int itemCost = toBeBought.getCost();
                                int denarius = mainCharacter.getDenarius();
                                int difference = denarius - itemCost;
                                mainCharacter.setDenarius(difference);
                                System.out.printf("You have bought %s for %d. You have %d left.", toBeBought.getName(), itemCost, difference);
                            } else {
                                System.out.println("You don't have enough money to but this item.");
                            }
                        } else if (letterToBuyChar >= 70 && letterToBuyChar <= 74) {
                            numberToBuy = letterToBuyChar - 70;
                            Shield toBeBought = shields().get(numberToBuy);
                            boolean canIBuyIt = canYouBuyIt(toBeBought.getCost(), mainCharacter);
                            if (canIBuyIt) {
                                int itemCost = toBeBought.getCost();
                                int denarius = mainCharacter.getDenarius();
                                int difference = denarius - itemCost;
                                mainCharacter.setDenarius(difference);
                                System.out.printf("You have bought %s for %d. You have %d left.", toBeBought.getName(), itemCost, difference);
                            } else {
                                System.out.println("You don't have enough money to but this item.");
                            }
                        } else if (letterToBuyChar >= 75 && letterToBuyChar <= 79) {
                            numberToBuy = letterToBuyChar - 75;
                            DefenceAttire toBeBought = armors().get(numberToBuy);
                            boolean canIBuyIt = canYouBuyIt(toBeBought.getCost(), mainCharacter);
                            if (canIBuyIt) {
                                int itemCost = toBeBought.getCost();
                                int denarius = mainCharacter.getDenarius();
                                int difference = denarius - itemCost;
                                mainCharacter.setDenarius(difference);
                                System.out.printf("You have bought %s for %d. You have %d left.", toBeBought.getName(), itemCost, difference);
                            } else {
                                System.out.println("You don't have enough money to but this item.");
                            }
                        } else if (letterToBuyChar >= 80 && letterToBuyChar <= 84) {
                            numberToBuy = letterToBuyChar - 80;
                            DefenceAttire toBeBought = helmets().get(numberToBuy);
                            boolean canIBuyIt = canYouBuyIt(toBeBought.getCost(), mainCharacter);
                            if (canIBuyIt) {
                                int itemCost = toBeBought.getCost();
                                int denarius = mainCharacter.getDenarius();
                                int difference = denarius - itemCost;
                                mainCharacter.setDenarius(difference);
                                System.out.printf("You have bought %s for %d. You have %d left.", toBeBought.getName(), itemCost, difference);
                            } else {
                                System.out.println("You don't have enough money to but this item.");
                            }
                        } else if (letterToBuyChar >= 85 && letterToBuyChar <= 89) {
                            numberToBuy = letterToBuyChar - 85;
                            DefenceAttire toBeBought = boots().get(numberToBuy);
                            boolean canIBuyIt = canYouBuyIt(toBeBought.getCost(), mainCharacter);
                            if (canIBuyIt) {
                                int itemCost = toBeBought.getCost();
                                int denarius = mainCharacter.getDenarius();
                                int difference = denarius - itemCost;
                                mainCharacter.setDenarius(difference);
                                System.out.printf("You have bought %s for %d. You have %d left.", toBeBought.getName(), itemCost, difference);
                            } else {
                                System.out.println("You don't have enough money to but this item.");
                            }
                        }
                    } else {

                    }
                case "C":                                                      // stats
                    mainCharacterStats(mainCharacter);
                    System.out.println("What do you want to do next?");
                    System.out.println();
                    trainMenu();
                    action = correctLetterChosen(trainMenuLength);
                case "D":                                                     // inventory
                    mainCharacterEquipment(
                            mainCharacter,
                            weapons(),
                            shields(),
                            armors(),
                            helmets(),
                            boots());
                    mainCharacterInventory(mainCharacter);
                    System.out.println("What do you want to do next?");
                    System.out.println();
                    trainMenu();
                    action = correctLetterChosen(trainMenuLength);
                case "E":                                                     // exit
            }
        }
    }

    public static String provinceCheck(String[] provinces) {
        Scanner scanner = new Scanner(System.in);

        boolean correctProvinceChosen = false;
        String provinceChosen = scanner.nextLine();
        while (!correctProvinceChosen) {
            if (provinceChosen.equals(provinces[0])
                    || provinceChosen.equals(provinces[1])
                    || provinceChosen.equals(provinces[2])
                    || provinceChosen.equals(provinces[3])
                    || provinceChosen.equals(provinces[4])) {
                correctProvinceChosen = true;
            } else if (provinceChosen.equals("1")
                    || provinceChosen.equals("2")
                    || provinceChosen.equals("3")
                    || provinceChosen.equals("4")
                    || provinceChosen.equals("5")) {
                int provinceNumber = Integer.parseInt(provinceChosen);
                provinceChosen = provinces[provinceNumber - 1];
            } else {
                System.out.println("Incorrect input. Please choose from the given Provinces");
                provinceChosen = scanner.nextLine();
            }
        }

        return provinceChosen;
    }

    public static String yesOrNoAnswer() {
        Scanner scanner = new Scanner(System.in);

        String answer = scanner.nextLine().toLowerCase();

        while (!answer.equals("no") && !answer.equals("yes")) {
            System.out.println("Only \"yes\" or \"no\" answer is possible.");
            answer = scanner.nextLine();
        }

        return answer;
    }

    public static String correctLetterChosen(int length) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toUpperCase();

        boolean isCorrect = false;

        while (!isCorrect) {
            if (input.length() != 1) {
                System.out.println("Please type down the letter of the action you want to take.");
                input = scanner.nextLine();
            } else {
                char letter = input.charAt(0);
                if (letter >= 65 && letter < 65 + length) {
                    isCorrect = true;
                } else {
                    System.out.println("Please type down the letter of the action you want to take.");
                    input = scanner.nextLine();
                }
            }
        }
        return input;
    }

    public static void trainMenu() {
        System.out.println("A. Train");                             // Not done
        System.out.println("B. Shop");                              // Not done
        System.out.println("C. Look at your stats");                // DONE
        System.out.println("D. Look in your inventory");            // DONE
        System.out.println("E. Exit the game");                     // Not done
    }

    public static void mainCharacterStats(Character mainCharacter) {
        System.out.println("Your starting stats are as followed: ");
        System.out.println("Health: " + mainCharacter.getHealth());
        System.out.println("Attack power: " + mainCharacter.getAttackPower());
        System.out.println("Attack speed: " + mainCharacter.getAttackSpeed());
        System.out.println("Defence: " + mainCharacter.getDefence());
        System.out.println("You also own " + mainCharacter.getDenarius() + " Denarius");
    }

    public static void mainCharacterEquipment(Character mainCharacter,
                                              List<Weapon> weapons,
                                              List<Shield> shields,
                                              List<DefenceAttire> armors,
                                              List<DefenceAttire> helmets,
                                              List<DefenceAttire> boots) {
        if (mainCharacter.getWeapon().getName().equals("none")
        && mainCharacter.getShield().getName().equals("none")
        && mainCharacter.getArmor().getName().equals("none")
        && mainCharacter.getHelmet().getName().equals("none")
        && mainCharacter.getBoots().getName().equals("none")) {
            System.out.println("You are not wearing anything yet. Head to the shop and buy something.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } else {
            if (mainCharacter.getWeapon().getName().equals("none")) {
                System.out.println("You don't have a weapon yet. You can find some in the shop.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            } else {
                System.out.println("Your weapon is: " + mainCharacter.getWeapon().getName());
                System.out.println("   * Attack power + " + mainCharacter.getWeapon().getAttackPowerIncrease());
                System.out.println("   * Attack speed + " + mainCharacter.getWeapon().getAttackSpeedIncrease());
                System.out.println("   * You can sell it for: " + mainCharacter.getWeapon().getSellPrice() + " Denarius.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }

            if (mainCharacter.getShield().getName().equals("none")) {
                System.out.println("You don't have a shield yet. You can find some in the shop.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            } else {
                System.out.println("Your shield is: " + mainCharacter.getShield().getName());
                System.out.println("   * Defence + " + mainCharacter.getShield().getDefenceIncrease());
                System.out.println("   * Block chance + " + mainCharacter.getShield().getBlockChance());
                System.out.println("   * You can sell it for: " + mainCharacter.getShield().getSellPrice() + " Denarius.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }

            if (mainCharacter.getArmor().getName().equals("none")) {
                System.out.println("You don't have an armor yet. You can find some in the shop.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            } else {
                System.out.println("Your armor is: " + mainCharacter.getArmor().getName());
                System.out.println("   * Defence + " + mainCharacter.getArmor().getDefenceIncrease());
                System.out.println("   * Block chance + " + mainCharacter.getArmor().getBlockChance());
                System.out.println("   * Attack speed - " + mainCharacter.getArmor().getAttackSpeedDecrease());
                System.out.println("   * You can sell it for: " + mainCharacter.getArmor().getSellPrice());
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }

            if (mainCharacter.getHelmet().getName().equals("none")) {
                System.out.println("You don't have a helmet yet. You can find some in the shop.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            } else {
                System.out.println("Your helmet is: " + mainCharacter.getHelmet().getName());
                System.out.println("   * Defence + " + mainCharacter.getHelmet().getDefenceIncrease());
                System.out.println("   * Block chance + " + mainCharacter.getHelmet().getBlockChance());
                System.out.println("   * Attack speed - " + mainCharacter.getHelmet().getAttackSpeedDecrease());
                System.out.println("   * You can sell it for: " + mainCharacter.getHelmet().getSellPrice());
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }

            if (mainCharacter.getBoots().getName().equals("none")) {
                System.out.println("You don't have boots yet. You can find some in the shop.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            } else {
                System.out.println("Your boots are: " + mainCharacter.getBoots().getName());
                System.out.println("   * Defence + " + mainCharacter.getBoots().getDefenceIncrease());
                System.out.println("   * Block chance + " + mainCharacter.getBoots().getBlockChance());
                System.out.println("   * Attack speed - " + mainCharacter.getBoots().getAttackSpeedDecrease());
                System.out.println("   * You can sell them for: " + mainCharacter.getBoots().getSellPrice());
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
        }
    }

    public static void mainCharacterInventory(Character mainCharacter) {
        if (mainCharacter.getInventorySize() == 0) {
            System.out.println("You don't have anything to store items in");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } else {
            for (String item : mainCharacter.getInventory()) {
                System.out.println("   * " + item);
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    public static List<Weapon> weapons() {
        List<Weapon> weaponsList = new ArrayList<>();

        Weapon none = new Weapon("none", 0, 0);
        weaponsList.add(none);                                     // 1
        Weapon blunt = new Weapon("Blunt", 4, 4, 20);
        weaponsList.add(blunt);
        Weapon gladius = new Weapon("Gladius", 6, 4, 40);
        weaponsList.add(gladius);
        Weapon spear = new Weapon("Spear", 3,5, 25);
        weaponsList.add(spear);
        Weapon sica = new Weapon("Sica", 7, 4, 55);
        weaponsList.add(sica);
        Weapon net = new Weapon("Net", 9, 1, 10);
        weaponsList.add(net);

        return weaponsList;
    }

    public static List<Shield> shields() {
        List<Shield> shieldsList = new ArrayList<>();

        Shield none = new Shield("none", 0, 0);
        shieldsList.add(none);

        Shield scutum = new Shield("Scutum", 1, 5, 5);
        shieldsList.add(scutum);

        Shield parma = new Shield("Parma", 2, 7, 15);
        shieldsList.add(parma);

        Shield pelta = new Shield("Pelta", 1, 10, 20);
        shieldsList.add(pelta);

        Shield clipeus = new Shield("Clipeus", 2, 10, 30);
        shieldsList.add(clipeus);

        Shield hoplon = new Shield("Hoplon", 3, 10, 40);
        shieldsList.add(hoplon);

        return shieldsList;
    }

    public static List<DefenceAttire> armors() {
        List<DefenceAttire> armorsList = new ArrayList<>();

        DefenceAttire none = new DefenceAttire("none", 0, 0, 0);
        armorsList.add(none);

        DefenceAttire balteus = new DefenceAttire("Balteus", 0, 5, 0, 5);
        armorsList.add(balteus);

        DefenceAttire leatherArmor = new DefenceAttire("Leather armor", 1, 10, 0, 15);
        armorsList.add(leatherArmor);

        DefenceAttire cappadocianLeatherArmor = new DefenceAttire("Cappadocian leather armor", 2, 10, 0, 20);
        armorsList.add(cappadocianLeatherArmor);

        DefenceAttire loricaSegmentata = new DefenceAttire("Lorica Segmentata", 2, 20, 1, 25);
        armorsList.add(loricaSegmentata);

        DefenceAttire loricaHamata = new DefenceAttire("Lorica Hamata", 3, 20, 1, 35);
        armorsList.add(loricaHamata);

        return armorsList;
    }

    public static List<DefenceAttire> helmets() {
        List<DefenceAttire> helmetsList = new ArrayList<>();

        DefenceAttire none = new DefenceAttire("none", 0, 0, 0);
        helmetsList.add(none);

        DefenceAttire coolus = new DefenceAttire("Coolus", 0, 5, 0, 5);
        helmetsList.add(coolus);

        DefenceAttire italoCorinthian = new DefenceAttire("Italo-Corinthian", 1, 10, 0, 15);
        helmetsList.add(italoCorinthian);

        DefenceAttire romanAuxiliary = new DefenceAttire("Roman Auxiliary", 2, 10, 0, 20);
        helmetsList.add(romanAuxiliary);

        DefenceAttire montefortino = new DefenceAttire("Montefortino", 2, 20, 1, 25);
        helmetsList.add(montefortino);

        DefenceAttire imperialGallic = new DefenceAttire("Imperial Gallic", 3, 20, 1, 35);
        helmetsList.add(imperialGallic);

        return helmetsList;
    }

    public static List<DefenceAttire> boots() {
        List<DefenceAttire> bootsList = new ArrayList<>();

        // Sandals, Soccus, Carbatina, Caligae, Gallica

        DefenceAttire none = new DefenceAttire("none", 0, 0, 0);
        bootsList.add(none);

        DefenceAttire sandals = new DefenceAttire("Sandals", 0, 5, 0, 5);
        bootsList.add(sandals);

        DefenceAttire soccus = new DefenceAttire("Soccus", 1, 10, 0, 15);
        bootsList.add(soccus);

        DefenceAttire carbatina = new DefenceAttire("Carbatina", 2, 10, 0, 20);
        bootsList.add(carbatina);

        DefenceAttire caligae = new DefenceAttire("Caligae", 2, 20, 1, 25);
        bootsList.add(caligae);

        DefenceAttire gallica = new DefenceAttire("Gallica", 3, 20, 1, 35);
        bootsList.add(gallica);

        return bootsList;
    }
    public static void buyShop (List<Weapon> weapons,
                                List<Shield> shields,
                                List<DefenceAttire> armors,
                                List<DefenceAttire> helmets,
                                List<DefenceAttire> boots) {
        System.out.println("If you like something, simply choose his letter.");
        System.out.println("Here is the what you can buy: ");
        System.out.println("Weapons: ");
        System.out.println("A: " + weapons().get(1).getName() + " for " + weapons().get(1).getCost() + " denarius");
        System.out.println("B: " + weapons().get(2).getName() + " for " + weapons().get(2).getCost() + " denarius");
        System.out.println("C: " + weapons().get(3).getName() + " for " + weapons().get(3).getCost() + " denarius");
        System.out.println("D: " + weapons().get(4).getName() + " for " + weapons().get(4).getCost() + " denarius");
        System.out.println("E: " + weapons().get(5).getName() + " for " + weapons().get(5).getCost() + " denarius");
        System.out.println("Shields: ");
        System.out.println("F: " + shields().get(1).getName() + " for " + shields().get(1).getCost() + " denarius");
        System.out.println("G: " + shields().get(2).getName() + " for " + shields().get(1).getCost() + " denarius");
        System.out.println("H: " + shields().get(3).getName() + " for " + shields().get(2).getCost() + " denarius");
        System.out.println("I: " + shields().get(4).getName() + " for " + shields().get(3).getCost() + " denarius");
        System.out.println("J: " + shields().get(5).getName() + " for " + shields().get(4).getCost() + " denarius");
        System.out.println("Armors: ");
        System.out.println("K: " + armors().get(1).getName() + " for " + armors().get(1).getCost() + " denarius");
        System.out.println("L: " + armors().get(2).getName() + " for " + armors().get(2).getCost() + " denarius");
        System.out.println("M: " + armors().get(3).getName() + " for " + armors().get(3).getCost() + " denarius");
        System.out.println("N: " + armors().get(4).getName() + " for " + armors().get(4).getCost() + " denarius");
        System.out.println("O: " + armors().get(5).getName() + " for " + armors().get(5).getCost() + " denarius");
        System.out.println("Helmets: ");
        System.out.println("P: " + helmets().get(1).getName() + " for " + helmets().get(1).getCost() + " denarius");
        System.out.println("Q: " + helmets().get(2).getName() + " for " + helmets().get(2).getCost() + " denarius");
        System.out.println("R: " + helmets().get(3).getName() + " for " + helmets().get(3).getCost() + " denarius");
        System.out.println("S: " + helmets().get(4).getName() + " for " + helmets().get(4).getCost() + " denarius");
        System.out.println("T: " + helmets().get(5).getName() + " for " + helmets().get(5).getCost() + " denarius");
        System.out.println("Boots: ");
        System.out.println("U: " + boots().get(1).getName() + " for " + boots().get(1).getCost() + " denarius");
        System.out.println("V: " + boots().get(2).getName() + " for " + boots().get(2).getCost() + " denarius");
        System.out.println("W: " + boots().get(3).getName() + " for " + boots().get(3).getCost() + " denarius");
        System.out.println("X: " + boots().get(4).getName() + " for " + boots().get(4).getCost() + " denarius");
        System.out.println("Y: " + boots().get(5).getName() + " for " + boots().get(5).getCost() + " denarius");
    }

    public static boolean canYouBuyIt (int itemPrice, Character mainCharacter) {
        int characterMoney = mainCharacter.getDenarius();
        boolean canI = true;
        if (itemPrice > characterMoney) {
            canI = false;
        }

        return canI;
    }

    public static void sellItems (Character mainCharacter) {
        if (mainCharacter.getWeapon().getName().equals("none")
                && mainCharacter.getShield().getName().equals("none")
                && mainCharacter.getArmor().getName().equals("none")
                && mainCharacter.getHelmet().getName().equals("none")
                && mainCharacter.getBoots().getName().equals("none")
        && mainCharacter.getInventorySize() == 0) {
            System.out.println("You have nothing to sell.");
        }
    }
}
