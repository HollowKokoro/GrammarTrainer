package com.cyrillihotin.grammartrainer.repository

import com.cyrillihotin.grammartrainer.model.Sentence
import org.springframework.data.repository.CrudRepository

interface SentenceRepository : CrudRepository<Sentence, Int>