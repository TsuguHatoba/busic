package com.example.busic.data

import com.squareup.moshi.Json

data class PotterBook(

	@Json(name="PotterBook")
	val potterBook: List<PotterBookItem?>? = null
)

data class Wand(

	@Json(name="core")
	val core: String? = null,

	@Json(name="length")
	val length: String? = null,

	@Json(name="wood")
	val wood: String? = null
)

data class PotterBookItem(

	@Json(name="patronus")
	val patronus: String? = null,

	@Json(name="hogwartsStudent")
	val hogwartsStudent: Boolean? = null,

	@Json(name="image")
	val image	: String? = null,

	@Json(name="ancestry")
	val ancestry: String? = null,

	@Json(name="gender")
	val gender: String? = null,

	@Json(name="alive")
	val alive: Boolean? = null,

	@Json(name="hairColour")
	val hairColour: String? = null,

	@Json(name="dateOfBirth")
	val dateOfBirth: String? = null,

	@Json(name="house")
	val house: String? = null,

	@Json(name="hogwartsStaff")
	val hogwartsStaff: Boolean? = null,

	@Json(name="alternate_names")
	val alternateNames: List<Any?>? = null,

	@Json(name="actor")
	val actor: String? = null,

	@Json(name="alternate_actors")
	val alternateActors: List<Any?>? = null,

	@Json(name="species")
	val species: String? = null,

	@Json(name="wand")
	val wand: Wand? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="wizard")
	val wizard: Boolean? = null,

	@Json(name="eyeColour")
	val eyeColour: String? = null,
)

data class PotterBuku(
	val potterBuku: List<PotterBukuItem?>? = null
)

data class PotterBukuItem(
	val patronus: String? = null,
	val hogwartsStudent: Boolean? = null,
	val image: String? = null,
	val ancestry: String? = null,
	val gender: String? = null,
	val alive: Boolean? = null,
	val hairColour: String? = null,
	val dateOfBirth: String? = null,
	val house: String? = null,
	val hogwartsStaff: Boolean? = null,
	val alternateNames: List<Any?>? = null,
	val actor: String? = null,
	val alternateActors: List<Any?>? = null,
	val species: String? = null,
	val wand: Wand? = null,
	val name: String? = null,
	val wizard: Boolean? = null,
	val eyeColour: String? = null,
)