package br.com.jhowcs.lovemovie.feature.movie

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.jhowcs.lovemovie.R
import br.com.jhowcs.lovemovie.feature.movie.model.Movie

class MovieAdapter(val movieList: Array<Movie>): Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        return MovieVH(inflater.inflate(R.layout.item_movie_popular, parent, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, position: Int) {
        if (viewHolder is MovieVH) {
            viewHolder.title.text = movieList[position].title
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    private class MovieVH(itemView: View?) : ViewHolder(itemView) {
        val title by lazy { itemView?.findViewById(R.id.txtMovieTitle) as TextView }
    }
}