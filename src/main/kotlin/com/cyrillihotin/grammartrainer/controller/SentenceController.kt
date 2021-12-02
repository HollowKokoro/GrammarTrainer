package com.cyrillihotin.grammartrainer.controller

import com.cyrillihotin.grammartrainer.service.SentenceServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class SentenceController(@Autowired val sentence: SentenceServiceImpl) {

    @GetMapping("/1")
    public fun index(@RequestParam id: Int, model: MutableMap<String, Any>): String {
        model["sentence"] = sentence
        return "main"
    }
}