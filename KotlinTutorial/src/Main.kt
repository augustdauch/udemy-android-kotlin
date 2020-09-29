fun main() {

    val aujan = Player("Aujan", 8, 4)
    aujan.weapon = Weapon("Sword", 10)
    aujan.show()

    val domdom = Player("Dom Dom", 5, 2, 1000)
    domdom.weapon = Weapon("Bow & Dagger", 8)
    domdom.show()

    domdom.weapon = aujan.weapon
    aujan.weapon = Weapon("Spear", 12)
    aujan.show()
    domdom.show()

    val ringOfFire = Loot("Ring of Fire", LootType.RING, 88.00)
    val redPotion = Loot("Red Potion", LootType.POTION, 5.00)
    val chestArmor = Loot("+5 Chest Armor", LootType.ARMOR, 99.99)
    aujan.getLoot(ringOfFire)
    aujan.getLoot(redPotion)
    aujan.getLoot(chestArmor)
    println(aujan)
    aujan.showInventory()
    aujan.getLoot(Loot("Invisibility Potion", LootType.POTION, 34.67))
    aujan.getLoot(Loot("+3 Iron Boots", LootType.ARMOR, 28.65))
    aujan.showInventory()

    if (aujan.dropLoot(redPotion)) {
        aujan.showInventory()
    } else {
        println("You don't have ${redPotion.name} in your inventory")
    }

    if (aujan.dropLoot("Invisibility Potion")) {
        aujan.showInventory()
    } else {
        println("You don't have Invisibility Potion in your inventory")
    }

    if (aujan.dropLoot("Invisibility Cloak")) {
        aujan.showInventory()
    } else {
        println("You don't have Invisibility Cloak in your inventory")
    }

}


