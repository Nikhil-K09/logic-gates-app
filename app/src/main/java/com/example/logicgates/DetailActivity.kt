package com.example.logicgates

import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.logicgates.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var sim_button_1:ToggleButton
    private lateinit var sim_button_2:ToggleButton
    private lateinit var sim_result:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val gateID= intent.getIntExtra(GATE_ID_EXTRA,-1)
        val gate=gateFromID(gateID)
        if(gate!=null) {
            binding.cover.setImageResource(gate.cover)
            binding.title.text=gate.title
            binding.description.text=gate.description
            binding.truthTable.setImageResource(gate.truth_table)
            binding.simulate.setImageResource(gate.simulate)

        }
        sim_button_1=findViewById(R.id.sim_button_1)
        sim_button_2=findViewById(R.id.sim_button_2)
        sim_result=findViewById(R.id.sim_result)

        //AND GATE
        if(binding.title.text=="AND Gate"){
            sim_button_1.setOnCheckedChangeListener { buttonView: CompoundButton, isChecked: Boolean ->
                if (sim_button_1.isChecked && sim_button_2.isChecked()) {
                    sim_result.text = "1"
                } else {
                    sim_result.text = "0"
                }
            }
            sim_button_2.setOnCheckedChangeListener { buttonView: CompoundButton, isChecked: Boolean ->
                if (sim_button_1.isChecked && sim_button_2.isChecked()) {
                    sim_result.text = "1"
                } else {
                    sim_result.text = "0"
                }
            }
        }
        //OR GATE
        else if(binding.title.text=="OR Gate") {
            sim_button_1.setOnCheckedChangeListener { buttonView: CompoundButton, isChecked: Boolean ->
                if (sim_button_1.isChecked || sim_button_2.isChecked()) {
                    sim_result.text = "1"
                } else {
                    sim_result.text = "0"
                }
            }
            sim_button_2.setOnCheckedChangeListener { buttonView: CompoundButton, isChecked: Boolean ->
                if (sim_button_1.isChecked || sim_button_2.isChecked()) {
                    sim_result.text = "1"
                } else {
                    sim_result.text = "0"
                }
            }
        }
        //NOT GATE
        else if(binding.title.text=="NOT Gate") {
            sim_result.setText("1")
            sim_button_1.setOnCheckedChangeListener { buttonView: CompoundButton, isChecked: Boolean ->
                if (sim_button_1.isChecked) {
                    sim_result.text = "0"
                } else {
                    sim_result.text = "1"
                }
            }
            sim_button_2.visibility = View.GONE
        }

        //NAND GATE
        if(binding.title.text=="NAND Gate"){
            sim_result.setText("1")
            sim_button_1.setOnCheckedChangeListener { buttonView: CompoundButton, isChecked: Boolean ->
                if (sim_button_1.isChecked && sim_button_2.isChecked()) {
                    sim_result.text = "0"
                } else {
                    sim_result.text = "1"
                }
            }
            sim_button_2.setOnCheckedChangeListener { buttonView: CompoundButton, isChecked: Boolean ->
                if (sim_button_1.isChecked && sim_button_2.isChecked()) {
                    sim_result.text = "0"
                } else {
                    sim_result.text = "1"
                }
            }
        }
        //NOR GATE
        else if(binding.title.text=="NOR Gate") {
            sim_result.setText("1")
            sim_button_1.setOnCheckedChangeListener { buttonView: CompoundButton, isChecked: Boolean ->
                if (sim_button_1.isChecked || sim_button_2.isChecked()) {
                    sim_result.text = "0"
                } else {
                    sim_result.text = "1"
                }
            }
            sim_button_2.setOnCheckedChangeListener { buttonView: CompoundButton, isChecked: Boolean ->
                if (sim_button_1.isChecked || sim_button_2.isChecked()) {
                    sim_result.text = "0"
                } else {
                    sim_result.text = "1"
                }
            }
        }

        //XOR Gate
        else if(binding.title.text=="XOR Gate") {
            sim_button_1.setOnCheckedChangeListener { buttonView: CompoundButton, isChecked: Boolean ->
                if (sim_button_1.isChecked == sim_button_2.isChecked()) {
                    sim_result.text = "0"
                } else {
                    sim_result.text = "1"
                }
            }
            sim_button_2.setOnCheckedChangeListener { buttonView: CompoundButton, isChecked: Boolean ->
                if (sim_button_1.isChecked == sim_button_2.isChecked()) {
                    sim_result.text = "0"
                } else {
                    sim_result.text = "1"
                }
            }
        }

        //XNOR Gate
        else if(binding.title.text=="XNOR Gate") {
            sim_result.setText("1")
            sim_button_1.setOnCheckedChangeListener { buttonView: CompoundButton, isChecked: Boolean ->
                if (sim_button_1.isChecked == sim_button_2.isChecked()) {
                    sim_result.text = "1"
                } else {
                    sim_result.text = "0"
                }
            }
            sim_button_2.setOnCheckedChangeListener { buttonView: CompoundButton, isChecked: Boolean ->
                if (sim_button_1.isChecked == sim_button_2.isChecked()) {
                    sim_result.text = "1"
                } else {
                    sim_result.text = "0"
                }
            }
        }

    }

    private fun gateFromID(gateID: Int): Gate? {
            for(gate in gatelist){
                if(gate.id==gateID){
                    return gate
                }
            }
            return null
    }
}