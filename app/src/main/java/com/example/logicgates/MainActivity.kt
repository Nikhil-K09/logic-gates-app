package com.example.logicgates

import android.content.Intent

import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.logicgates.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), GateClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        populateGates()
        val mainActivity=this
        binding.recyclerView.apply {
            layoutManager=GridLayoutManager(applicationContext,2)
            adapter=CardAdapter(gatelist,mainActivity)
        }
    }
    override fun onClick(gate:Gate){
        val intent=Intent(applicationContext,DetailActivity::class.java)
        intent.putExtra(GATE_ID_EXTRA,gate.id)
        startActivity(intent)
    }

    private fun populateGates() {
        val gate1=Gate(
            R.drawable.and,
            title="AND Gate",
            description = "adddddd"
        )
        gatelist.add(gate1)

        val gate2=Gate(
            R.drawable.or,
            title="OR Gate",
            description = "adddddd"
        )
        gatelist.add(gate2)

        val gate3=Gate(
            R.drawable.not,
            title="NOT Gate",
            description = "adddddd"
        )
        gatelist.add(gate3)

        val gate4=Gate(
            R.drawable.nand,
            title="NAND Gate",
            description = "adddddd"
        )
        gatelist.add(gate4)

        val gate5=Gate(
            R.drawable.nor,
            title="NOR Gate",
            description = "adddddd"
        )
        gatelist.add(gate5)
        val gate6=Gate(
            R.drawable.xor,
            title="XOR Gate",
            description = "adddddd"
        )
        gatelist.add(gate6)

        val gate7=Gate(
            R.drawable.xnor,
            title="XNOR Gate",
            description = "adddddd"
        )
        gatelist.add(gate7)

    }


}