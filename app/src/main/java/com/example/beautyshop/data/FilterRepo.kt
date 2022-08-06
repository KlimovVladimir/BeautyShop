package com.example.beautyshop.data

class FilterRepo {

    private var filters = mutableListOf(
        Filter(
            id = 1,
            item = ""
        ),
        Filter(
            id = 2,
            item = ""
        ),
        Filter(
            id = 3,
            item = ""
        ),
        Filter(
            id = 4,
            item = ""
        ),
        Filter(
            id = 5,
            item = ""
        ),
        Filter(
            id = 6,
            item = ""
        ),
        Filter(
            id = 7,
            item = ""
        )
    )

    fun getAll(): List<Filter> = filters

    fun setAll(List: MutableList<Filter>) {
        filters = List
    }

    fun get(id: Long): Filter? = filters.firstOrNull { it.id == id }

    fun set(filter: Filter) {
        val characterIndex = filters.indexOfFirst { it.id == filter.id }
        filters[characterIndex] = filter
    }
}