package com.kareem.respositorygit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.kareem.respositorygit.R
import com.kareem.respositorygit.model.GitRepo

class RepoAdapter (context: Context, private val values: List<GitRepo>): ArrayAdapter<GitRepo>(context, R.layout.list_item, values){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var row = convertView

        if (row == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            row = inflater.inflate(R.layout.list_item, parent, false)
        }
        val  textView = row!!.findViewById<View>(R.id.list_item_text) as TextView
        val item =  values[position]
        val message = item.name
        textView.text = message
        return row

    }
}