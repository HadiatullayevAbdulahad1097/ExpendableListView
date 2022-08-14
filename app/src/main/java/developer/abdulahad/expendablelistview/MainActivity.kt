package developer.abdulahad.expendablelistview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import developer.abdulahad.expendablelistview.adapters.ExpendAdapters
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var titleList: ArrayList<String>
    lateinit var expendAdapters: ExpendAdapters
    lateinit var map: HashMap<String, ArrayList<String>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
        expendAdapters = ExpendAdapters(titleList, map)
        expend_list.setAdapter(expendAdapters)

        expend_list.setOnChildClickListener { expandableListView, view, i, i2, l ->
            Toast.makeText(this, "${map[titleList[i]]?.get(i2)}", Toast.LENGTH_SHORT).show()
            true
        }
    }

    private fun loadData() {

        map = HashMap()
        titleList = ArrayList()
        titleList.add("Android 7")
        titleList.add("Android 6")

        val list7 = ArrayList<String>()
        list7.add("Ramizbek")
        list7.add("Iskandar")
        list7.add("Muhammadzohid")
        list7.add("Firdavs")

        map[titleList[0]] = list7

        val list6 = ArrayList<String>()
        list6.add("Abubakir")
        list6.add("Shohruh")
        list6.add("Kamronbek")
        list6.add("Iqboljon")

        map[titleList[1]] = list6
    }
}