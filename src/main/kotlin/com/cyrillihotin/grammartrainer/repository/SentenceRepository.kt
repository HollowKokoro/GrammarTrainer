package com.cyrillihotin.grammartrainer.repository

import com.cyrillihotin.grammartrainer.entity.Sentence
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface SentenceRepository : CrudRepository<Sentence, Int>