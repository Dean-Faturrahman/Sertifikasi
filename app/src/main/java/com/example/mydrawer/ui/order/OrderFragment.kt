package com.example.mydrawer.ui.order

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mydrawer.databinding.FragmentOrderBinding
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.*

class OrderFragment : Fragment() {

    private var _binding: FragmentOrderBinding? = null
    private var calendar = Calendar.getInstance()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.inputTanggal.keyListener = null
        binding.inputJam.keyListener = null
        dateDialog()
        timeDialog()
    }

    private fun dateDialog() {
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, month, day ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, day)
                setDate()
            }

        binding.inputTanggal.setOnClickListener {
            DatePickerDialog(
                requireActivity(),
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
            ).show()
        }
    }

    private fun setDate() {
        val customFormat = "dd/MM/yyyy"
        val format = SimpleDateFormat(customFormat, Locale.US)
        binding.inputTanggal.setText(format.format(calendar.time))
    }

    @SuppressLint("SetTextI18n")
    private fun timeDialog() {
        val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            calendar.set(Calendar.HOUR, hour)
            calendar.set(Calendar.MINUTE, minute)
            setTime()
        }

        binding.inputJam.setOnClickListener {
            TimePickerDialog(
                requireActivity(),
                timeSetListener,
                calendar.get(Calendar.HOUR),
                calendar.get(Calendar.MINUTE),
                true
            ).show()
        }
    }

    private fun setTime() {
        val customFormat = "hh:mm"
        val format = SimpleDateFormat(customFormat, Locale.US)
        binding.inputJam.setText(format.format(calendar.time))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}