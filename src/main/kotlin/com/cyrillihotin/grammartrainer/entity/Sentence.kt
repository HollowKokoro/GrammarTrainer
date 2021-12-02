package com.cyrillihotin.grammartrainer.entity

import javax.persistence.*

@Entity
@Table(name="main")
data class Sentence(

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private val id: Int,
    private val english: String,
    private val russian: String
)
