package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository
import br.com.igorbag.githubsearch.ui.MainActivity

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {


    var btnShareLister: (Repository) -> Unit = {}

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val repository = repositories[position]

        // Define o nome do repositório
        holder.repo.text = repository.name

        // Clique no botão compartilhar
        holder.share.setOnClickListener {
            btnShareLister(repository)
        }

        // Clique no item para abrir o navegador
        holder.itemView.setOnClickListener {

                val context = holder.itemView.context
                if (context is MainActivity) {
                    context.openBrowser(repository.htmlUrl)
                }
        }
    }
    
    // Pega a quantidade de repositorios da lista
    //@TODO 9 - realizar a contagem da lista
    override fun getItemCount(): Int {
        return repositories.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //@TODO 10 - Implementar o ViewHolder para os repositorios
        //Exemplo:
             var repo : TextView = view.findViewById(R.id.tv_repo)
             var  share : ImageView = view.findViewById(R.id.iv_share)
    }
}


