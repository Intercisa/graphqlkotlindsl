package com.expediagroup.graphql.demo.model

data class Prog(val name: String, val type: String, val statements: List<Statement>)

data class Statement(val name: String, val type: String, val inputs: MutableList<Input>, val outputs: List<Output>)

data class Input(val name: String, val type: String)

data class Output(val name: String, val type: String)
