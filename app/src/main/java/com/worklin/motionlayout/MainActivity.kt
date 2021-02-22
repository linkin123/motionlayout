package com.worklin.motionlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.worklin.motionlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var mfoodViewmodel: FoodViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        managerViewModel()
        setUpFood()
        initData()
        observers()
    }

    private fun getListFood(): List<Food> {
        return listOf(
            Food(
                1,
                "Hamburguesa",
                "clasica hamburguesa de res con lechuga, hitomate y pepiniloos",
                "https://firebasestorage.googleapis.com/v0/b/reference-lens-294723.appspot.com/o/hamburguesas.jpg?alt=media&token=bb23a51a-4f26-4af0-9786-eeedb7f6ce99",
                "75"
            ),
            Food(
                2,
                "Tacos",
                "tacos de cochinita pibil con frijoles y cebollitas estilo yucatan ",
                "https://firebasestorage.googleapis.com/v0/b/reference-lens-294723.appspot.com/o/tacos.jpg?alt=media&token=18d6dd20-26e3-40a6-a5c4-48c9ba9039ff",
                "55"
            ),
            Food(
                3,
                "Sushi",
                "Rollo clásico california por fuera masago, por dentro philadelphia, camaron, aguacate, salsa de soya y aderezo tampico",
                "https://firebasestorage.googleapis.com/v0/b/reference-lens-294723.appspot.com/o/sushi.jpeg?alt=media&token=37996269-c6b1-473f-a929-fc163eff90c6",
                "85"
            ),
            Food(
                4,
                "Pizza",
                "Pizza con masa delgada, con peperoni y un toque de especias, tamaño 45cm",
                "https://firebasestorage.googleapis.com/v0/b/reference-lens-294723.appspot.com/o/pizza.jpeg?alt=media&token=6d0e3a54-f116-4c03-b827-52b12fad5320",
                "120"
            ),
            Food(
                5,
                "Torta",
                "La clásica tota de milaneza, con jitomate, lechuga, aguacate y cebolla.",
                "https://firebasestorage.googleapis.com/v0/b/reference-lens-294723.appspot.com/o/tortas.jpeg?alt=media&token=89f82c65-f846-478b-b136-a24d1dea2caa",
                "65"
            )
        )
    }

    private fun observers() {
        mfoodViewmodel.listFoods.observe(this, Observer<List<Food>> { list ->
            foodAdapter.submitList(list)
        })
    }

    private fun initData() {
        mfoodViewmodel.setFood(getListFood())
    }

    private fun setUpFood() {
        foodAdapter = FoodAdapter()
        val linear = LinearLayoutManager(this)
        with(binding.rvFoods) {
            adapter = foodAdapter
            addItemDecoration(
                DividerItemDecoration(
                    context, linear.orientation
                )
            )
        }
    }

    private fun managerViewModel() {
        mfoodViewmodel = FoodViewmodel()
        binding.lifecycleOwner = this
        binding.foodViewModel = mfoodViewmodel
    }


}