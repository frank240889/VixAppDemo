package dev.franco.vixapp.helpers

import androidx.annotation.StringRes

/**
 * Access string resources without using context directly.
 */
interface ResourceManager {
    fun getString(@StringRes id: Int): String
}
