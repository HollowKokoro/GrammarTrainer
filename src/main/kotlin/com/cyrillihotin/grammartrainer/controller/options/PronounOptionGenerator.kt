package com.cyrillihotin.grammartrainer.controller.options

import simplenlg.features.*
import simplenlg.framework.InflectedWordElement
import simplenlg.framework.LexicalCategory
import simplenlg.framework.NLGElement
import simplenlg.framework.WordElement
import simplenlg.lexicon.Lexicon
import simplenlg.realiser.english.Realiser

class PronounOptionGenerator(pronoun: String): PartOfSpeechOptionGenerator {
    override val lexicon: Lexicon = Lexicon.getDefaultLexicon()
    override val realised: Realiser = Realiser(lexicon)
    override val word: WordElement = lexicon.getWord(pronoun, LexicalCategory.PRONOUN)

    override fun generate(inflected: NLGElement): String = realised.realise(inflected).realisation
    override fun generateAll(): Set<String> = setOf(
        toSubjectFirstSingular(),
        toSubjectFirstPlural(),
        toSubjectSecondSingular(),
        toSubjectSecondPlural(),
        toSubjectThirdSingularMasculine(),
        toSubjectThirdSingularFeminine(),
        toSubjectThirdSingularNeutral(),
        toSubjectThirdPlural(),
        toObjectFirstSingular(),
        toObjectFirstPlural(),
        toObjectSecondSingular(),
        toObjectSecondPlural(),
        toObjectThirdSingularMasculine(),
        toObjectThirdSingularFeminine(),
        toObjectThirdPlural()
    )

    private fun toSubjectFirstSingular(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.PERSON, Person.FIRST)
        inflected.setFeature(Feature.NUMBER, NumberAgreement.SINGULAR)
        inflected.setFeature(InternalFeature.DISCOURSE_FUNCTION, DiscourseFunction.SUBJECT)
        return generate(inflected)
    }

    private fun toSubjectFirstPlural(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.PERSON, Person.FIRST)
        inflected.setFeature(Feature.NUMBER, NumberAgreement.PLURAL)
        inflected.setFeature(InternalFeature.DISCOURSE_FUNCTION, DiscourseFunction.SUBJECT)
        return generate(inflected)
    }

    private fun toSubjectSecondSingular(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.PERSON, Person.SECOND)
        inflected.setFeature(Feature.NUMBER, NumberAgreement.SINGULAR)
        inflected.setFeature(InternalFeature.DISCOURSE_FUNCTION, DiscourseFunction.SUBJECT)
        return generate(inflected)
    }

    private fun toSubjectSecondPlural(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.PERSON, Person.SECOND)
        inflected.setFeature(Feature.NUMBER, NumberAgreement.PLURAL)
        inflected.setFeature(InternalFeature.DISCOURSE_FUNCTION, DiscourseFunction.SUBJECT)
        return generate(inflected)
    }

    private fun toSubjectThirdSingularMasculine(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.PERSON, Person.THIRD)
        inflected.setFeature(Feature.NUMBER, NumberAgreement.SINGULAR)
        inflected.setFeature(LexicalFeature.GENDER, Gender.MASCULINE)
        inflected.setFeature(InternalFeature.DISCOURSE_FUNCTION, DiscourseFunction.SUBJECT)
        return generate(inflected)
    }

    private fun toSubjectThirdSingularFeminine(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.PERSON, Person.THIRD)
        inflected.setFeature(Feature.NUMBER, NumberAgreement.SINGULAR)
        inflected.setFeature(LexicalFeature.GENDER, Gender.FEMININE)
        inflected.setFeature(InternalFeature.DISCOURSE_FUNCTION, DiscourseFunction.SUBJECT)
        return generate(inflected)
    }

    private fun toSubjectThirdSingularNeutral(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.PERSON, Person.THIRD)
        inflected.setFeature(Feature.NUMBER, NumberAgreement.SINGULAR)
        inflected.setFeature(LexicalFeature.GENDER, Gender.NEUTER)
        inflected.setFeature(InternalFeature.DISCOURSE_FUNCTION, DiscourseFunction.SUBJECT)
        return generate(inflected)
    }

    private fun toSubjectThirdPlural(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.PERSON, Person.THIRD)
        inflected.setFeature(Feature.NUMBER, NumberAgreement.PLURAL)
        inflected.setFeature(InternalFeature.DISCOURSE_FUNCTION, DiscourseFunction.SUBJECT)
        return generate(inflected)
    }

    private fun toObjectFirstSingular(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.PERSON, Person.FIRST)
        inflected.setFeature(Feature.NUMBER, NumberAgreement.SINGULAR)
        inflected.setFeature(InternalFeature.DISCOURSE_FUNCTION, DiscourseFunction.OBJECT)
        return generate(inflected)
    }

    private fun toObjectFirstPlural(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.PERSON, Person.FIRST)
        inflected.setFeature(Feature.NUMBER, NumberAgreement.PLURAL)
        inflected.setFeature(InternalFeature.DISCOURSE_FUNCTION, DiscourseFunction.OBJECT)
        return generate(inflected)
    }

    private fun toObjectSecondSingular(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.PERSON, Person.SECOND)
        inflected.setFeature(Feature.NUMBER, NumberAgreement.SINGULAR)
        inflected.setFeature(InternalFeature.DISCOURSE_FUNCTION, DiscourseFunction.OBJECT)
        return generate(inflected)
    }

    private fun toObjectSecondPlural(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.PERSON, Person.SECOND)
        inflected.setFeature(Feature.NUMBER, NumberAgreement.PLURAL)
        inflected.setFeature(InternalFeature.DISCOURSE_FUNCTION, DiscourseFunction.OBJECT)
        return generate(inflected)
    }

    private fun toObjectThirdSingularMasculine(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.PERSON, Person.THIRD)
        inflected.setFeature(Feature.NUMBER, NumberAgreement.SINGULAR)
        inflected.setFeature(LexicalFeature.GENDER, Gender.MASCULINE)
        inflected.setFeature(InternalFeature.DISCOURSE_FUNCTION, DiscourseFunction.OBJECT)
        return generate(inflected)
    }

    private fun toObjectThirdSingularFeminine(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.PERSON, Person.THIRD)
        inflected.setFeature(Feature.NUMBER, NumberAgreement.SINGULAR)
        inflected.setFeature(LexicalFeature.GENDER, Gender.FEMININE)
        inflected.setFeature(InternalFeature.DISCOURSE_FUNCTION, DiscourseFunction.OBJECT)
        return generate(inflected)
    }
    
    private fun toObjectThirdPlural(): String {
        val inflected = InflectedWordElement(word)
        inflected.setFeature(Feature.PERSON, Person.THIRD)
        inflected.setFeature(Feature.NUMBER, NumberAgreement.PLURAL)
        inflected.setFeature(InternalFeature.DISCOURSE_FUNCTION, DiscourseFunction.OBJECT)
        return generate(inflected)
    }
}