fun main(args: Array<String>) {
    eagerExample()
}

fun eagerExample() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

//    println(decorations.filter { true })            // prints [rock, pagoda, plastic plant, flowerpot]
//    println(decorations.filter { it[1] == 'l' })    // character pos 1 equals l -> prints [plastic plant, flowerpot]
//    println(decorations.filter { it == "rock" })    // word equals rock -> prints [rock]

    val eager = decorations.filter { it[0] == 'p' }
    println(eager)                              // prints -> [pagoda, plastic plant]

    // apply filter lazily
    val filtered = decorations.asSequence().filter { it[0] == 'p' || it[1] == '0' || it[2] == 'l' }
    println(filtered)
    println(filtered.toList())                  // prints -> [pagoda, plastic plant, alligator]


    // apply map lazily
    val lazyMap = decorations.asSequence().map {
        println("map: $it")                     // prints -> map: ('it' value)
        it
    }

    println(lazyMap)                            // since it's lazy it wont print anything
    println("first: ${lazyMap.firstOrNull()}")  // prints -> first: rock
    println("last: ${lazyMap.lastOrNull()}")    // prints -> last: flowerpot
    println("all: ${lazyMap.toList()}")         // prints -> all: [rock, pagoda, plastic plant, alligator, flowerpot]
}

fun filterCurries() {

    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")

    spices.filter { it.contains("curry") }.sortedBy { it.length }

    // Filtering by those that start with 'c' and end with 'e'
    spices.filter {it.startsWith('c') && it.endsWith('e') }     // -> [cayenne]
    // OR
    //spices.filter{it.startsWith('c')}.filter{it.endsWith('e')}           // -> [cayenne]

    // Filtering the first 3 items by 'c'
    spices.take(3).filter{it.startsWith('c')} //                  // -> [curry, cayenne]
}