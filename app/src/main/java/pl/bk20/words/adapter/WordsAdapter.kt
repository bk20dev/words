package pl.bk20.words.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import pl.bk20.words.R

class WordsAdapter(
    private val words: List<String>,
    private val onWordSelected: (String) -> Unit
) : RecyclerView.Adapter<WordsAdapter.WordsViewHolder>() {

    class WordsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val wordButton: Button = view.findViewById(R.id.word_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.word_button, parent, false)
        return WordsViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        val word = words[position]
        holder.wordButton.text = word
        holder.wordButton.setOnClickListener { onWordSelected(word) }
    }

    override fun getItemCount(): Int = words.size
}