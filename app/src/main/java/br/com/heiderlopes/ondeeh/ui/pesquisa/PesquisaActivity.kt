package br.com.heiderlopes.ondeeh.ui.pesquisa

import android.os.Bundle
import android.widget.Toast
import br.com.heiderlopes.ondeeh.R
import br.com.heiderlopes.ondeeh.base.BaseActivity
import br.com.heiderlopes.ondeeh.model.Endereco

class PesquisaActivity :  BaseActivity<PesquisaPresenter>(), PesquisaView {

    override fun instantiatePresenter(): PesquisaPresenter {
        return PesquisaPresenter(this)
    }

    override fun atualizaEndereco(endereco: Endereco) {
        Toast.makeText(this, endereco.logradouro, Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: String) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)
        presenter.loadPosts("04191270")
    }
}
