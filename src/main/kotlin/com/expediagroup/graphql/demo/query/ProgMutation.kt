package com.expediagroup.graphql.demo.query

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.demo.context.getInMemoryProgs
import com.expediagroup.graphql.demo.dsl.prog
import com.expediagroup.graphql.demo.model.Input
import com.expediagroup.graphql.demo.model.Prog
import com.expediagroup.graphql.spring.operations.Mutation
import org.springframework.stereotype.Component

@Component
class ProgMutation : Mutation {
    @GraphQLDescription("modifies Progs so it doesn't have null value")
    fun addProg(@GraphQLDescription("Prog to be modified") prog: Prog): Prog {
       return prog.let {
            it.statements.map { statement -> statement.inputs.add(Input("Test001", "TypeTest001")) }
            setProgArr(it)
        }
    }
}

fun setProgArr(prog: Prog): Prog {
    prog {
        name = prog.name
        type = prog.type
        prog.statements.forEach { statement ->
            statement {
                name = statement.name
                type = statement.type
                statement.inputs.forEach { input ->
                    input.name withType input.type
                }
                statement.outputs.forEach { output ->
                    output.name withType output.type
                }
            }
        }
    }
    getInMemoryProgs().add(prog)
    return prog
}
