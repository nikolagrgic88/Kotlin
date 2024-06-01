fun <T> rollerCoasterFilter(filter: (T) -> Boolean, customerHeights: List<T>): List<T> {
    val newList = ArrayList<T>()
    for(d in customerHeights) {
        if(filter(d)) { newList.add(d); }
    }
    return newList;
}

fun main() {
    val heights = arrayListOf(120.0,135.0,162.0,140.0,150.0,180.0,200.0)
    val checkHeight:(Double)->Boolean={x:Double->x>=140}
    val result = rollerCoasterFilter(checkHeight,heights)
   for(i in result) println(i)

}