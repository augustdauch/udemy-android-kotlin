class Player(val name: String, var lives: Int = 3, var level: Int = 1, var score: Int = 0) {
    var weapon = Weapon("Fist", 1)
    private var inventory = ArrayList<Loot>()

    fun show() {
        if (lives > 0) {
            println("$name is alive")
        } else {
            println("$name is dead")
        }
    }

    fun showInventory() {
        var total = 0.0
        println("$name's inventory:")
        for (item in inventory) {
            println(item)
            total += item.value
        }
        println("===============================")
        println("Total loot value: $total")
        println("===============================")
    }

    fun getLoot(loot: Loot) {
        inventory.add(loot)
    }

    fun dropLoot(loot: Loot): Boolean {
        return if (inventory.contains(loot)) {
            inventory.remove(loot)
            true
        } else {
            false
        }
    }

    fun dropLoot(name: String): Boolean {
        for (item in inventory) {
            if (item.name == name) {
                inventory.remove(item)
                return true
            }
        }
        println("$name is not in ${this.name}'s inventory")
        return false
    }

//    fun dropLoot(name: String): Boolean {
//        return inventory.removeIf { it.name == name }
//    }



    override fun toString(): String {
        return """
            name = $name
            lives = $lives
            level = $level
            score = $score
            weapon = $weapon
        """
    }
}