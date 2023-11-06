class Magician(override var name: String, override var hp: Int) : Hero(name, hp) {


    fun fireball(targetDragon: Dragon, targetMinion: Minion, damage: Int) {
        if (targetDragon.isAlive) {
            println("$name wirft einen Feuerball auf ${targetDragon.name}.")
            targetDragon.takeDamage(damage)
        } else if (targetMinion.isMinionAlive()) {
            println("$name wirft einen Feuerball auf ${targetMinion.name}.")
            targetMinion.takeDamage(damage)
        } else {
            println("Es gibt keine lebenden Ziele für den Fireball.")
        }
    }

    fun healAllHeroes(heroes: List<Hero>) {
        if (isHeroAlive()) {
            println("$name wirkt einen Heilzauber auf das Heldenteam.")
            for (hero in heroes) {
                if (hero.isHeroAlive()) {
                    hero.hp += 40
                    println("${hero.name} hat nun ${hero.hp} Lebenspunkte.")
                }
            }
        }
    }

    fun protectHeroes(heroes: List<Hero>) {
        if (isHeroAlive()) {
            println("$name wirkt einen Schutzzauber auf das Heldenteam.")
            for (hero in heroes) {
                if (hero.isHeroAlive()) {
                    hero.protect()
                }
            }
        }
    }
}
