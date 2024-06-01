open class Monster() {
    open fun makeNoise() {
        println("Monster: Grrrrrr")
    }

    open fun tryAndPetMe() {
        println("Monster: Attack!!!")
    }
}

class TamedMonster : Monster() {
    override fun makeNoise() {
        println("T Monster: silence....")
    }

    override fun tryAndPetMe() {
        println("T Monster: You can pet me...")
    }
}

fun main() {
    val monster = Monster()
    val tamedMonster = TamedMonster()

    monster.makeNoise()
    monster.tryAndPetMe()

    tamedMonster.makeNoise()
    tamedMonster.tryAndPetMe()

    val tamedMonsterRef:Monster=tamedMonster

    tamedMonsterRef.makeNoise()
    tamedMonsterRef.tryAndPetMe()
}