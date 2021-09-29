package com.jss.rabbitPublisherProject

import java.io.Serializable

data class SimpleMessage(private var name: String, private var description: String) : Serializable
