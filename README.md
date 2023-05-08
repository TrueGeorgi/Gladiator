# Gladiator
RPG text-based game, where you take the role of a Gladiator, try to survive and win your freedom. The game is written only with Java and on Intellij IDEA.

## Still in progress

### 05.05.2023 Update

I have created the begging of the game. Up to the point before the first fight. 
  The classes for the items and Character were created. The Main character, plus the starting options were added. 
  For now the player can create his Character with name and Last name, choose a region and reach the moment before the first fight.
  The first menu was created where the player can either - Buy or sell items, see his current stats and inventory, exit the game completly or start the training. 
  
### 07.05.2023 part 1 Update

the Menu is almost ready, execept for the option to train. The fighting simulation needs to be updated as it does not work properly. 
Some of the main issues so far were cleared as:
  * When you buy an item, the stats were not added to your Character's stats.
  * Sometimes when the player tries to buy an item, another itmes was bought.
  * When you buy an item, the previus item was replaced, but his bonuses were not removed from the character.
  * If the player choice an option from the menu and then needs to choose again the second choice was not executed correctly
  * And some other small misfunctons.
  
### 07.05.2023 part 2 Update
  * Train option completed.
  * Fight engine completed.
  * Intro part is clear.
  * Made some other minor editting
  * Minor changes on the main code.

### 08.05.2023 Update
  * Completed the main core of the game
  * Added all the enemies
  * Fix some bugs like:
    * When the health droped below zero the Character was not death.
    * The Main Character was fighting only against the Dummy
    * No Character had Block chance added to their stats
    * And a few other minor ones.
  * Removed some unnecessary code.
  * When the main character, died the game continued.
