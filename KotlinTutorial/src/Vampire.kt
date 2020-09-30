open class Vampire(name: String) : Enemy(name, 30, 3) {
    init {
        initHitPoints = 30
    }
    override fun takeDamage(damage: Int) {
        super.takeDamage(damage/2)
    }
}