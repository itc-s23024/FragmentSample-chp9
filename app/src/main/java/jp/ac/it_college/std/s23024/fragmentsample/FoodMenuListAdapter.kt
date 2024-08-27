package jp.ac.it_college.std.s23024.fragmentsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.ac.it_college.std.s23024.fragmentsample.databinding.FoodMealRowBinding

class FoodMenuListAdapter(
    private  val  data: List<FoodMenu>,
    private val onItemSelected: (item: FoodMenu) -> Unit
):
    RecyclerView.Adapter<FoodMenuListAdapter.ViewHolder>(){

      class ViewHolder(private val  binding: FoodMealRowBinding) :
      RecyclerView.ViewHolder(binding.root) {

          var onItemClick: (item: FoodMenu) -> Unit = {}
          fun bind(item: FoodMenu) {
              binding.apply {
                  name.text = item.name
                  price.text = item.price.toString()
                  root.setOnClickListener { onItemClick(item) }
              }
          }
      }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context).let { inflater ->
            ViewHolder(FoodMealRowBinding.inflate(inflater, parent, false)).apply {
                onItemClick = onItemSelected
            }
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}