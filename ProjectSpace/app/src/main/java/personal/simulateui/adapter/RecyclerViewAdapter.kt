package personal.simulateui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import personal.simulateui.R

/**
 *
 * @author 顾荣林
 * 2023/3/6
 */
class RecyclerViewAdapter(private val textList: ArrayList<String>) :
        RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): MyViewHolder {
        val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_activity_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = textList.size ?: 0

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.txt.text = textList[position]
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "${holder.txt.text}", Toast.LENGTH_SHORT)
                    .show()
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txt: TextView = itemView.findViewById(R.id.txt)
    }
}