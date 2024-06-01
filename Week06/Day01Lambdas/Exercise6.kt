fun main() {
    var names = listOf<String>("Jeff", "David", "Jake", "Alicia", "Lyn", "Lauren")
    names.map { it.uppercase() }.forEach{ println(it) }

}