interface Noisy{
    fun makeNoise():String
}
class Dog():Noisy{
    override fun makeNoise(): String {
return "Woof Woof"
    }
}

class Cat1():Noisy{
    override fun makeNoise(): String {
return "Miaow"
    }
}
class Person():Noisy{
    override fun makeNoise(): String {
return "Hello"
    }
}

fun theyBeLoud(noisyThings: List<Noisy>) {
    for(thing in noisyThings) {
        println(thing.makeNoise())
    }
}

fun main() {
    val dog = Dog()
    val cat = Cat1()
    val person = Person()

   val list:List<Noisy> = listOf(dog,cat,person)
    theyBeLoud(list)

}