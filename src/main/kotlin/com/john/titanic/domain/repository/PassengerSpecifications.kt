package com.john.titanic.domain.repository

import com.john.titanic.domain.entities.Passenger
import jakarta.persistence.criteria.Predicate
import org.springframework.data.jpa.domain.Specification

object PassengerSpecifications {

    fun withSurvivedAndPclass(survived: Boolean?, pclass: Int?): Specification<Passenger> {
        return Specification { root, query, criteriaBuilder ->
            val predicates = mutableListOf<Predicate>()

            survived?.let {
                predicates.add(criteriaBuilder.equal(root.get<Boolean>("survived"), it))
            }

            pclass?.let {
                predicates.add(criteriaBuilder.equal(root.get<Int>("pclass"), it))
            }

            criteriaBuilder.and(*predicates.toTypedArray())
        }
    }

}