package com.example.superhero.model

data class Superhero(
    val response: String,
    val id: String,
    val name: String,
    val powerstats: Powerstats,
    val biography: Biography,
    val appearance: Appearance,
    val work: Work,
    val connections: Connections,
    val image: Image
)

data class Powerstats(
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
)

data class Biography(
    val `full-name`: String,
    val `alter-egos`: String,
    val aliases: List<String>,
    val `place-of-birth`: String,
    val `first-appearance`: String,
    val publisher: String,
    val alignment: String
)

data class Appearance(
    val `gender`: String,
    val race: String,
    val height: List<String>,
    val weight: List<String>,
    val `eye-color`: String,
    val `hair-color`: String
)

data class Work(
    val occupation: String,
    val base: String
)

data class Connections(
    val `group-affiliation`: String,
    val relatives: String
)

data class Image(
    val url: String
)