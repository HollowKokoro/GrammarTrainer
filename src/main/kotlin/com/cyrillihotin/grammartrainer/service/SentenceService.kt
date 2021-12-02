package com.cyrillihotin.grammartrainer.service

import com.cyrillihotin.grammartrainer.entity.Sentence
import org.springframework.stereotype.Service

@Service
interface SentenceService {
    fun findById(id: Int): Sentence?
}