fun main() {


    val hellsing = Player("Van Hellsing")
    hellsing.getLoot(Loot("Red Potion", LootType.POTION, 05.55))
    hellsing.getLoot(Loot("Blue Potion", LootType.POTION, 05.55))
    hellsing.getLoot(Loot("Green Potion", LootType.POTION, 05.55))
    hellsing.getLoot(Loot("Iron Boots", LootType.ARMOR, 07.50))
    hellsing.getLoot(Loot("Iron Gloves", LootType.ARMOR, 06.50))
    hellsing.getLoot(Loot("Iron Mail", LootType.ARMOR, 08.50))
    hellsing.getLoot(Loot("Ring of Fire", LootType.RING, 10.50))
    hellsing.getLoot(Loot("Ring of Wind", LootType.RING, 10.50))
    hellsing.getLoot(Loot("Ring of Ice", LootType.RING, 10.50))
    hellsing.getLoot(Loot("Ring of Gold", LootType.RING, 18.50))
    hellsing.getLoot(Loot("Ring of Gold", LootType.RING, 18.50))
    hellsing.getLoot(Loot("Ring of Gold", LootType.RING, 18.50))
    hellsing.getLoot(Loot("Ring of Silver", LootType.RING, 11.50))
    hellsing.getLoot(Loot("Ring of Silver", LootType.RING, 11.50))
    hellsing.getLoot(Loot("Ring of Silver", LootType.RING, 11.50))
    hellsing.showInventory()
    hellsing.dropLoot("Ring of Gold")
    hellsing.showInventory()
    hellsing.dropLoot("Ring of Diamond")
    hellsing.dropLoot("Ring of Sapphire")
    hellsing.dropLoot("Ring of Ruby")




}


