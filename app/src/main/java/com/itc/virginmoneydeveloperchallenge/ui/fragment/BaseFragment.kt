package com.itc.virginmoneydeveloperchallenge.ui.fragment

import android.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.itc.virginmoneydeveloperchallenge.ui.viewmodel.VirginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment : Fragment() {

    protected  val virginViewModel by lazy{
        ViewModelProvider(requireActivity())[VirginViewModel::class.java]
    }

    protected fun showError(message: String, action: () -> Unit) {
        AlertDialog.Builder(requireContext())
            .setTitle("Error")
            .setMessage(message)
            .setNegativeButton("DISMISS") { dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton("RETRY",) { _, _ ->
                action.invoke()
            }

    }

}