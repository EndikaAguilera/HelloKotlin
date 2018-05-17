fun main(args: Array<String>) {
    println(whatShouldIDoToday("sad"))                                              // ---> Listen some music
    println(whatShouldIDoToday("bored"))                                            // ---> Watch a movie
    println(whatShouldIDoToday("mad", "Raining"))                           // ---> Make a Cheese Cake
    println(whatShouldIDoToday("happy", "Sunny", 32))           // ---> Go for a walk
    println(whatShouldIDoToday("tired", weather = "cloudy", temperature = 22))      // ---> Stay home and read
    println(whatShouldIDoToday("hungry", temperature = -12))                        // ---> Watch a movie
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String {
    return when {
        mood == "happy" && weather == "Sunny" -> "Go for a walk."
        mood == "bored" || temperature < 5 -> "Watch a movie."
        weather == "Raining" -> "Make a Cheese Cake."
        mood == "sad" -> "Listen some music."
        else -> "Stay home and read."
    }
}