package pl.bk20.words.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import pl.bk20.words.Dictionary
import pl.bk20.words.R
import pl.bk20.words.adapter.LetterAdapter
import pl.bk20.words.databinding.FragmentLettersBinding
import pl.bk20.words.util.Unsafe

class LettersFragment : Fragment() {
    private var binding by Unsafe<FragmentLettersBinding>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLettersBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val dictionary = Dictionary(requireContext(), R.array.words)
        binding.letterList.apply {
            adapter = LetterAdapter(dictionary.getLetters()) { letter ->
                val directions =
                    LettersFragmentDirections.actionLettersFragmentToWordsFragment(letter = letter.toString())
                findNavController().navigate(directions)
            }
            layoutManager = GridLayoutManager(context, 4)
            setHasFixedSize(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}