import java.io.File

fun main() {

print("How do you want to call your file? ")
    var userInput = readlnOrNull()
    val file = File("$userInput.txt")
    val writer = file.printWriter()

    println("Now you can start adding text to your folder: ")
    while(userInput!=null){
        if(userInput=="EXIT")break
        userInput = readlnOrNull()
        writer.println(userInput)
        writer.flush()
    }
writer.close()
}
