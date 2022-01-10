package com.cyrillihotin.grammartrainer.controller.options

import simplenlg.framework.NLGElement
import simplenlg.framework.WordElement
import simplenlg.lexicon.Lexicon
import simplenlg.realiser.english.Realiser

interface PartOfSpeechOptionGenerator {
    val lexicon: Lexicon
    val realised: Realiser
    val word: WordElement

    fun generate(inflected: NLGElement): String
    fun generateAll(): Set<String>
}