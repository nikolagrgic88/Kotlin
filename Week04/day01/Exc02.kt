import java.io.File
import java.util.ArrayList


val artistAlbum = HashMap<String, ArrayList<String>>()

fun main() {
    val searchingFor = readln()
    val res = searchingFor.split(" ")
    val command = res[0]
    val artist = res[1]

    search(command, artist)

}

fun search(command: String, artist: String) {

    val file = File("artists.csv")
    for (line in file.bufferedReader().lines()) {
        val spl = line.split(",")
        val name = spl[0]
        val album = spl[1]

        if (artistAlbum.containsKey(name)) {
            // if the artist already exists in the array add an album
            artistAlbum[name]?.add(album)
        } else {
            artistAlbum[name] = arrayListOf(album)
        }
    }
    for(i in artistAlbum){
        println(i)
    }

    if (command == "SEARCH") {
        for (v in artistAlbum) {
            if (artist == v.key) {
                for(alb in v.value){
                    println(alb)
                }
                println()
            }else{
                println("Artist doesn't exist")
            }
        }
    }
}

