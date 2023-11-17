open class Hero(val name: String, var hp: Int, var maxHp : Int) {

    val maxHP: Int = maxHp
    var isAlive = true
    private var isProtected = false

    fun protect() {
        if (!isProtected) {
            isProtected = true
            println("$name ist geschützt und wird vor Angriffen in der nächsten Runde bewahrt.")
        } else {
            println("$name ist bereits geschützt.")
        }
    }

    fun takeDamage(damage: Int) {
        if (isProtected) {
            println("$name ist geschützt und erleidet keinen Schaden in dieser Runde.")
            isProtected = false
        } else {
            hp -= damage
            Thread.sleep(1500)
            println("$name hat noch $hp Lebenspunkte!")
            if (hp <= 0) {
                isAlive = false
                println("$name ist gestorben!")
            }
        }
    }
}
