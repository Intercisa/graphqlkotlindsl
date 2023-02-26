package com.expediagroup.graphql.demo.query

import com.expediagroup.graphql.demo.context.getInMemoryProgs
import com.expediagroup.graphql.demo.dsl.prog
import com.expediagroup.graphql.demo.model.Prog
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class ProgQuery : Query {
    fun getAllprog(progName: String?) = getInMemoryProgs().filter { p -> p.name.startsWith(progName ?: "") }

    fun getProg(progName: String?) = getInMemoryProgs().first()
}
