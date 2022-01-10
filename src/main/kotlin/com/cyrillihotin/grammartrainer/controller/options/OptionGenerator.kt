package com.cyrillihotin.grammartrainer.controller.options

import com.cyrillihotin.grammartrainer.model.Sentence
import simplenlg.framework.LexicalCategory

class OptionGenerator(sentence: Sentence) {

    private val words = sentence.english.split(' ', ',', '.', '?', '!')
    private val lexicalCategories = PartOfSpeech(sentence).extract()

    private fun indexOfWord(lexicalCategory: LexicalCategory) = words[lexicalCategories.indexOf(lexicalCategory)]

    fun generate(): List<Set<String>?> {
        return lexicalCategories.map {
            when(it) {
                LexicalCategory.VERB ->
                    VerbOptionGenerator(indexOfWord(LexicalCategory.VERB)).generateAll()
                LexicalCategory.PRONOUN ->
                    PronounOptionGenerator(indexOfWord(LexicalCategory.PRONOUN)).generateAll()
                LexicalCategory.NOUN ->
                    NounOptionGenerator(indexOfWord(LexicalCategory.NOUN)).generateAll()
                else -> {null}
            }
        }
    }
}