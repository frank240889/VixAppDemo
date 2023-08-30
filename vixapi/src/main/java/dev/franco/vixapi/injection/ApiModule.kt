package dev.franco.vixapi.injection

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.franco.vixapi.data.VixApi
import dev.franco.vixapi.data.local.Fetcher
import dev.franco.vixapi.data.local.LocalFetcherImpl
import dev.franco.vixapi.data.local.VixApiImplLocal
import dev.franco.vixapi.data.local.VixRepo
import dev.franco.vixapi.data.local.VixRepoImpl

@InstallIn(SingletonComponent::class)
@Module
abstract class ApiModule {
    @Binds
    abstract fun provideFetcher(localFetcherImpl: LocalFetcherImpl): Fetcher

    @Binds
    abstract fun provideApi(localApi: VixApiImplLocal): VixApi

    @Binds
    abstract fun bindsVixRepository(vixRepoImpl: VixRepoImpl): VixRepo
}
