package pl.bk20.words.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pl.bk20.words.Dictionary
import pl.bk20.words.R
import pl.bk20.words.adapter.WordAdapter
import pl.bk20.words.databinding.FragmentWordsBinding
import pl.bk20.words.util.Unsafe

class WordsFragment : Fragment() {
    companion object {
        private const val SEARCH_URL = "https://www.google.com/search?q="
    }

    private var binding by Unsafe<FragmentWordsBinding>()
    private var letter: Char = 'a'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            letter = it.getString("letter")?.first() ?: return@let
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWordsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val dictionary = Dictionary(requireContext(), R.array.words)
        val words = dictionary.getWords(letter) ?: return
        binding.wordsList.apply {
            adapter = WordAdapter(words) { searchWord(it) }
            setHasFixedSize(true)
        }
    }

    private fun searchWord(word: String) {
        val uri = Uri.parse("$SEARCH_URL$word")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}