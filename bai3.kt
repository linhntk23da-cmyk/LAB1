package com.example.myapplication

import kotlin.math.PI

fun main() {
    // Nhóm
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    val setOfNumbers = numbers.toSet()
    println(setOfNumbers)

    val set1 = setOf(1, 2, 3)
    val set2 = mutableSetOf(3, 4, 5)
    println(set1.intersect(set2)) // [3]
    println(set1.union(set2))     // [1, 2, 3, 4, 5]

    // Sơ đồ (Map)
    val peopleAges = mutableMapOf(
        "Fred" to 30,
        "Ann" to 23
    )
    peopleAges["Barbara"] = 42
    peopleAges["Joe"] = 51

    peopleAges.forEach { print("${it.key} is ${it.value}, ") }
    println()
    println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", "))

    val filteredNames = peopleAges.filter { it.key.length < 4 }
    println(filteredNames)

    // Các phép toán khác trên tập hợp
    val words = listOf("about", "acute", "balloon", "best", "brief", "class")
    val filteredWords = words.filter { it.startsWith("b", ignoreCase = true) }
        .shuffled()
        .take(2)
        .sorted()
    println(filteredWords)

    // let
    val arguments: Map<String, String>? = mapOf("LETTER" to "A")
    arguments?.let {
        val letterId = it["LETTER"].toString()
        println(letterId)
    }

    // apply
    val binding: DummyBinding? = DummyBinding()
    binding?.apply {
        flavorFragment = "Demo"
        println(flavorFragment)
    }

    // Thuộc tính dự phòng
    val word = ScrambledWord()
    println(word.currentScrambledWord)

    // Lệnh gọi an toàn
    val intentExtras: Map<String, String>? = mapOf("letter" to "Z")
    val letterId = intentExtras?.get("letter").toString()
    println(letterId)

    // Toán tử Elvis
    var quantity: Int? = null
    println(quantity ?: 0) // nếu null thì in 0
    quantity = 4
    println(quantity ?: 0)

    // Hàm Lambda
    val triple: (Int) -> Int = { a: Int -> a * 3 }
    println(triple(5))

    // Đối tượng companion
    println(DetailActivity.LETTER)

    // Khởi tạo trễ (không dùng lateinit trong hàm main)
    val wordsList: MutableList<String> = mutableListOf()
    val currentWord: String = "banana"
    println("$wordsList, $currentWord")
}

// Giả lập binding
class DummyBinding {
    var flavorFragment: String = ""
}

// Thuộc tính dự phòng
class ScrambledWord {
    private var _currentScrambledWord = "test"
    val currentScrambledWord: String
        get() = _currentScrambledWord
}

// Companion object
class DetailActivity {
    companion object {
        const val LETTER = "letter"
    }
}
