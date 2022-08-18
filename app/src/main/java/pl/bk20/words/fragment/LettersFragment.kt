package pl.bk20.words.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pl.bk20.words.databinding.FragmentLettersBinding

class LettersFragment : Fragment() {
    private var _binding: FragmentLettersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLettersBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // TODO: Create bindings
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}