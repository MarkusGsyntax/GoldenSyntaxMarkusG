fun main() {
    val magician: Magician = Magician("Merlin", 150)
    val warrior: Warrior = Warrior("Artus", 200)
    val thief: Thief = Thief("Parzival", 110)
    val boss : Dragon = Dragon("Messoria", 350, magician, thief, warrior)

    var heroes = mutableListOf(magician, thief, warrior)
    var bosses = mutableListOf(boss)

    //while (boss.isDragonAlive() && magician.hp >0 || warrior.hp >0 || thief.hp >0) {
      //  boss.dragonActions()

    //}
    magician.healAllHeroes(heroes)
    magician.protectHeroes(heroes)
    boss.summonMinion()
    magician.fireball(boss,25)
}