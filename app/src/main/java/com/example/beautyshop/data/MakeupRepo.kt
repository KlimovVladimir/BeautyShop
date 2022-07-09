package com.example.beautyshop.data

class MakeupRepo {

    private val makeups = mutableListOf(
        Makeup(
                id = 1048,
                brand = "colourpop",
                name = "Lippie Pencil",
                price = "5.0",
                price_sign = "$",
                currency = "CAD",
                image_link = "https://cdn.shopify.com/s/files/1/1338/0845/collections/lippie-pencil_grande.jpg?v=1512588769",
                product_link = "https://colourpop.com/collections/lippie-pencil",
                website_link = "https://colourpop.com",
                description = "Lippie Pencil A long-wearing and high-intensity lip pencil that glides on easily and prevents feathering. Many of our Lippie Stix have a coordinating Lippie Pencil designed to compliment it perfectly, but feel free to mix and match!",
                rating = null,
                category = "pencil",
                product_type = "lip_liner",
                tag_list = listOf("cruelty free", "Vegan"),
                created_at = "2018-07-08T23:45:08.056Z",
                updated_at = "2018-07-09T00:53:23.301Z",
                product_api_url = "http://makeup-api.herokuapp.com/api/v1/products/1048.json",
                api_featured_image = "//s3.amazonaws.com/donovanbailey/products/api_featured_images/000/001/048/original/open-uri20180708-4-13okqci?1531093614",
                product_colors = listOf(ProductColors("#B28378", "BFF Pencil"), ProductColors("#4D2D28", "Toolips Pencil"))
        ),
        Makeup(
            id = 1049,
            brand = "colourpop",
            name = "Lippie Pencil",
            price = "5.0",
            price_sign = "$",
            currency = "CAD",
            image_link = "https://cdn.shopify.com/s/files/1/1338/0845/collections/lippie-pencil_grande.jpg?v=1512588769",
            product_link = "https://colourpop.com/collections/lippie-pencil",
            website_link = "https://colourpop.com",
            description = "Lippie Pencil A long-wearing and high-intensity lip pencil that glides on easily and prevents feathering. Many of our Lippie Stix have a coordinating Lippie Pencil designed to compliment it perfectly, but feel free to mix and match!",
            rating = null,
            category = "pencil",
            product_type = "lip_liner",
            tag_list = listOf("cruelty free", "Vegan"),
            created_at = "2018-07-08T23:45:08.056Z",
            updated_at = "2018-07-09T00:53:23.301Z",
            product_api_url = "http://makeup-api.herokuapp.com/api/v1/products/1048.json",
            api_featured_image = "//s3.amazonaws.com/donovanbailey/products/api_featured_images/000/001/048/original/open-uri20180708-4-13okqci?1531093614",
            product_colors = listOf(ProductColors("#B28378", "BFF Pencil"), ProductColors("#4D2D28", "Toolips Pencil"))
        ),
        Makeup(
            id = 1050,
            brand = "colourpop",
            name = "Lippie Pencil",
            price = "5.0",
            price_sign = "$",
            currency = "CAD",
            image_link = "https://cdn.shopify.com/s/files/1/1338/0845/collections/lippie-pencil_grande.jpg?v=1512588769",
            product_link = "https://colourpop.com/collections/lippie-pencil",
            website_link = "https://colourpop.com",
            description = "Lippie Pencil A long-wearing and high-intensity lip pencil that glides on easily and prevents feathering. Many of our Lippie Stix have a coordinating Lippie Pencil designed to compliment it perfectly, but feel free to mix and match!",
            rating = null,
            category = "pencil",
            product_type = "lip_liner",
            tag_list = listOf("cruelty free", "Vegan"),
            created_at = "2018-07-08T23:45:08.056Z",
            updated_at = "2018-07-09T00:53:23.301Z",
            product_api_url = "http://makeup-api.herokuapp.com/api/v1/products/1048.json",
            api_featured_image = "//s3.amazonaws.com/donovanbailey/products/api_featured_images/000/001/048/original/open-uri20180708-4-13okqci?1531093614",
            product_colors = listOf(ProductColors("#B28378", "BFF Pencil"), ProductColors("#4D2D28", "Toolips Pencil"))
        ),
        Makeup(
            id = 1051,
            brand = "colourpop",
            name = "Lippie Pencil",
            price = "5.0",
            price_sign = "$",
            currency = "CAD",
            image_link = "https://cdn.shopify.com/s/files/1/1338/0845/collections/lippie-pencil_grande.jpg?v=1512588769",
            product_link = "https://colourpop.com/collections/lippie-pencil",
            website_link = "https://colourpop.com",
            description = "Lippie Pencil A long-wearing and high-intensity lip pencil that glides on easily and prevents feathering. Many of our Lippie Stix have a coordinating Lippie Pencil designed to compliment it perfectly, but feel free to mix and match!",
            rating = null,
            category = "pencil",
            product_type = "lip_liner",
            tag_list = listOf("cruelty free", "Vegan"),
            created_at = "2018-07-08T23:45:08.056Z",
            updated_at = "2018-07-09T00:53:23.301Z",
            product_api_url = "http://makeup-api.herokuapp.com/api/v1/products/1048.json",
            api_featured_image = "//s3.amazonaws.com/donovanbailey/products/api_featured_images/000/001/048/original/open-uri20180708-4-13okqci?1531093614",
            product_colors = listOf(ProductColors("#B28378", "BFF Pencil"), ProductColors("#4D2D28", "Toolips Pencil"))
        )
    )

    fun getAll(): List<Makeup> = makeups

    fun get(id: Long): Makeup? = makeups.firstOrNull { it.id == id }

    fun set(makeup: Makeup) {
        val characterIndex = makeups.indexOfFirst { it.id == makeup.id }
        makeups[characterIndex] = makeup
    }
}