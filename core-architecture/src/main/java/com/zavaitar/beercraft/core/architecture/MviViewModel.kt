package com.zavaitar.beercraft.core.architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import com.zavaitar.beercraft.core.architecture.interfaces.MviEffect
import com.zavaitar.beercraft.core.architecture.interfaces.MviIntent
import com.zavaitar.beercraft.core.architecture.interfaces.MviState
import kotlinx.coroutines.CoroutineDispatcher

abstract class MviViewModel<S : MviState, I : MviIntent, E : MviEffect> : ViewModel() {

    val intents: Channel<I> = Channel(Channel.UNLIMITED)

    abstract val defaultState: S

    open lateinit var coroutinesDispatcher: CoroutineDispatcher

    private val _state by lazy { MutableStateFlow(defaultState) }
    val state: StateFlow<S> by lazy { _state }

    init {
        subscribeToIntents()
    }

    val effects = MutableSharedFlow<E>()

    abstract fun receiveIntent(intent: I)

    fun reduceState(reducer: S.() -> S) {
        updateState(_state.value.reducer())
    }

    private fun updateState(newState: S) {
        _state.value = newState
    }

    suspend fun postSideEffect(effect: E) {
        effects.emit(effect)
    }

    /**
        Make sure you set the coroutinesDispatcher before you use this function.
        Call this function only if viewmodelScope.launch is out of context to do an action.
        Else call @postSideEffect
     */
    fun postEffect(effect: E) {
        viewModelScope.launch {
            postSideEffect(effect)
        }
    }

    private fun subscribeToIntents() = viewModelScope.launch {
        intents.consumeAsFlow().collect { intent ->
            receiveIntent(intent)
        }
    }
}
