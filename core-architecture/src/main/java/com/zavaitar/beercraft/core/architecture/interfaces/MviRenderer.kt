package com.zavaitar.beercraft.core.architecture.interfaces

interface MviRenderer<S : MviState, V : MviView, E : MviEffect> {
    fun render(state: S, view: V) {
    }
    fun react(effect: E, view: V) {
    }
}
