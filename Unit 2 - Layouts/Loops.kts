 fun main() {
	// WHILE LOOP
    val guestsPerFamily = listOf(2, 4, 1, 3)
    var totalGuests = 0
    var index = 0
    while (index < guestsPerFamily.size) {
        totalGuests += guestsPerFamily[index]
        index++
    }
    println("Total Guest Count: $totalGuests")
    
	//	FOR LOOP
    val names = listOf("Jessica", "Henry", "Alicia", "Jose")
    for (name in names) println("$name - Number of characters: ${name.length}")

    for (item in 'b'..'g') print(item) // Range of characters in an alphabet

    for (item in 1..5) print(item) // Range of numbers

    for (item in 5 downTo 1) print(item) // Going backward

    for (item in 3..6 step 2) print(item) // Prints: 35
}
