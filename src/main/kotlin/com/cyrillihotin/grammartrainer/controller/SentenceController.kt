package com.cyrillihotin.grammartrainer.controller

import com.cyrillihotin.grammartrainer.service.SentenceServiceImpl
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.ui.Model

@Controller
class SentenceController(
    @Autowired private val service: SentenceServiceImpl
) {

    @GetMapping("/{id}")
    fun index(@PathVariable id: Int, model: Model): String {
        model.addAttribute("sentence", service.findById(id))
        return "main"
    }
}