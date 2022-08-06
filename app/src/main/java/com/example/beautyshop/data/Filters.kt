package com.example.beautyshop.FilterList.SelectorActivity


    fun getFilters( id : Long ): MutableList<String> {
        if (id == PRODUCT_TYPE_ID)
            return product_types
        else if (id == PRODUCT_CATEGORY_ID)
            return product_categories
        else if (id == PRODUCT_TAGS_ID)
            return tags
        else if (id == BRANDS_ID)
            return brands
        else
            return brands
    }

    val PRODUCT_TYPE_ID : Long = 1
    val PRODUCT_CATEGORY_ID : Long = 2
    val PRODUCT_TAGS_ID : Long = 3
    val BRANDS_ID : Long = 4
    var PRICE_GREATER_THAN_ID : Long = 5
    var PRICE_LESS_THAN_ID : Long = 6
    var RATING_GRATER_THAN_ID : Long = 7


    var product_types = mutableListOf(
        "blush",
        "bronzer",
        "eyebrow",
        "eyeliner",
        "eyeshadow",
        "foundation",
        "lip liner",
        "lipstick",
        "mascara",
        "nail polish"
    )

    var product_categories = mutableListOf(
        "powder",
        "cream",
        "pencil",
        "liquid",
        "gel",
        "palette",
        "concealer",
        "contour",
        "bb cc",
        "mineral",
        "highlighter",
        "lipstick",
        "lip gloss",
        "lip stain"
    )

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

    var tags = mutableListOf(
        "Canadian",
        "CertClean",
        "Chemical Free",
        "Dairy Free",
        "EWG Verified",
        "EcoCert",
        "Fair Trade",
        "Gluten Free",
        "Hypoallergenic",
        "Natural",
        "No Talc",
        "Non-GMO",
        "Organic",
        "Peanut Free Product",
        "Sugar Free",
        "USDA Organic",
        "Vegan",
        "alcohol free",
        "cruelty free",
        "oil free",
        "purpicks",
        "silicone free",
        "water free"
    )