package com.expediagroup.graphql.demo.dsl

import com.expediagroup.graphql.demo.model.Args
import com.expediagroup.graphql.demo.model.Prog
import com.expediagroup.graphql.demo.model.Statement

@DslMarker
annotation class ProgDSL

class StatementBuilder(@property:ProgDSL var name: String, @property:ProgDSL var type: String) {

    private val args = mutableListOf<Args>()

    fun build(): Statement {
        return Statement(name, type, args)
    }

    @ProgDSL
    infix fun String.withType(type: String) {
        args.add(Args(this, type))
    }
}

class ProgBuilder(@property:ProgDSL var name: String, @property:ProgDSL var type: String) {
    private val statements = mutableListOf<Statement>()

    @ProgDSL
    operator fun Statement.unaryPlus() {
        statements += this
    }

    @ProgDSL
    fun statement(name: String = "", type: String = "", setup: StatementBuilder.() -> Unit = {}) {
        val statementBuilder = StatementBuilder(name, type)
        statementBuilder.setup()
        statements += statementBuilder.build()
    }

    fun build(): Prog {
        return Prog(name, type, statements)
    }
}

@ProgDSL
fun prog(name: String = "", type: String = "", setup: ProgBuilder.() -> Unit): Prog {
    val progBuilder = ProgBuilder(name, type)
    progBuilder.setup()
    return progBuilder.build()
}
