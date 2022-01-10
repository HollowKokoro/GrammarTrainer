package com.cyrillihotin.grammartrainer.controller.options

import simplenlg.features.Feature
import simplenlg.features.Form
import simplenlg.features.Person
import simplenlg.features.Tense
import simplenlg.framework.InflectedWordElement
import simplenlg.framework.LexicalCategory.VERB
import simplenlg.framework.NLGElement
import simplenlg.framework.WordElement
import simplenlg.lexicon.Lexicon
import simplenlg.realiser.english.Realiser

class VerbOptionGenerator(verb: String): PartOfSpeechOptionGenerator {
    override val lexicon: Lexicon = Lexicon.getDefaultLexicon()
    override val realised: Realiser = Realiser(lexicon)
    override val word: WordElement = lexicon.getWord(verb, VERB)

    override fun generate(inflected: NLGElement): String = realised.realise(inflected).realisation
    override fun generateAll(): Set<String> = setOf(
        toPast(),
        toPastParticiple(),
        toPresent(),
        toPresentThird(),
        toFuture()
    )

    private fun toPast(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.TENSE, Tense.PAST)
        return generate(inflected)
    }

    private fun toPastParticiple(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.FORM, Form.PAST_PARTICIPLE)
        return generate(inflected)
    }

    private fun toPresent(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.PERSON, Person.FIRST)
        inflected.setFeature(Feature.TENSE, Tense.PRESENT)
        return generate(inflected)
    }

    private fun toPresentThird(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.PERSON, Person.THIRD)
        inflected.setFeature(Feature.TENSE, Tense.PRESENT)
        return generate(inflected)
    }

    private fun toFuture(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.TENSE, Tense.FUTURE)
        return "will " + generate(inflected)
    }
}