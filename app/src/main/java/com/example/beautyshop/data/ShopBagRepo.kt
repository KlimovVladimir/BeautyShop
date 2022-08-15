package com.example.beautyshop.data

class ShopBagRepo {

    private var shops : MutableList<Makeup> = mutableListOf()

    fun getAll(): List<Makeup> = shops

    fun setAll(List: MutableList<Makeup>) {
        shops = List
    }

    fun get(id: Long): Makeup? = shops.firstOrNull { it.id == id }

    fun set(shop: Makeup) {
        val characterIndex = shops.indexOfFirst { it.id == shop.id }
        shops[characterIndex] = shop
    }

    fun add(shop: Makeup) {
        shops.add(shop)
    }

    fun remove(shop: Makeup) {
        shops.remove(shop)
    }
}