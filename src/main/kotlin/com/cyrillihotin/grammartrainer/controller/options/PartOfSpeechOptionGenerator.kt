package com.cyrillihotin.grammartrainer.controller.options

import simplenlg.framework.InflectedWordElement
import simplenlg.framework.WordElement
import simplenlg.lexicon.Lexicon
import simplenlg.realiser.english.Realiser

interface PartOfSpeechOptionGenerator {
    val lexicon: Lexicon
    val realised: Realiser
    val word: WordElement

    fun generate(inflected: InflectedWordElement): String
    fun generateAll(): Set<String>
}