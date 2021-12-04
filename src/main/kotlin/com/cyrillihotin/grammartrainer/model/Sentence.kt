package com.cyrillihotin.grammartrainer.model

import javax.persistence.*

@Entity
@Table(name="main")
data class Sentence(

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    val id: Int,

    val english: String,

    val russian: String
)
