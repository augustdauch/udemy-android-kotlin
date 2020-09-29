class VampireKing(name: String) : Vampire(name) {
    init {
        hitPoints = 100
    }

    override fun takeDamage(damage: Int) {
        super.takeDamage(damage / 2)
    }
}