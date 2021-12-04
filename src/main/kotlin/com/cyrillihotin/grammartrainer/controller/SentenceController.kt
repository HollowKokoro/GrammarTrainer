package com.cyrillihotin.grammartrainer.controller

import com.cyrillihotin.grammartrainer.service.SentenceServiceImpl
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.ui.Model
import kotlin.reflect.full.declaredMemberProperties

@Controller
class SentenceController(
    @Autowired private val service: SentenceServiceImpl
) {

    private fun index(id: Int, field: String): Any? {
        val dbField = service.findById(id)
        if(dbField != null) {
            return requireNotNull(dbField::class.declaredMemberProperties
                .find { it.name == field }).call(dbField)
        }
        throw IllegalArgumentException("Record 'english' by id $id not found")
    }

    @GetMapping("/{id}")
    fun template(@PathVariable id: Int, model: Model): String {
        model.addAttribute("russian", index(id, "russian"))
        model.addAttribute("english", index(id, "english"))
        return "main"
    }
}