//Exercise 2
    val bottomStars = 7
    var x = 4

    for (i in 1..bottomStars step 2) {
        //print space
        --x
        for (j in 1..x) {
            print(" ")
        }
        // print stars
        for (j in 1..i) {
            print("*")
        }
        println()


    }
    //print trunk

        for(j in 1 .. bottomStars-5){
            print(" ")
        }
        for(j in 1 .. bottomStars-4){
            print("*")
        }
 
