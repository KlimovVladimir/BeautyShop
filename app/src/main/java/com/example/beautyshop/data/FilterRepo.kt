package com.example.beautyshop.data

class FilterRepo {

    private var filters = mutableListOf(
        Filter(
            id = 1,
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