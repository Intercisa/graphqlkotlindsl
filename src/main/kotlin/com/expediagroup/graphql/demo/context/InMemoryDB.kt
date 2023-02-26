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
            "Input01" withType "001"
            "Input02" withType "002"
            "Output001" withType  "001"
            "Output002" withType  "002"
        }
        statement{
            name = "Statement002"
            type = "SType002"
            "Input0101" withType "00101"
            "Input0202" withType "00202"
            "Output00101" withType  "00101"
            "Output00202" withType  "00202"
        }
    }
)
