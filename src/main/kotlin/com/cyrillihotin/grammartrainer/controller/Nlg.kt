package com.cyrillihotin.grammartrainer.controller

import com.cyrillihotin.grammartrainer.model.Sentence
import simplenlg.features.Feature
import simplenlg.features.Tense
import simplenlg.framework.InflectedWordElement
import simplenlg.framework.LexicalCategory
import simplenlg.lexicon.Lexicon
import simplenlg.realiser.english.Realiser

class Nlg(private val sentence: Sentence) {
    fun generate(): MutableList<String> {
        val lexicon = Lexicon.getDefaultLexicon()
        val sentenceEnglish = sentence.english.split(" ", ",", ".", "?", "!")
        val realised = Realiser(lexicon)
        val words: MutableList<String> = mutableListOf()
        sentenceEnglish.forEach {
            val word = lexicon.getWord(it, LexicalCategory.VERB)
            val inflected = InflectedWordElement(word)
            inflected.setFeature(Feature.TENSE, Tense.PAST)
            words.add(realised.realise(inflected).realisation)
        }
        return words
    }
}