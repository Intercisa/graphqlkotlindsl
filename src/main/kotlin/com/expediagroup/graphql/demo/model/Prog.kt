package com.expediagroup.graphql.demo.model

data class Prog(val name: String, val type: String, val statements: List<Statement>)

data class Statement(val name: String, val type: String, val args: List<Args>)

data class Args(val name: String, val type: String)
