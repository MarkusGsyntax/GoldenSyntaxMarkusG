class Minion(name: String, hp: Int, magician: Magician, thief: Thief, warrior: Warrior) : Boss(name, hp, magician, thief, warrior) {


    fun isMinionAlive(): Boolean {
        return hp > 0
    }

    fun fireAttack(target: Hero) {
        val livingHeroes = listOf(magician, thief, warrior).filter { it.isHeroAlive() }
        if (livingHeroes.isNotEmpty()) {
            val randomTarget = livingHeroes.random()
            println("$name führt einen Feuerangriff auf ${randomTarget.name} aus.")
            randomTarget.takeDamage(25)
            println("${randomTarget.name} hat nun noch ${randomTarget.hp} Lebenspunkte!")
        }
    }

    fun poisonAttack() {
        val livingHeroes = listOf(magician, thief, warrior).filter { it.isHeroAlive() }
        if (livingHeroes.isNotEmpty()) {
            println("$name setzt Gift ein und vergiftet das Heldenteam.")
            for (hero in livingHeroes) {
                hero.takeDamage(9)
            }
        }
    }

    fun lifeSteal() {
        val livingHeroes = listOf(magician, thief, warrior).filter { it.isHeroAlive() }
        if (livingHeroes.isNotEmpty()) {
            val randomTarget = livingHeroes.random()
            println("$name stiehlt 25 Lebenspunkte von ${randomTarget.name}.")
            randomTarget.takeDamage(25)
            this.hp += 25
            println("$name hat nun ${this.hp} Lebenspunkte!")
            println("${randomTarget.name} hat nun noch ${randomTarget.hp} Lebenspunkte!")
        }
    }

    fun heal() {
        println("$name heilt sich selbst um 25 Lebenspunkte!")
        this.hp += 25
    }
}