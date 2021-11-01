import kotlin.math.PI
import kotlin.math.sqrt

abstract class Dwelling(private var residents: Int) {
    abstract val name: String
    abstract val buildingMaterial: String
    abstract val capacity: Int
    
    fun hasRoom(): Boolean {
    	return residents < capacity
	}
   
	abstract fun floorArea(): Double
    
	fun getRoom() {
        if (capacity > residents) {
        	residents++
        	println("You got a room!")
        } else {
        	println("Sorry, at capacity and no rooms left.")
        }
    }
    
   open fun printValues() {
        println("\n${name}\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
   }
}

class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    override val name = "Square Cabin"
	override val buildingMaterial = "Wood"
    override val capacity = 6
    
    override fun floorArea(): Double {
		return length * length
	}
}

open class RoundHut(
    residents: Int,
	val radius: Double
) : Dwelling(residents) {
    override val name = "Round Hut"
    override val buildingMaterial = "Straw"
    override val capacity = 4
    
    override fun floorArea(): Double {
		return PI * radius * radius
	}
    
    fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }
    
    override fun printValues() {
        super.printValues()
        println("Carpet size: ${calculateMaxCarpetSize()}")
   }
}

class RoundTower(
    residents: Int,
    radius: Double,
	val floors: Int = 2
) : RoundHut(residents, radius) {
    override val name = "Round Tower"
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors
    
    override fun floorArea(): Double {
		return super.floorArea() * floors
	}
}

fun main() {
    val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)
      
    squareCabin.printValues()
    roundHut.printValues()
    roundTower.printValues()
}
