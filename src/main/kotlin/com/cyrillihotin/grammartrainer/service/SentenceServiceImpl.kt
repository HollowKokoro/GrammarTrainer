package com.cyrillihotin.grammartrainer.service

import com.cyrillihotin.grammartrainer.entity.Sentence
import com.cyrillihotin.grammartrainer.repository.SentenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable

@Service
class SentenceServiceImpl(
    @Autowired private val sentenceRepository: SentenceRepository
    ): SentenceService {

    override fun findById(@PathVariable id: Int): Sentence? {
        return sentenceRepository.findByIdOrNull(id)
    }
}