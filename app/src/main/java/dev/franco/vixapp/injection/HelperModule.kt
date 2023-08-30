package dev.franco.vixapp.injection

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.franco.vixapp.helpers.ResourceManager
import dev.franco.vixapp.helpers.ResourceManagerImpl

@InstallIn(SingletonComponent::class)
@Module
abstract class HelperModule {
    @Binds
    abstract fun bindsResourceModule(resourceManagerImpl: ResourceManagerImpl): ResourceManager
}
