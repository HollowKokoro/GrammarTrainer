package com.cyrillihotin.grammartrainer.controller.options

import simplenlg.features.Feature
import simplenlg.features.NumberAgreement
import simplenlg.framework.LexicalCategory
import simplenlg.framework.NLGElement
import simplenlg.framework.NLGFactory
import simplenlg.framework.WordElement
import simplenlg.lexicon.Lexicon
import simplenlg.realiser.english.Realiser

class NounOptionGenerator(noun: String): PartOfSpeechOptionGenerator {
    override val lexicon: Lexicon = Lexicon.getDefaultLexicon()
    override val realised: Realiser = Realiser(lexicon)
    override val word: WordElement = lexicon.getWord(noun, LexicalCategory.NOUN)

    override fun generate(inflected: NLGElement): String = realised.realise(inflected).realisation
    override fun generateAll(): Set<String> = setOf(
        toSingular(),
        toPlural()
    )

    private val nlgFactory = NLGFactory(lexicon)

    private fun toSingular(): String {
        val inflected = nlgFactory.createNounPhrase(word.baseForm)
        inflected.setFeature(Feature.NUMBER, NumberAgreement.SINGULAR)
        return generate(inflected)
    }

    private fun toPlural(): String {
        val inflected = nlgFactory.createNounPhrase(word.baseForm)
        inflected.setFeature(Feature.NUMBER, NumberAgreement.PLURAL)
        return generate(inflected)
    }
}