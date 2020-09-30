open class Enemy(val name: String, var hitPoints: Int, var lives: Int) {
    var initHitPoints = hitPoints


    open fun takeDamage(damage: Int) {
        if (hitPoints < 1) {
            println("$name is already dead")
        } else {
            val remainingHitPoints = hitPoints - damage;
            if (remainingHitPoints > 0) {
                hitPoints = remainingHitPoints
                println("$name took $damage damage, and has $hitPoints hp left")
            } else {
                lives -= 1
                if (lives > 0) {
                    println("$name took $damage damage, and lost a life")
                    hitPoints = initHitPoints
                } else {
                    hitPoints = 0
                    println("No lives left. $name is dead")
                }
            }
        }
    }

    override fun toString(): String {
        return "Name: $name, Hitpoints: $hitPoints, Lives: $lives"
    }


}