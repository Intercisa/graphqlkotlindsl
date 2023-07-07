package com.expediagroup.graphql.demo.context

import com.expediagroup.graphql.demo.dsl.prog
import com.expediagroup.graphql.demo.model.Prog

private val progs: MutableList<Prog> = arrayListOf()

fun getInMemoryProgs(): MutableList<Prog>{
    progs.addAll(getProgArr())
    return progs
}

fun getProgArr() = listOf(
    prog {
        name = "Prog001"
        type = "PType001"
        statement{
            name = "Statement001"
            type = "SType001"
            "Arg001" withType  "001"
            "Arg002" withType  "002"
        }
        statement{
            name = "Statement002"
            type = "SType002"
            "Arg00101" withType   "00101"
            "Arg00202" withType   "00202"
        }
    }
)
