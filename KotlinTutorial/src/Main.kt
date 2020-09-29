fun main() {
    val greenGoblin = Goblin("Green Goblin")
    println(greenGoblin)
    greenGoblin.takeDamage(15)
    greenGoblin.takeDamage(30)

    val alucard = Vampire("Alucard")
    println(alucard)
    alucard.takeDamage(30)

    val dracula = VampireKing("Dracula")
    println(dracula)
    dracula.takeDamage(100)


}


