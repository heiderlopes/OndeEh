package br.com.heiderlopes.ondeeh.injection.component

import br.com.heiderlopes.ondeeh.base.BaseView
import br.com.heiderlopes.ondeeh.injection.module.ContextModule
import br.com.heiderlopes.ondeeh.injection.module.NetworkModule
import br.com.heiderlopes.ondeeh.ui.pesquisa.PesquisaPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {

    fun inject(enderecoPresenter: PesquisaPresenter)

    @Component.Builder
    interface Builder {

        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}