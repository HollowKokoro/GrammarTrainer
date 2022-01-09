package com.cyrillihotin.grammartrainer.controller

import com.cyrillihotin.grammartrainer.controller.options.OptionGenerator
import com.cyrillihotin.grammartrainer.model.Sentence
import com.cyrillihotin.grammartrainer.service.SentenceServiceImpl
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
class SentenceController(
    @Autowired private val service: SentenceServiceImpl
) {
    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    private fun index(
        @RequestParam id: Int,
        @RequestParam dbColumn: String
    ): String? {
        val found: Sentence = service.findById(id) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND, "Field with these parameters not found"
        )
        return Gson().toJson(OptionGenerator(found).generate())
    }
}