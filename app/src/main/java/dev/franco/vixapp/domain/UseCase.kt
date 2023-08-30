package dev.franco.vixapp.domain

import kotlinx.coroutines.flow.Flow

/**
 * A generalization for actions and flows in app.
 */
interface UseCase {
    suspend operator fun invoke(vararg params: String? = emptyArray()): Flow<Result>
}

/**
 * Generic result for [UseCase].
 */
sealed class Result
