package pl.bk20.words.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import pl.bk20.words.R

class LetterAdapter(
    private val letters: List<Char>,
    private val onSelect: (Char) -> Unit
) :
    RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    class LetterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val letterButton: Button = view.findViewById(R.id.letter_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.letter_button, parent, false)
        return LetterViewHolder(view)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val letter = letters[position]
        holder.letterButton.text = letter.toString()
        holder.letterButton.setOnClickListener { onSelect(letter) }
    }

    override fun getItemCount(): Int = letters.size
}