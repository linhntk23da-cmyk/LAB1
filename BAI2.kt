package com.example.affirmations.model

import kotlin.math.PI

// Lớp trừu tượng
abstract class Dwelling {
    abstract val buildingMaterial: String
    abstract fun floorArea(): Double
    open fun capacity(): Int = 1
    open fun hasRoom(): Boolean = true
}

// Lớp open
open class RoundHut(val residents: Int) {
    open fun floorArea(): Double = 3.14 * residents
}

// Lớp con mở rộng từ Dwelling
class SquareCabin(val floors: Int) : Dwelling() {
    override val buildingMaterial: String = "Wood"
    override fun floorArea(): Double {
        return 10.0 * floors
    }

    override fun capacity(): Int = floors * 2
    override fun hasRoom(): Boolean = capacity() > 0
}

// Hàm vararg đúng cú pháp
fun addToppings(vararg toppings: String) {
    println("Toppings: ${toppings.joinToString()}")
}

// MAIN
fun main() {
    // Danh sách chỉ đọc
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    println("Size: ${numbers.size}")
    println("First element: ${numbers[0]}")
    println("Reversed colors: " + listOf("red", "blue", "green").reversed())

    // Danh sách có thể thay đổi
    val entrees = mutableListOf<String>()
    entrees.add("spaghetti")
    entrees[0] = "lasagna"
    entrees.remove("lasagna")
    println("Entrees: $entrees")

    // Vòng lặp
    val myList = listOf("one", "two", "three")
    for (element in myList) {
        println(element)
    }
    var index = 0
    while (index < myList.size) {
        println(myList[index])
        index++
    }

    // Chuỗi
    val name = "Android"
    println("Length: ${name.length}")

    val number = 10
    println("$number people")

    val groups = 5
    println("${number * groups} people")

    // Toán tử gán tăng cường
    var a = 5
    val b = 3
    a += b
    a -= b
    a *= b
    a /= b
    println("Final a = $a")

    // Sử dụng with để đơn giản hóa việc truy cập vào một đối tượng
    val squareCabin = SquareCabin(3)
    with(squareCabin) {
        println("Capacity: ${capacity()}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
    }

    // Thư viện toán học
    val radius = 2.5
    println("Circle area: ${PI * radius * radius}")
    println("Circle area (qualified): ${kotlin.math.PI * radius * radius}")

    // Xâu chuỗi lệnh gọi
    val stringInTextField = "100".toString()
    println("String in text field: $stringInTextField")

    // Vararg demo
    addToppings("cheese", "mushroom", "pepperoni")
}
