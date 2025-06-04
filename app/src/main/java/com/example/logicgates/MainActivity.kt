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
            description = "Definition: Outputs true (1) only when all inputs are true.\n" +
                    "\n" +
                    "Formula: A · B\n" +
                    "\n" +
                    "Example: 1 AND 1 = 1"
        )
        gatelist.add(gate1)

        val gate2=Gate(
            R.drawable.or,
            title="OR Gate",
            description = "Definition: Outputs true (1) if at least one input is true.\n" +
                    "\n" +
                    "Formula: A + B\n" +
                    "\n" +
                    "Example: 0 OR 1 = 1"
        )
        gatelist.add(gate2)

        val gate3=Gate(
            R.drawable.not,
            title="NOT Gate",
            description = "Definition: Inverts the input; outputs true if input is false and vice versa.\n" +
                    "\n" +
                    "Formula: ¬A or A̅\n" +
                    "\n" +
                    "Example: NOT 0 = 1"
        )
        gatelist.add(gate3)

        val gate4=Gate(
            R.drawable.nand,
            title="NAND Gate",
            description = "Definition: Outputs false (0) only when all inputs are true.\n" +
                    "\n" +
                    "Formula: ¬(A · B)\n" +
                    "\n" +
                    "Example: 1 NAND 1 = 0"
        )
        gatelist.add(gate4)

        val gate5=Gate(
            R.drawable.nor,
            title="NOR Gate",
            description = "Definition: Outputs true (1) only when all inputs are false.\n" +
                    "\n" +
                    "Formula: ¬(A + B)\n" +
                    "\n" +
                    "Example: 0 NOR 0 = 1"
        )
        gatelist.add(gate5)
        val gate6=Gate(
            R.drawable.xor,
            title="XOR Gate",
            description = "Definition: Outputs true (1) when inputs are different.\n" +
                    "\n" +
                    "Formula: A ⊕ B\n" +
                    "\n" +
                    "Example: 1 XOR 0 = 1"
        )
        gatelist.add(gate6)

        val gate7=Gate(
            R.drawable.xnor,
            title="XNOR Gate",
            description = "Definition: Outputs true (1) when inputs are the same.\n" +
                    "\n" +
                    "Formula: ¬(A ⊕ B)\n" +
                    "\n" +
                    "Example: 1 XNOR 1 = 1"
        )
        gatelist.add(gate7)

    }


}