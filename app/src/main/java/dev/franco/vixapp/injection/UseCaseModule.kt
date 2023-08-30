package dev.franco.vixapp.injection

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.franco.vixapp.domain.FetchCategoriesUseCase
import dev.franco.vixapp.domain.FetchDetailContentUseCase
import dev.franco.vixapp.domain.FetchFreemiumContentUseCase
import dev.franco.vixapp.domain.FetchMainContentUseCase
import dev.franco.vixapp.domain.FetchPremiumContentUseCase
import dev.franco.vixapp.domain.UseCase
import javax.inject.Qualifier

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCaseModule {

    @CategoriesUseCase
    @Binds
    abstract fun bindsCategoriesUseCase(
        fetchCategoriesUseCase: FetchCategoriesUseCase,
    ): UseCase

    @DetailContentUseCase
    @Binds
    abstract fun bindsDetailContentUseCase(
        detailContentUseCase: FetchDetailContentUseCase,
    ): UseCase

    @FreemiumContentUseCase
    @Binds
    abstract fun bindsFreemiumContentUseCase(
        fetchFreemiumContentUseCase: FetchFreemiumContentUseCase,
    ): UseCase

    @MainContentUseCase
    @Binds
    abstract fun bindsMainContentUseCase(
        fetchMainContentUseCase: FetchMainContentUseCase,
    ): UseCase

    @PremiumContentUseCase
    @Binds
    abstract fun bindsPremiumContentUseCase(
        fetchPremiumContentUseCase: FetchPremiumContentUseCase,
    ): UseCase
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class CategoriesUseCase

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class DetailContentUseCase

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class FreemiumContentUseCase

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class MainContentUseCase

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class PremiumContentUseCase
