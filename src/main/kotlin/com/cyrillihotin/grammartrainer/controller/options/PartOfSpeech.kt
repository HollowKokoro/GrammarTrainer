package com.cyrillihotin.grammartrainer.controller.options

import com.cyrillihotin.grammartrainer.model.Sentence
import edu.stanford.nlp.pipeline.CoreDocument
import edu.stanford.nlp.pipeline.StanfordCoreNLP
import simplenlg.framework.LexicalCategory
import java.util.*

class PartOfSpeech(private val sentence: Sentence) {
    fun extract(): List<LexicalCategory> {
        val props = Properties()
        props.setProperty("annotators", "tokenize,ssplit,pos")
        val pipeline = StanfordCoreNLP(props)
        val document: CoreDocument = pipeline.processToCoreDocument(sentence.english)
        return document.tokens().map {
            when(it.tag().toString()) {
                "CC" -> LexicalCategory.CONJUNCTION
                "DT", "WDT" -> LexicalCategory.DETERMINER
                "IN" -> LexicalCategory.PREPOSITION
                "JJ" -> LexicalCategory.ADJECTIVE
                "MD" -> LexicalCategory.MODAL
                "NN", "NNS", "NNP", "NNPS" -> LexicalCategory.NOUN
                "PRP", "PRP$", "WP", "WP$" -> LexicalCategory.PRONOUN
                "VB", "VBD", "VBG", "VBN", "VBP", "VBZ" -> LexicalCategory.VERB
                "RB", "RBR", "RBS" -> LexicalCategory.ADVERB
                "SYM" -> LexicalCategory.SYMBOL
                else -> {LexicalCategory.ANY}
            }
        }
    }
}