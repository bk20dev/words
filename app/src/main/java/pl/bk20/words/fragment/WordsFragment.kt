package pl.bk20.words.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pl.bk20.words.Dictionary
import pl.bk20.words.R
import pl.bk20.words.adapter.WordsAdapter
import pl.bk20.words.databinding.FragmentWordsBinding
import pl.bk20.words.util.Unsafe

class WordsFragment : Fragment() {
    private var binding by Unsafe<FragmentWordsBinding>()

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
        // TODO: Read the letter from action arguments
        val words = dictionary.getWords('a') ?: return
        binding.wordsList.apply {
            adapter = WordsAdapter(words) { TODO() }
            setHasFixedSize(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}