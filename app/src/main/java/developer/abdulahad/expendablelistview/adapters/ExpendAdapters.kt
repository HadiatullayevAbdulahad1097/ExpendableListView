package developer.abdulahad.expendablelistview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import developer.abdulahad.expendablelistview.R

class ExpendAdapters(private val titleList : List<String>, val map : HashMap<String , ArrayList<String>>) :
  BaseExpandableListAdapter() {
    override fun getGroupCount(): Int = titleList.size

    override fun getChildrenCount(p0: Int): Int {
      val title = titleList[p0]
      return map[title]?.size!!
    }

    override fun getGroup(p0: Int): Any {
        return titleList[p0]
    }

    override fun getChild(p0: Int, p1: Int): Any {
        val title = titleList[p0]
        return map[title]?.get(p1)!!
    }

    override fun getGroupId(p0: Int): Long {
       return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean = true

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        var itemView : View?
        if (p2 == null){
            itemView = LayoutInflater.from(p3?.context).inflate(R.layout.itam_group, p3, false)

        }else{
             itemView = p2
        }

        (itemView as TextView).text = titleList[p0]

         return itemView
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        var itemView : View?

        if (p3 != null){
            itemView = p3
        }else{
            itemView = LayoutInflater.from(p4?.context).inflate(R.layout.itam_child, p4, false)
        }

        (itemView as TextView).text = map[titleList[p0]]?.get(p1)

        return itemView
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean = true
}