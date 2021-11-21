Wanzhi Wang, z1wang@bu.edu, U72807790
Shekhar Sharama, shekhars@bu.edu, U43306392
Balaji Udayakumar, balaji@bu.edu, U17952240

This program implements an RPG game: Legends of Valor, where the player form a team of three heroes
to fight against a team of monsters (controlled by computer). Heroes are placed on three different
lanes and for each round the player would choose the action for each hero (moving, fighting, teleporting etc.).
Once a hero breaks through monsters' defenses and reaches the opponent's base (Nexus), it counts as a win;
otherwise if a monster reaches hero's base, the player loses.

Execution:
>javac *.java
>java Main.java

Class description:
Armory:             subclass of gears, represents an armor item in the game.
Weaponry:           subclass of gears, represents a weapon item in the game.
Potion:             subclass of gears, represents a potion item in the game.
Fire_Spell:
Ice_Spell:
Lightning_Spell:
Spell:              subclass of gears, represents a spell item in the game.
Gear:               represent an item in the game.
Inventory:          represents a group of items carried by a unit (hero or market), classified by item type.
Market:             represents the market, capable of selling and purchasing items.

Warrior:
Sorcerer:
Paladin:
Hero:               subclass of character, represents a single hero character in the game.
Dragon：
Exoskeleton:
Spirit:
Monster:            subclass of character, represents a single monster character in the game.
Character:          represents a character in the game.
Hero_Team:          represents a group of heroes controlled by a single player.
Monster_Team:       represents a group of monsters as the player's opponent.

Bush_Cell:
Cave_Cell:
Plain_Cell:
Koulou_Cell:
Inaccessible_Cell:
Hero_Nexus_Cell:
Monster_Nexus_Cell:
Cell:
Game_Board:         represents the map of the game, also keep track of player's position.

Parser:             used to read game files and parse data into arrays.
Painter:
Music:
levelRequirement:  an interface used to check whether the hero's level is high enough to equip an item.
manaRequirement:   an interface used to check whether the hero's mana is enough to cast a spell.

LOV:                subclass of RPG, file that contains the main logic and element interaction of game Legends: Monsters and Heroes.
GameManager:        used for user to select different games.
RPG:                file that contains the major elements of a RPG.
Main:               the main file of the program.

Other info:
The program ensures the scalability of items and characters.
The game handles every possible invalid input.
The game has colored output.
The game has a music. (Music by Jason Shaw on Audionautix.com)