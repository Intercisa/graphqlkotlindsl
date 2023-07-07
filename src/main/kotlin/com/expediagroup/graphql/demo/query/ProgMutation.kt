package com.expediagroup.graphql.demo.query

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.demo.context.getInMemoryProgs
import com.expediagroup.graphql.demo.dsl.prog
import com.expediagroup.graphql.demo.model.Prog
import com.expediagroup.graphql.spring.operations.Mutation
import org.springframework.stereotype.Component

@Component
class ProgMutation : Mutation {
    @GraphQLDescription("modifies Progs so it doesn't have null value")
    fun addProg(@GraphQLDescription("Prog to be modified") prog: Prog): Prog {
       return prog.let {
            setProgArr(it)
        }
    }
}

private fun setProgArr(prog: Prog): Prog {
    prog {
        name = prog.name
        type = prog.type
        prog.statements.forEach { statement ->
            statement {
                name = statement.name
                type = statement.type
                statement.args.forEach { output ->
                    output.name withType  output.type
                }
            }
        }
    }
    getInMemoryProgs().add(prog)
    return prog
}
