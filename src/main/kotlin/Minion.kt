class Minion(name: String, hp: Int) : Dragon(name, hp) {

    fun fireAttack(heroes: MutableList<Hero>, damage: Int = 35) {
        val randomTarget = heroes.random()
        println("$name führt einen Feuerangriff auf ${randomTarget.name} aus.")
        randomTarget.takeDamage(damage)
    }


    fun poisonAttack(heroes: MutableList<Hero>, damage: Int = 15) {
        val randomTarget = heroes.random()
        println("$name setzt Gift ein und vergiftet $randomTarget.")
        randomTarget.hp -= (randomTarget.hp/0.20).toInt()
    }


    fun lifeSteal(heroes: MutableList<Hero>, damage: Int = 25) {
        val randomTarget = heroes.random()
        println("$name stiehlt $damage Lebenspunkte von ${randomTarget.name}.")
        randomTarget.takeDamage(damage)
        this.hp += 25
        println("$name hat nun ${this.hp} Lebenspunkte!")
    }


    fun heal() {
        println("$name heilt sich selbst um 25 Lebenspunkte!")
        this.hp += 25
        println("$name hat nun ${this.hp} Lebenspunkte!")
    }
}