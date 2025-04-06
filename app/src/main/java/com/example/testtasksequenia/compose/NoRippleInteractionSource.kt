package com.example.testtasksequenia.compose

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

object NoRippleInteractionSource: MutableInteractionSource {
    override suspend fun emit(interaction: Interaction) {

    }

    override fun tryEmit(interaction: Interaction): Boolean {
        return false
    }

    override val interactions: Flow<Interaction>
        get() = emptyFlow()

}