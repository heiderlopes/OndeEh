package br.com.heiderlopes.ondeeh.ui.pesquisa

import br.com.heiderlopes.ondeeh.R
import br.com.heiderlopes.ondeeh.base.BasePresenter
import br.com.heiderlopes.ondeeh.network.EnderecoAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PesquisaPresenter(enderecoView: PesquisaView) : BasePresenter<PesquisaView>(enderecoView) {
    @Inject
    lateinit var enderecoApi: EnderecoAPI

    private var subscription: Disposable? = null

    override fun onViewCreated() {

    }

    fun loadPosts(cep: String) {
        view.showLoading()
        subscription = enderecoApi
                .pesquisar(cep)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        {
                            endereco -> view.atualizaEndereco(endereco)
                        },
                        {
                            view.showError(R.string.unknown_error)
                        }
                )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}