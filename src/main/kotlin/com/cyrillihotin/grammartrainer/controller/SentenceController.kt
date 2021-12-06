package com.cyrillihotin.grammartrainer.controller

import com.cyrillihotin.grammartrainer.model.Sentence
import com.cyrillihotin.grammartrainer.service.SentenceServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SentenceController(
    @Autowired private val service: SentenceServiceImpl
) {
    @GetMapping("{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    private fun index(@PathVariable id: Int): Sentence? {
        return service.findById(id)
    }
}