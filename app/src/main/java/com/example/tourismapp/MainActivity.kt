package com.example.tourismapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.places.view.*

class MainActivity : AppCompatActivity() {
    private var listOfMonuments = ArrayList<monument>()
    var adapter: MonumentAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listOfMonuments.add(
            monument("TAJ MAHAL", "It is a famous place located in Agra,India.", R.drawable.taj)
        )
        listOfMonuments.add(
            monument("FRANCE", "It is a famous European country.", R.drawable.france)
        )
        listOfMonuments.add(
            monument("PETRA", "It is a famous for its historic monuments.", R.drawable.petra)
        )
        listOfMonuments.add(
            monument("MALDIVES", "It is a famous island country.", R.drawable.maldives)
        )
        listOfMonuments.add(
            monument("STATUE OF LIBERTY", "It is a famous statue in New York.", R.drawable.statue)
        )
        listOfMonuments.add(
            monument("LONDON", "It is a famous British city.", R.drawable.london)
        )
        listOfMonuments.add(
            monument("SINGAPORE", "This country is famous for its majestic architecture.", R.drawable.sing)
        )
        listOfMonuments.add(
            monument("SWITZERLAND", "It is a famous for its beautiful mountains.", R.drawable.swiz)
        )
        adapter = MonumentAdapter(this,listOfMonuments)
        lists.adapter = adapter

    }
//    fun delete(index:Int){
//        listOfMonuments.removeAt(index)
//        adapter!!.notifyDataSetChanged()
//    }

     inner class MonumentAdapter: BaseAdapter{

        var listOfMonuments=ArrayList<monument>()
        var context:Context?=null
        constructor(context: Context, listOfMonuments: ArrayList<monument>):super(){
                 this.listOfMonuments=listOfMonuments
                 this.context=context

        }
        override fun getCount(): Int {
            return listOfMonuments.size
        }

        override fun getItem(p0: Int): Any {
            return listOfMonuments[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val Monument=listOfMonuments[p0]
            var inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView=inflator.inflate(R.layout.places,null)
            myView.tvName.text=Monument.name!!
            myView.tvDesc.text=Monument.info!!
            myView.images.setImageResource(Monument.pic!!)
            myView.images.setOnClickListener{
                val intent= Intent(context,MainActivity2::class.java)
                intent.putExtra("name",Monument.name!!)
                intent.putExtra("info",Monument.info!!)
                intent.putExtra("pic",Monument.pic!!)
                context!!.startActivity(intent)
//                delete(p0)
            }
            return myView
        }

    }
}

