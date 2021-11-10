package com.zavaitar.beercraft.core.architecture

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.zavaitar.beercraft.core.architecture.interfaces.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

abstract class MviFragment<S : MviState, I : MviIntent, V : MviView, E : MviEffect> : MviView, Fragment() {

    abstract val mviViewModel: MviViewModel<S, I, E>
    abstract val mviRenderer: MviRenderer<S, V, E>
    abstract val mviView: V

    private lateinit var subscribeStateJob: Job
    private lateinit var subscribeEffectJob: Job

    fun sendIntent(intent: I) = lifecycleScope.launch {
        mviViewModel.intents.send(intent)
    }

    override fun onStart() {
        super.onStart()
        subscribeStateJob = lifecycleScope.launch {
            mviViewModel.state.filterNotNull().collect { state ->
                mviRenderer.render(state, mviView)
            }
        }

        subscribeEffectJob = lifecycleScope.launch {
            mviViewModel.effects.filterNotNull().collect { effect ->
                mviRenderer.react(effect, mviView)
            }
        }
    }

    override fun onStop() {
        subscribeStateJob.cancel()
        subscribeEffectJob.cancel()
        super.onStop()
    }
}
