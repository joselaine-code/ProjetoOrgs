package br.com.joselaine.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.joselaine.orgs.R
import br.com.joselaine.orgs.dao.ProdutosDAO
import br.com.joselaine.orgs.recycler.adapter.ListaDeProdutosAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val dao = ProdutosDAO()
    private val adapter = ListaDeProdutosAdapter(
        this, dao.buscaTodos()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
        configuraFab()
    }

    private fun configuraFab() {
        fab_add.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configuraRecyclerView() {
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.adapter = adapter
    }
}