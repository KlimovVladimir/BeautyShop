package com.example.beautyshop.FilterList.SelectorActivity


    fun getFilters( id : Long ): MutableList<String> {
        if (id == BRANDS_ID)
            return brands
        else
            return brands
    }

    var BRANDS_ID : Long = 1

    var brands = mutableListOf(
        "almay",
        "alva",
        "anna sui",
        "annabelle",
        "benefit",
        "boosh",
        "burt's bees",
        "butter london",
        "c'est moi",
        "cargo cosmetics",
        "china glaze",
        "clinique",
        "coastal classic creation",
        "colourpop",
        "covergirl",
        "dalish",
        "deciem",
        "dior",
        "dr. hauschka",
        "e.l.f.",
        "essie",
        "fenty",
        "glossier",
        "green people",
        "iman",
        "l'oreal",
        "lotus cosmetics usa",
        "maia's mineral galaxy",
        "marcelle",
        "marienatie",
        "maybelline",
        "milani",
        "mineral fusion",
        "misa",
        "mistura",
        "moov",
        "nudus",
        "nyx",
        "orly",
        "pacifica",
        "penny lane organics",
        "physicians formula",
        "piggy paint",
        "pure anada",
        "rejuva minerals",
        "revlon",
        "sally b's skin yummies",
        "salon perfect",
        "sante",
        "sinful colours",
        "smashbox",
        "stila",
        "suncoat",
        "w3llpeople",
        "wet n wild",
        "zorah",
        "zorah biocosmetiques"
    )