package pl.bk20.words

import android.content.Context
import androidx.annotation.ArrayRes

class Dictionary(context: Context, @ArrayRes wordsArrayRes: Int) {
    private val words = mutableMapOf<Char, MutableList<String>>()

    init {
        val resources = context.resources.getStringArray(wordsArrayRes)
        resources.forEach { word ->
            val letter = word.first().lowercaseChar()
            val currentWords = words[letter] ?: mutableListOf()
            currentWords.add(word)
            words[letter] = currentWords
        }
    }

    fun getLetters(): List<Char> {
        return words.keys.sorted()
    }

    fun getWords(letter: Char): List<String>? {
        return words[letter]?.sorted()
    }
}