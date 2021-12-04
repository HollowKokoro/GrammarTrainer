package com.cyrillihotin.grammartrainer.entity

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
