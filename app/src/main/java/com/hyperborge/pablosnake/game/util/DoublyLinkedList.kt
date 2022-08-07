package com.hyperborge.pablosnake.game.util

class DoublyLinkedList<T> {

    private var first: Node<T>? = null
    private var last: Node<T>? = null

    fun addFirst(data: T) {
        val newFirst = Node(data)
        newFirst.next = first
        first?.prev = newFirst
        first = newFirst
    }

    fun addLast(data: T) {
        val newLast = Node(data)
        newLast.prev = last
        last?.next = newLast
        last = newLast
    }

    private class Node<T>(val data: T) {
        var next: Node<T>? = null
        var prev: Node<T>? = null
    }
}