package com.syfuzzaman.mvvm_android_skeleton.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.syfuzzaman.mvvm_android_skeleton.R
import com.syfuzzaman.mvvm_android_skeleton.data.network.api.User
import com.syfuzzaman.mvvm_android_skeleton.databinding.FragmentUserListBinding
import com.syfuzzaman.mvvm_android_skeleton.ui.common.BaseListItemCallback
import com.syfuzzaman.mvvm_android_skeleton.ui.utils.navigateTo
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.getValue

class UserListFragment : Fragment(), BaseListItemCallback<User> {
    private lateinit var binding: FragmentUserListBinding
    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var userListAdapter: UserListAdapter<User>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userListAdapter = UserListAdapter(this)

        with(binding.rvUserList){
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userListAdapter
        }

        observeData(limit = 10, offset = 0)
        viewModel.saveUsersData()

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            userListAdapter.loadStateFlow.collectLatest { loadStates ->
                val isLoading = loadStates.source.refresh is LoadState.Loading || loadStates.source.append is LoadState.Loading
                val isEmpty = userListAdapter.itemCount <= 0 && !loadStates.source.refresh.endOfPaginationReached
                val isEndOfPagination = loadStates.source.append is LoadState.NotLoading && loadStates.source.append.endOfPaginationReached

                binding.emptyView.isVisible = isEmpty && !isLoading
                binding.progressBar.isVisible = isLoading
                binding.rvUserList.isVisible = !(isEmpty && isLoading)

                if (isEndOfPagination) {
                    Toast.makeText(context, "No More Data Available", Toast.LENGTH_SHORT).show()
                }

                val errorState = loadStates.source.refresh as? LoadState.Error
                    ?: loadStates.source.append as? LoadState.Error
                    ?: loadStates.source.prepend as? LoadState.Error

                errorState?.let { error ->
                    binding.emptyView.text= "Error: ${error.error.message}"
                }
            }
        }

    }

    private fun observeData(limit: Int, offset: Int){
        lifecycleScope.launch {
            viewModel.getUsersData(limit, offset).collectLatest { data ->
                userListAdapter.submitData(data)
            }
        }
    }

    override fun onItemClicked(item: User) {
        super.onItemClicked(item)
        findNavController().navigateTo(R.id.userDetailsFragment)
    }
}