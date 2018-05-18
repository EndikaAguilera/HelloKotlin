fun main(args: Array<String>) {
    val simpleSpice = SimpleSpice()
    println("${simpleSpice.name} ${simpleSpice.spiciness} ${simpleSpice.heat}")
}

class SimpleSpice {

    val name: String = "curry"
    val spiciness: String = "mild"
    val heat: Int
        get() {
            return 5
        }
}