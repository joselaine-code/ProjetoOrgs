package br.com.joselaine.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.joselaine.orgs.R
import br.com.joselaine.orgs.dao.ProdutosDAO
import br.com.joselaine.orgs.recycler.model.Produto
import kotlinx.android.synthetic.main.activity_formulario_produto.*
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_produto)
        btn_salvar.setOnClickListener {
            if (campo_nome.text.toString().trim().isEmpty() || campo_descricao.text.toString()
                    .trim().isEmpty() || campo_preco.text.toString().trim().isEmpty()
            ) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                val nome = campo_nome.text.toString()
                val descricao = campo_descricao.text.toString()
                val preco = campo_preco.text.toString()
                val p = Produto(nome, descricao, BigDecimal(preco))
                val dao = ProdutosDAO()
                dao.adiciona(p)
                finish()
            }
        }
    }
}
