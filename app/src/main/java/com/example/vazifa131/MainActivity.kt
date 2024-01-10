package com.example.vazifa131

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import com.example.vazifa131.Mobiles.MI
import com.example.vazifa131.adapters.MyExpandAdapter
import com.example.vazifa131.databinding.ActivityMainBinding
import com.example.vazifa131.databinding.ActivityMiBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myExpandAdapter: MyExpandAdapter

    lateinit var map: HashMap<String, ArrayList<String>>
    lateinit var titleList:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
        myExpandAdapter = MyExpandAdapter(this, titleList, map)
        binding.rc.setAdapter(myExpandAdapter)

        binding.rc.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            var t1 = map[titleList[groupPosition]]?.get(childPosition)
            val intent = Intent(this, MI::class.java)
            intent.putExtra("key", t1)
            startActivity(intent)
            true
        }



    }

    private fun loadData() {
        titleList = ArrayList()
        titleList.add("Mobiles")
        titleList.add("Laptops")
        titleList.add("Computer Accessories")
        titleList.add("TVs by brand")
        titleList.add("Kitchen Appliances")

        map = HashMap()
        map[titleList[0]] = arrayListOf("Mi", "RealMe", "Samsung", "Infinix", "Oppo", "Apple", "Honor")


        map[titleList[1]] = arrayListOf("Dell", "Mac", "HP", "Asus")


        map[titleList[2]] = arrayListOf("Pendrive", "Bag", "Mouse", "Keyboard")


        map[titleList[3]] = arrayListOf("Lg", "TCL", "Samsung", "Vizio", "Hisense", "Sony")


        map[titleList[4]] = arrayListOf("kettle", "oven", "dishwasher", "fridge", "mixer", "juicer")
    }
}

