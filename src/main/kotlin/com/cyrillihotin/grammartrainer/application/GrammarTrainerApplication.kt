package com.cyrillihotin.grammartrainer.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GrammarTrainerApplication

fun main(args: Array<String>) {
    runApplication<GrammarTrainerApplication>(*args)
}