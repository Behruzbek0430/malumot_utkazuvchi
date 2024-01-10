package com.example.vazifa131.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.vazifa131.R



class MyExpandAdapter(
    var context: Context,
    var titleList: ArrayList<String>,
    var map:HashMap<String, ArrayList<String>>
) : BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return titleList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return map[titleList[groupPosition]]?.size!!
    }

    override fun getGroup(groupPosition: Int): Any {
        return titleList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return map[titleList[groupPosition]]?.get(childPosition)!!
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var itemView:View
        if (convertView==null){
            itemView = LayoutInflater.from(parent?.context).inflate(R.layout.item_parent, parent, false)
        }else{
            itemView = convertView
        }

        itemView.findViewById<TextView>(R.id.tv_parent).text = titleList[groupPosition]
        return itemView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var itemView:View
        if (convertView!=null){
            itemView = convertView
        }else{
            itemView = LayoutInflater.from(parent?.context).inflate(R.layout.item_child, parent, false)
        }
        itemView.findViewById<TextView>(R.id.tv_child).text = map[titleList[groupPosition]]?.get(childPosition)
        return itemView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}
