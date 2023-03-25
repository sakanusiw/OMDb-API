package com.example.omdbapi.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.omdbapi.MovieAdapter
import com.example.omdbapi.R
import com.example.omdbapi.RClient
import com.example.omdbapi.databinding.FragmentDataBinding
import com.example.omdbapi.modeldata.MovieData
import com.example.omdbapi.modeldata.SearchData
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DataFragment : Fragment() {
    private var _binding: FragmentDataBinding? = null
    private val binding get() = _binding!!
    private val list = ArrayList<MovieData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDataBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager = LinearLayoutManager(context)

        RClient.instances.getMovies().enqueue(object: Callback<SearchData> {
            override fun onResponse(call: Call<SearchData>, response: Response<SearchData>){
                val responseCode = response.code()

                response.body()?.let { list.addAll(it.data) }
                val adapter = MovieAdapter(list)
                binding.rvData.adapter = adapter
            }

            override fun onFailure(call: Call<SearchData>, t:Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}