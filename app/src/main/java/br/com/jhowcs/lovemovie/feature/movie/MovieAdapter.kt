package br.com.jhowcs.lovemovie.feature.movie

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.jhowcs.lovemovie.R
import br.com.jhowcs.lovemovie.feature.movie.model.Movie
import br.com.jhowcs.lovemovie.network.api.ConfigurationApi
import com.bumptech.glide.Glide

class MovieAdapter(val movieList: ArrayList<Movie>): Adapter<ViewHolder>() {

    private val baseImageUrl = ConfigurationApi.mConfiguration.images.baseUrl

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        return MovieVH(inflater.inflate(R.layout.item_movie_popular, parent, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, position: Int) {
        if (viewHolder is MovieVH) {
            val movie = movieList[position]
            loadPoster(viewHolder.poster, movie.posterPath)
            viewHolder.title.text = movie.title
            viewHolder.releaseDate.text = movie.releaseDate
            viewHolder.voteAvg.text = "vote: ${movie.voteAverage.toString()}"
        }
    }

    private fun loadPoster(poster: ImageView, posterEndpoint: String) {
        Glide.with(poster)
                .load(baseImageUrl.plus("w185/").plus(posterEndpoint))
                .into(poster)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    private class MovieVH(itemView: View?) : ViewHolder(itemView) {
        val poster by lazy { itemView?.findViewById(R.id.imgPoster) as ImageView }
        val title by lazy { itemView?.findViewById(R.id.txtMovieTitle) as TextView }
        val releaseDate by lazy { itemView?.findViewById(R.id.txtReleaseDate) as TextView }
        val voteAvg by lazy { itemView?.findViewById(R.id.txtVoteAverage) as TextView }
    }
}