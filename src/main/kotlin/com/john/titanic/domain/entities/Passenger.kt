package com.john.titanic.domain.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "PASSENGER")
data class Passenger(
    @Id
    @Column(name = "PASSENGER_ID")
    val id: Long = 0,
    @Column(name = "SURVIVED")
    val survived: Boolean,
    @Column(name = "PCLASS")
    val pclass: Int,
    @Column(name = "NAME")
    val name: String,
    @Column(name = "SEX")
    val sex: String,
    @Column(name = "AGE")
    val age: Double?,
    @Column(name = "SIB_SP")
    val sibSp: Int,
    @Column(name = "PARCH")
    val parch: Int,
    @Column(name = "TICKET")
    val ticket: String,
    @Column(name = "FARE")
    val fare: Double,
    @Column(name = "CABIN")
    val cabin: String?,
    @Column(name = "EMBARKED")
    val embarked: String?
) {
    constructor() : this(0, false, 3, "", "", 0.0, 0, 0, "", 0.0, null, "")
}