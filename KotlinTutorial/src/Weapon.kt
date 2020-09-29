class Weapon(val name: String, var attack: Int) {

    override fun toString(): String {
        return "$name with attack damage of $attack"
    }

}